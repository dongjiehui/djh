package cn.chiv.controller;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.chiv.entity.Charity;
import cn.chiv.entity.User;
import cn.chiv.repository.CharityRepository;
import cn.chiv.repository.MyRepository;

@RestController
@RequestMapping("charityIntroduct")
public class CharityIntroductionController extends AbstractBaseController<Charity, Long>{

	@Autowired
	private CharityRepository charityRepository;
	
	
	@Override
	protected MyRepository<Charity, Long> getRepository() {
		return charityRepository;
	}

	
	/**	表单提交 文字+图片 发布国外生活	*/
	@RequestMapping(value = "addCharityIntroduct", method = RequestMethod.POST, consumes = "multipart/form-data")
	public void addLiveAbroad(@RequestParam String title, @RequestParam String contents, @RequestParam MultipartFile imgs) {
		
		try {
			Charity charityIntroduct = new Charity();		
			charityIntroduct.setTitle(title);
			charityIntroduct.setClickNum(0);
			
			charityIntroduct.setImg(imgs.getBytes());
			charityIntroduct.setContent(contents);
			System.out.println("---contents-------"+contents);
			User user = new User(2L);
			charityIntroduct.setUser(user);
			
			charityRepository.save(charityIntroduct);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**	获取图片	*/
	@RequestMapping(value = "getImgsById", method = RequestMethod.GET)
	public void getImgsById(@RequestParam long id, OutputStream output) {
		Charity liveAbroad = charityRepository.findOne(id);
		try {
			output.write(liveAbroad.getImg());//输出二进制流文件
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
}
