package com.wip;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.wip.service.log.LogService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogServiceImplTest {
	@Autowired
	LogService logService;
	@Test
	public void addCommentTest() {
		int authorId=1;
		String ip="0:0:0:0:0:0:0:1";
	    String data="admin用户";
	    String action= "登录后台";
	    logService.addLog(action, data, ip, authorId);
    }
	@Test
	public void getLogsTest() {
		System.out.println(logService.getLogs(1, 2));
	}
}
