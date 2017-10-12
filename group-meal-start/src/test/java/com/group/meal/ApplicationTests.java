package com.group.meal;

import com.group.meal.dao.dataobject.GroupUserDO;
import com.group.meal.dao.mapper.GroupUserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@DelegateTo(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationTests.class)
@ImportResource(value = {"classpath:/spring-mybatis-config.xml"})
@ComponentScan({"com.group.meal"})
public class ApplicationTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private GroupUserDao groupUserDao;

    @Test
    public void contextLoads() {
        GroupUserDO user = groupUserDao.selectByPrimaryKey(1L);
        logger.debug(user.toString());
        Assert.assertNotNull(user);

    }

    @Test
    public void test() {
        if (true) throw new RuntimeException("just a test");
    }

}
