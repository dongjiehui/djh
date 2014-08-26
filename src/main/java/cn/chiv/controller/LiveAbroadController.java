package cn.chiv.controller;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import cn.chiv.entity.LiveAbroad;
import cn.chiv.entity.User;
import cn.chiv.repository.LiveAbroadRepository;
import cn.chiv.repository.MyRepository;

@RestController
@RequestMapping("liveAbroad")
public class LiveAbroadController extends AbstractBaseController<LiveAbroad, Long>{

	@Autowired
	private LiveAbroadRepository abroadRepository;
	
	
	@Override
	protected MyRepository<LiveAbroad, Long> getRepository() {
		return abroadRepository;
	}

	
	/**	表单提交 文字+图片 发布国外生活	*/
	@RequestMapping(value = "addLiveAbroad", method = RequestMethod.POST, consumes = "multipart/form-data")
	public void addLiveAbroad(@RequestParam String title, @RequestParam String contents, 
			@RequestParam MultipartFile imgs, HttpServletResponse response) {
		
		try {
			LiveAbroad liveAbroad = new LiveAbroad();		
			liveAbroad.setTitle(title.getBytes("utf-8").toString());
//			String str = new String(title.getBytes("ISO-8859-1"), "UTF-8");
			System.out.println(title.getBytes("utf-8").toString());
			liveAbroad.setClickNum(0);
			
			liveAbroad.setImgs(imgs.getBytes());
			liveAbroad.setContents(contents);
			System.out.println("---contents-------"+contents);
			User user = new User(2L);
			liveAbroad.setUser(user);
			
			abroadRepository.save(liveAbroad);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			response.getWriter().write("<script type='text/javascript'>"
					+ " top.location.href='http://localhost:8080/html/publish/publishCommon.html'"
					+ "</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return "success";
//		listMobilecardsAction();
//		return new ModelAndView("redirect:http://localhost:8080/../../index.jsp");  //重定向
	}
	
	/**	获取图片	*/
	@RequestMapping(value = "getImgsById", method = RequestMethod.GET)
	public void getImgsById(@RequestParam long id, OutputStream output) {
		LiveAbroad liveAbroad = abroadRepository.findOne(id);
		try {
			output.write(liveAbroad.getImgs());//输出二进制流文件
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	

//	@RequestMapping(value = "listMobilecards", method = RequestMethod.GET)
	public ModelAndView listMobilecardsAction() {
		System.out.println("----------");
		ModelAndView modelAndView = new ModelAndView(new RedirectView("http://localhost:8080/html/publish/publishCommon.html"));
//		Map m = new HashMap();
//		m.put("message", "跳转界面");
//		modelAndView.addObject("msg", m);
		return modelAndView;
	}

	
	
	
	
}
