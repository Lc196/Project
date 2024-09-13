package com.wip;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wip.constant.ErrorConstant;
import com.wip.exception.BusinessException;
import com.wip.model.AttAchDomain;
import com.wip.service.attach.AttAchService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AttAchServiceImplTest {
	@Autowired
	AttAchService attAchService;
	@Test
	public void addAttAchTest() {
		AttAchDomain achDomain=new AttAchDomain();
		achDomain.setFname("aname");
		achDomain.setFkey("aKey");
		achDomain.setCreated(111);
      attAchService.addAttAch(achDomain);
    }
	@Test
	public void getAttsTest() {
		System.out.println(attAchService.getAtts(1, 2));
    }
	@Test
	public void getAttAchByIdTest() {
		System.out.println(attAchService.getAttAchById(7));
    }
	@Test
	public void deleteAttAchTest() {
		attAchService.deleteAttAch(7);
    }
	
	 
}
