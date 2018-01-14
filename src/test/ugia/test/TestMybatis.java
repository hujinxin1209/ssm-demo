package ugia.test;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.cn.ugia.IDao.UserMapper;
import com.cn.ugia.domain.User;
import com.cn.ugia.service.IUserService;
import com.cn.ugia.util.RedisUtils;

import redis.clients.jedis.Jedis;

@RunWith(SpringJUnit4ClassRunner.class) // 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-mybatis.xml" })

public class TestMybatis {
	private static Logger logger = Logger.getLogger(TestMybatis.class);
	// private ApplicationContext ac = null;
	@Resource
	private IUserService userService = null;

	@Resource
	private UserMapper userDao = null;
	// @Before
	// public void before() {
	// ac = new ClassPathXmlApplicationContext("applicationContext.xml");
	// userService = (IUserService) ac.getBean("userService");
	// }

	@Test
	public void test1() {
		// User user = userService.getUserById(1);
		// logger.info(JSON.toJSONString(user));
		User user = new User();

		userService.insertUser(user);
	}

	// redis测试
	@Test
	public void testRedis() {
//		Jedis jedis =  new Jedis("23.133.1.217");
		Jedis jedis = RedisUtils.getJedis();
		System.out.println("Connect to server redis");
		System.out.println("server is running:" + jedis.ping());
		
		jedis.set("k2", "ugia");

	}
}
