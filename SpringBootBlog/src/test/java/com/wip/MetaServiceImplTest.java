package com.wip;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wip.dto.cond.MetaCond;
import com.wip.model.MetaDomain;
import com.wip.service.meta.MetaService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MetaServiceImplTest {
	
	@Autowired
	MetaService metaService;
	@Test
	public void saveMetaTest() {
		metaService.saveMeta("tag", "456", null);
	}
	@Test
	public void getMetaListTest() {
		System.out.println(metaService.getMetaList("tag", null, 2));
	}
	@Test
	public void addMetasTest() {
		metaService.addMetas(36, "默认分类,新分类", "category");
	}
	@Test
	public void saveOrUpdateTest() {
		metaService.saveOrUpdate(36, "默认分类", "category");
	}
	@Test 
	public void addMeaTest() {
		MetaDomain metaDomain=new MetaDomain();
		metaDomain.setType("category");
		metaDomain.setName("新分类2");
		metaService.addMea(metaDomain);
	}
	@Test 
	public void updateMetaTest() {
		MetaDomain metaDomain=new MetaDomain();
		metaDomain.setMid(54);
		metaDomain.setType("category");
		metaDomain.setName("新分类3");
		metaService.updateMeta(metaDomain);
	}
	
	@Test
	public void getMetasCountByTypeTest() {
		System.out.println(metaService.getMetasCountByType("category"));
	}
	@Test
	public void getMetaByNameTest() {
		System.out.println(metaService.getMetaByName("category", "新分类"));
	}
	@Test
	public void deleteMetaById() {
		metaService.deleteMetaById(54);
	}
	@Test
	public void getMetasTest() {
		MetaCond metaCond=new MetaCond();
		metaCond.setName("新分类");
		System.out.println(metaService.getMetas(metaCond));
	}
}
