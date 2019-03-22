package main;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
	locations = {
    "classpath:spring/application-config.xml"
	,"classpath:spring/database-config-mysqldb.xml"
    //"classpath:spring/mvc-config.xml"
})
//WebAppConfiguration
public class MainAppTest {
	public static Logger logger = LoggerFactory.getLogger(MainAppTest.class);
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	@Test
	public void simpleTest() {
		logger.debug("DB OK?");
		assertThat(true, is(true));
	}
}//END OF CLASS