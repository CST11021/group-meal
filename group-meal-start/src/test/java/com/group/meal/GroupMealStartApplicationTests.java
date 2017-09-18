package com.group.meal;

import com.group.meal.dao.dataobject.GroupUser;
import com.group.meal.dao.mapper.GroupUserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@DelegateTo(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = GroupMealStartApplicationTests.class)
@ImportResource(value = {"classpath:/spring-mybatis-config.xml"})
@ComponentScan({"com.group.meal"})
public class GroupMealStartApplicationTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private GroupUserMapper groupUserMapper;
	@Test
	public void contextLoads() {

		GroupUser user = groupUserMapper.selectByPrimaryKey(1L);
		Assert.assertNotNull(user);

	}

}
