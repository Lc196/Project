package com.wip;

import com.wip.constant.ErrorConstant;
import com.wip.dto.cond.ContentCond;
import com.wip.exception.BusinessException;
import com.wip.model.ContentDomain;
import com.wip.model.MetaDomain;
import com.wip.service.article.ContentService;
import com.wip.utils.Commons;import static org.hamcrest.CoreMatchers.nullValue;
import static org.mockito.Matchers.booleanThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ContentServiceImplTests {
	@Autowired
	ContentService contentService;
    @Test
    public void addArticleTest() {
    	ContentDomain contentDomain=new ContentDomain();
    	contentDomain.setTitle("sss");
    	contentDomain.setContent("bbb");
    	contentService.addArticle(contentDomain);
    }
    @Test
    public void getArticleByIdTest() {
    	System.out.println(contentService.getArticleById(34));
    }
    @Test
    public void updateArticleByIdTest() {
    	ContentDomain contentDomain=new ContentDomain();
    	contentDomain.setTitle("ccc");
    	contentDomain.setContent("aaa");
    	contentDomain.setCid(35);
    	contentService.updateArticleById(contentDomain);
    }
    @Test
    public void getArticlesByCondTest() {
    	System.out.println(contentService.getArticlesByCond(new ContentCond(), 1, 2));
    }
   
    @Test
    public void deleteArticleByIdTest() {
    	contentService.deleteArticleById(35);
    }
    @Test
    public void updateContentByCidTest() {
    	ContentDomain contentDomain=new ContentDomain();
    	contentDomain.setTitle("aaa");
    	contentDomain.setContent("ccc");
    	contentDomain.setCid(36);
    	contentService.updateContentByCid(contentDomain);
    }
	@Test
	public void getArticleByCategoryTest() {
       System.out.println(contentService.getArticleByCategory("默认分类"));
    }
	@Test
	public void getArticleByTagsTest() {
		MetaDomain metaDomain=new MetaDomain();
		metaDomain.setMid(49);
       System.out.println(contentService.getArticleByTags(metaDomain));
    }
}
