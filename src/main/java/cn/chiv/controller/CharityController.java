package cn.chiv.controller;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.chiv.entity.CharityIntroduction;
import cn.chiv.entity.User;
import cn.chiv.repository.CharityIntroductionRepository;
import cn.chiv.repository.MyRepository;

@RestController
@RequestMapping("charity")
public class CharityController extends AbstractBaseController<CharityIntroduction, Long>{

	@Autowired
	private CharityIntroductionRepository charityIntroductionRepository;
	
	
	@Override
	protected MyRepository<CharityIntroduction, Long> getRepository() {
		return charityIntroductionRepository;
	}

	
	/**	表单提交 文字+图片 发布国外生活	*/
	@RequestMapping(value = "addCharity", method = RequestMethod.POST, consumes = "multipart/form-data")
	public void addLiveAbroad(@RequestParam String constitution,  @RequestParam MultipartFile imgs) {
		
		try {
			CharityIntroduction charity = new CharityIntroduction();		
			charity.setConstitution(constitution);
			
			charity.setImg(imgs.getBytes());
			User user = new User(2L);
			charity.setUser(user);
			
			charityIntroductionRepository.save(charity);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**	获取图片	*/
	@RequestMapping(value = "getImgsById", method = RequestMethod.GET)
	public void getImgsById(@RequestParam long id, OutputStream output) {
		CharityIntroduction charity = charityIntroductionRepository.findOne(id);
		try {
			output.write(charity.getImg());//输出二进制流文件
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
}
