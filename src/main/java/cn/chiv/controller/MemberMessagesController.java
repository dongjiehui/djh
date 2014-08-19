package cn.chiv.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.chiv.entity.LiveAbroad;
import cn.chiv.entity.User;
import cn.chiv.repository.LiveAbroadRepository;
import cn.chiv.repository.MyRepository;

@RestController
@RequestMapping("member")
public class MemberMessagesController extends AbstractBaseController<LiveAbroad, Long>{

	@Autowired
	private LiveAbroadRepository abroadRepository;
	
	
	@Override
	protected MyRepository<LiveAbroad, Long> getRepository() {
		return abroadRepository;
	}

	
	/**	表单提交 文字+图片 发布国外生活	*/
	@RequestMapping(value = "addLiveAbroad", method = RequestMethod.POST, consumes = "multipart/form-data")
	public void addLiveAbroad(@RequestParam String title, @RequestParam String contents, @RequestParam MultipartFile imgs) {
		
		try {
			LiveAbroad liveAbroad = new LiveAbroad();		
			liveAbroad.setTitle(title);
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

	
}
