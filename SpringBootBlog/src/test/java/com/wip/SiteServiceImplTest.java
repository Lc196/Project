package com.wip;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wip.service.site.SiteService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SiteServiceImplTest {
	@Autowired
	SiteService siteService;
	@Test
	public void getCommentsTest() {
		System.out.println(siteService.getComments(5));
	}
	@Test
	public void getNewArticlesTest() {
		System.out.println(siteService.getNewArticles(5));
	}
	@Test
	public void getStatisticsTest() {
		System.out.println(siteService.getStatistics());
	}
}
