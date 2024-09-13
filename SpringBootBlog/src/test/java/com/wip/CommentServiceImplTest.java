package com.wip;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wip.dto.cond.CommentCond;
import com.wip.model.CommentDomain;
import com.wip.service.comment.CommentService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentServiceImplTest {
	@Autowired
	CommentService commentService;
	@Test
	public void addCommentTest() {
		CommentDomain commentDomain=new CommentDomain();
		commentDomain.setEmail("123@qq.com");
		commentDomain.setContent("123456");
		commentDomain.setCid(34);
		commentService.addComment(commentDomain);
    }
	@Test
	public void getCommentsByCIdTest() {
		System.out.println(commentService.getCommentsByCId(34));
    }
	@Test
	public void getCommentsByCondTest() {
	CommentCond commentCond=new CommentCond();
	commentCond.setStatus("approved");
	System.out.println(commentService.getCommentsByCond(commentCond, 1, 2));
    }
	@Test
	public void getCommentByIdTest() {
	System.out.println(commentService.getCommentById(4));
    }
	@Test
	public void updateCommentStatusTest() {
	commentService.updateCommentStatus(4, "not-approved");
    }
	@Test
	public void deleteCommentTest() {
	commentService.deleteComment(4);
    }
}
