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

import cn.chiv.entity.MemberMessages;
import cn.chiv.entity.User;
import cn.chiv.repository.MemberMessagesRepository;
import cn.chiv.repository.MyRepository;
@RestController
@RequestMapping("member")
public class MemberMessagesController extends AbstractBaseController<MemberMessages, Long>{

	@Autowired
	private MemberMessagesRepository memberMessagesRepository;
	
	
	@Override
	protected MyRepository<MemberMessages, Long> getRepository() {
		return memberMessagesRepository;
	}

	
	/**	表单提交 文字+图片 发布国外生活	*/
	@RequestMapping(value = "addMember", method = RequestMethod.POST, consumes = "multipart/form-data")
	public void addLiveAbroad(@RequestParam String title, @RequestParam String contents, @RequestParam MultipartFile imgs,HttpServletResponse response) {
		
		try {
			MemberMessages member = new MemberMessages();		
			member.setTitle(title);
			member.setClickNum(0);
			
			member.setImgs(imgs.getBytes());
			member.setContents(contents);
			System.out.println("---contents-------"+contents);
			User user = new User(2L);
			member.setUser(user);
			
			memberMessagesRepository.save(member);
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
	}
	
	/**	获取图片	*/
	@RequestMapping(value = "getImgsById", method = RequestMethod.GET)
	public void getImgsById(@RequestParam long id, OutputStream output) {
		MemberMessages liveAbroad = memberMessagesRepository.findOne(id);
		try {
			output.write(liveAbroad.getImgs());//输出二进制流文件
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
}
