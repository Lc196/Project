package com.wip;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wip.dto.cond.TeachCond;
import com.wip.model.MetaDomain;
import com.wip.model.TeachDomain;
import com.wip.service.teach.TeachService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeachServiceImplTest {
	
	@Autowired
	TeachService teachService;
	
	
	 @Test
	    public void addTeachTest() {
		 	TeachDomain teachDomain=new TeachDomain();
	    	teachDomain.setTitle("sss");
	    	teachDomain.setContent("bbb");
	    	teachService.addTeach(teachDomain);
	    }
	    @Test
	    public void getTeachByIdTest() {
	    	System.out.println(teachService.getTeachById(34));
	    }
	    @Test
	    public void updateTeachByIdTest() {
	    	TeachDomain teachDomain=new TeachDomain();
	    	teachDomain.setTitle("ccc");
	    	teachDomain.setContent("aaa");
	    	teachDomain.setTid(38);
	    	teachService.updateTeachById(teachDomain);
	    }
	    @Test
	    public void getTeachsByCondTest() {
	    	System.out.println(teachService.getTeachsByCond(new TeachCond(), 1, 2));
	    }
	   
	    @Test
	    public void deleteTeachByIdTest() {
	    	teachService.deleteTeachById(35);
	    }
	    @Test
	    public void updateteachByCidTest() {
	    	TeachDomain teachDomain=new TeachDomain();
	    	teachDomain.setTitle("aaa");
	    	teachDomain.setContent("ccc");
	    	teachDomain.setTid(39);
	    	teachService.updateTeachById(teachDomain);
	    }
		@Test
		public void getTeachByCategoryTest() {
	       System.out.println(teachService.getTeachByCategory("默认分类"));
	    }
		@Test
		public void getTeachByTagsTest() {
			MetaDomain metaDomain=new MetaDomain();
			metaDomain.setMid(49);
	       System.out.println(teachService.getTeachByTags(metaDomain));
	    }
	
}
