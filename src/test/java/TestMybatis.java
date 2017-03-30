import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import rml.model.MUser;
import rml.service.MUserService;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
@ActiveProfiles(value="dev")
public class TestMybatis  extends AbstractJUnit4SpringContextTests {

	private static final Logger logger = Logger.getLogger(TestMybatis.class);

	@Autowired
	private MUserService muserService;

	@Test
	public void test0() {
        logger.info(JSON.toJSONStringWithDateFormat("TestFinish", "yyyy-MM-dd HH:mm:ss"));
    }
	
	@Test
	public void test1() {
		
		List<MUser> list = muserService.getAll();
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
	}
	
	//@Test
	public void test2() {
	
		MUser muser = new MUser();
		muser.setId("0000");
		muser.setName("aaaa");
		muser.setAge(1234);
		muser.setAddress("ABCD");
		int i = muserService.insert(muser);
		logger.info(JSON.toJSONStringWithDateFormat("add "+i, "yyyy-MM-dd HH:mm:ss"));
	}
	
	//@Test
	public void test3() {
		
		MUser muser = new MUser();
		muser.setId("0000");
		muser.setName("bbbb");
		muser.setAge(1234);
		muser.setAddress("ABCD");
		int i = muserService.update(muser);
		logger.info(JSON.toJSONStringWithDateFormat("update " +i, "yyyy-MM-dd HH:mm:ss"));
	}
	
	//@Test
	public void test4() {
		
		MUser muser = new MUser();
		muser.setId("0000");
		muser.setName("bbbb");
		muser.setAge(1234);
		muser.setAddress("ABCD");
		int i = muserService.delete("0000");
		logger.info(JSON.toJSONStringWithDateFormat("delete "+i, "yyyy-MM-dd HH:mm:ss"));
	}
	
}
