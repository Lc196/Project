package com.wip;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wip.model.OptionsDomain;
import com.wip.service.option.OptionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OptionServiceImplTest {
	@Autowired
	OptionService optionService;
	
	@Test
	public void getOptionsTest() {
		System.out.println(optionService.getOptions());
	}
	@Test
	public void saveOptionsTest() {
		OptionsDomain optionsDomain=new OptionsDomain();
		optionsDomain.setName("site_description");
		optionsDomain.setValue("1");
		Map<String, String> map=new HashMap<String, String>();
		map.put(optionsDomain.getName(), optionsDomain.getValue());
		optionService.saveOptions(map);
	}
	@Test
	public void updateOptionByNameTest() {
		optionService.updateOptionByName("site_description", "2");
	}
	@Test
	public void getOptionByNameTest() {
		System.out.println(optionService.getOptionByName("site_description"));
	}
	
}
