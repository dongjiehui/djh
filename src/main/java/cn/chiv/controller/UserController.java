package cn.chiv.controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.chiv.entity.User;
import cn.chiv.repository.MyRepository;
import cn.chiv.repository.UserRepository;

@RestController
@RequestMapping("users")
public class UserController extends AbstractBaseController<User, Long> {

	@Autowired
	private UserRepository userRepository;

	@Override
	protected MyRepository<User, Long> getRepository() {
		return userRepository;
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public User login(@RequestParam String username, @RequestParam String password) {
		return userRepository.login(username, DigestUtils.md5Hex(password));
	}
	
}
