package cn.chiv.controller;

import java.io.IOException;
import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import cn.chiv.entity.NewsS;
import cn.chiv.entity.User;
import cn.chiv.repository.MyRepository;
import cn.chiv.repository.NewsSRepository;

@RestController
@RequestMapping("news")
public class NewsSController extends AbstractBaseController<NewsS, Long>{

	@Autowired
	private NewsSRepository newsSRepository;
	
	
	@Override
	protected MyRepository<NewsS, Long> getRepository() {
		return newsSRepository;
	}

	
	/**	表单提交 文字+图片 发布国外生活	*/
	@RequestMapping(value = "addNews", method = RequestMethod.POST, consumes = "multipart/form-data")
	public void addLiveAbroad(@RequestParam String title, @RequestParam String contents, @RequestParam MultipartFile imgs) {
		
		try {
			NewsS news = new NewsS();		
			news.setTitle(title);
			news.setClickNum(0);
			
			news.setImg(imgs.getBytes());
			news.setContent(contents);
			System.out.println("---contents-------"+contents);
			User user = new User(2L);
			news.setUser(user);
			
			newsSRepository.save(news);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**	获取图片	*/
	@RequestMapping(value = "getImgsById", method = RequestMethod.GET)
	public void getImgsById(@RequestParam long id, OutputStream output) {
		NewsS liveAbroad = newsSRepository.findOne(id);
		try {
			output.write(liveAbroad.getImg());//输出二进制流文件
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
}
