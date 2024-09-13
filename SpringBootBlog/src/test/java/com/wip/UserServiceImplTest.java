package com.wip;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wip.model.UserDomain;
import com.wip.service.user.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
	
	@Autowired
	UserService userService;
	@Test
	public void loginTest() {
		System.out.println(userService.login("admin", "123456"));
	}
	@Test
	public void getUserInfoByIdTest() {
		System.out.println(userService.getUserInfoById(1));
	}
	@Test
	public void updateUserInfo() {
		UserDomain userDomain=new UserDomain();
		userDomain.setUid(1);
		userDomain.setEmail("864655735@qq.com");
		userDomain.setPassword("123");
		userDomain.setScreenName("adm");
		userService.updateUserInfo(userDomain);
	}
}
