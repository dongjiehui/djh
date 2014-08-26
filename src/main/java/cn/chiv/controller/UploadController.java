package cn.chiv.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("upload_json")
public class UploadController {

	@RequestMapping(value = "upload", consumes = "multipart/form-data")
	public void upload(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// 文件保存目录路径 img_upload是服务器存储上传图片的目录名
		String savePath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "attached/";
		// 文件保存目录URL
		String saveUrl = request.getContextPath() + "/attached/";
		// 定义允许上传的文件扩展名
		String[] fileTypes = new String[] { "gif", "jpg", "jpeg", "png", "bmp" };
		// 允许最大上传文件大小
		long maxSize = 1024 * 5000;
		// Struts2 请求 包装过滤器
		
		
		MultipartHttpServletRequest  wrapper = (MultipartHttpServletRequest ) request;
		// 获得上传的文件名
		String fileName = wrapper.getFile("imgFile").getOriginalFilename();
		
		
		// 获得文件过滤器
		
		
		// 得到上传文件的扩展名
		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1)
				.toLowerCase();
		// 检查扩展名
		if (!Arrays.<String> asList(fileTypes).contains(fileExt)) {
			response.getWriter().write(getError("上传文件扩展名是不允许的扩展名。"));
		}
		// 检查文件大小
//		if (file.length() > maxSize) {
//			response.getWriter().write(getError("上传文件大小超过限制。"));
//		}
		// 检查目录
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM");
		String dir = sdf.format(new Date());
		File uploadDir = new File(savePath + dir);
		uploadDir.mkdirs();
		if (!uploadDir.isDirectory()) {
			response.getWriter().write(getError("上传目录不存在 。"));
		}
		// 检查目录写入权限
		if (!uploadDir.canWrite()) {
			response.getWriter().write(getError("上传目录没有写入权限。"));
		}
		// 重构上传图片的名称
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		String newImgName = df.format(new Date()) + "_"
				+ new Random().nextInt(1000) + "." + fileExt;
		// 设置 KE 中的图片文件地址
		String newFileName = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ saveUrl + dir + "/" + newImgName;
		byte[] buffer = new byte[1024];
		// 获取文件输出流
		FileOutputStream fos = new FileOutputStream(savePath + dir + "/"
				+ newImgName);
		// 获取内存中当前文件输入流
		//InputStream in = new FileInputStream(file);
		InputStream in = wrapper.getFile("imgFile").getInputStream();
		try {
			int num = 0;
			while ((num = in.read(buffer)) > 0) {
				fos.write(buffer, 0, num);
			}
		} catch (Exception e) {
			e.printStackTrace(System.err);
		} finally {
			in.close();
			fos.close();
		}
		// 发送给 KE
		JSONObject obj = new JSONObject();
		obj.put("error", 0);
		obj.put("url", saveUrl + dir + "/" + newImgName);
		response.getWriter().write(obj.toJSONString());
	}

	private String getError(String message) {
		JSONObject obj = new JSONObject();
		obj.put("error", 1);
		obj.put("message", message);
		return obj.toJSONString();
	}

	@RequestMapping("fileManagerJson")
	public void fileManagerJson(HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		// 根目录路径，可以指定绝对路径，比如 /var/www/attached/
		String rootPath = request.getSession().getServletContext()
				.getRealPath("/")
				+ "attached/";
		// 根目录URL，可以指定绝对路径，比如 http://www.yoursite.com/attached/
		String rootUrl = request.getContextPath() + "/attached/";
		// 图片扩展名
		String[] fileTypes = new String[] { "gif", "jpg", "jpeg", "png", "bmp" };

		String dirName = request.getParameter("dir");
		if (dirName != null) {
			if (!Arrays.<String> asList(
					new String[] { "image", "flash", "media", "file" })
					.contains(dirName)) {
				response.getWriter().write("Invalid Directory name.");
				return;
			}
			rootPath += dirName + "/";
			rootUrl += dirName + "/";
			File saveDirFile = new File(rootPath);
			if (!saveDirFile.exists()) {
				saveDirFile.mkdirs();
			}
		}
		// 根据path参数，设置各路径和URL
		String path = request.getParameter("path") != null ? request
				.getParameter("path") : "";
		String currentPath = rootPath + path;
		String currentUrl = rootUrl + path;
		String currentDirPath = path;
		String moveupDirPath = "";
		if (!"".equals(path)) {
			String str = currentDirPath.substring(0,
					currentDirPath.length() - 1);
			moveupDirPath = str.lastIndexOf("/") >= 0 ? str.substring(0,
					str.lastIndexOf("/") + 1) : "";
		}

		// 排序形式，name or size or type
		String order = request.getParameter("order") != null ? request
				.getParameter("order").toLowerCase() : "name";

		// 不允许使用..移动到上一级目录
		if (path.indexOf("..") >= 0) {
			response.getWriter().write("Access is not allowed.");
			return;
		}
		// 最后一个字符不是/
		if (!"".equals(path) && !path.endsWith("/")) {
			response.getWriter().write("Parameter is not valid.");
			return;
		}
		// 目录不存在或不是目录
		File currentPathFile = new File(currentPath);
		if (!currentPathFile.isDirectory()) {
			response.getWriter().write("Directory does not exist.");
			return;
		}

		// 遍历目录取的文件信息
		List<Hashtable> fileList = new ArrayList<Hashtable>();
		if (currentPathFile.listFiles() != null) {
			for (File file : currentPathFile.listFiles()) {
				Hashtable<String, Object> hash = new Hashtable<String, Object>();
				String fileName = file.getName();
				if (file.isDirectory()) {
					hash.put("is_dir", true);
					hash.put("has_file", (file.listFiles() != null));
					hash.put("filesize", 0L);
					hash.put("is_photo", false);
					hash.put("filetype", "");
				} else if (file.isFile()) {
					String fileExt = fileName.substring(
							fileName.lastIndexOf(".") + 1).toLowerCase();
					hash.put("is_dir", false);
					hash.put("has_file", false);
					hash.put("filesize", file.length());
					hash.put("is_photo", Arrays.<String> asList(fileTypes)
							.contains(fileExt));
					hash.put("filetype", fileExt);
				}
				hash.put("filename", fileName);
				hash.put("datetime",
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(file
								.lastModified()));
				fileList.add(hash);
			}
		}

		if ("size".equals(order)) {
			Collections.sort(fileList, new SizeComparator());
		} else if ("type".equals(order)) {
			Collections.sort(fileList, new TypeComparator());
		} else {
			Collections.sort(fileList, new NameComparator());
		}
		JSONObject result = new JSONObject();
		result.put("moveup_dir_path", moveupDirPath);
		result.put("current_dir_path", currentDirPath);
		result.put("current_url", currentUrl);
		result.put("total_count", fileList.size());
		result.put("file_list", fileList);

		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().write(result.toJSONString());
		
	}
	public class NameComparator implements Comparator {
		public int compare(Object a, Object b) {
			Hashtable hashA = (Hashtable) a;
			Hashtable hashB = (Hashtable) b;
			if (((Boolean) hashA.get("is_dir"))
					&& !((Boolean) hashB.get("is_dir"))) {
				return -1;
			} else if (!((Boolean) hashA.get("is_dir"))
					&& ((Boolean) hashB.get("is_dir"))) {
				return 1;
			} else {
				return ((String) hashA.get("filename"))
						.compareTo((String) hashB.get("filename"));
			}
		}
	}
	public class SizeComparator implements Comparator {
		public int compare(Object a, Object b) {
			Hashtable hashA = (Hashtable) a;
			Hashtable hashB = (Hashtable) b;
			if (((Boolean) hashA.get("is_dir"))
					&& !((Boolean) hashB.get("is_dir"))) {
				return -1;
			} else if (!((Boolean) hashA.get("is_dir"))
					&& ((Boolean) hashB.get("is_dir"))) {
				return 1;
			} else {
				if (((Long) hashA.get("filesize")) > ((Long) hashB
						.get("filesize"))) {
					return 1;
				} else if (((Long) hashA.get("filesize")) < ((Long) hashB
						.get("filesize"))) {
					return -1;
				} else {
					return 0;
				}
			}
		}
	}
	public class TypeComparator implements Comparator {
		public int compare(Object a, Object b) {
			Hashtable hashA = (Hashtable) a;
			Hashtable hashB = (Hashtable) b;
			if (((Boolean) hashA.get("is_dir"))
					&& !((Boolean) hashB.get("is_dir"))) {
				return -1;
			} else if (!((Boolean) hashA.get("is_dir"))
					&& ((Boolean) hashB.get("is_dir"))) {
				return 1;
			} else {
				return ((String) hashA.get("filetype"))
						.compareTo((String) hashB.get("filetype"));
			}
		}
	}
}
