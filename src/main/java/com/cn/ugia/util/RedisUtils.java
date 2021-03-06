package com.cn.ugia.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * redis的工具类
 * 
 *
 */
public final class RedisUtils {
	private static final Logger log = LoggerFactory.getLogger(RedisUtils.class);
	private static Properties prop = new Properties();
	static {
		try {
			prop.load(RedisUtils.class.getClassLoader().getResourceAsStream("redis.properties"));
		} catch (IOException e) {
			log.warn("读取爱的配置文件失败！");
			e.printStackTrace();
		}
	}

	// Redis服务器IP
	private static String ADDR = prop.getProperty("redis.host");

	// Redis的端口号
	private static int PORT = Integer.valueOf(prop.getProperty("redis.port"));
	// redis的密码
	private static String PASS = prop.getProperty("redis.password");

	// 访问密码
	// private static String AUTH = "";

	// 可用连接实例的最大数目，默认值为8；
	// 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
	private static int MAX_ACTIVE = 1024;
	// 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
	private static int MAX_IDLE = 200;
	// 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
	private static int MAX_WAIT = 10000;

	private static int TIMEOUT = 10000;

	// 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
	private static boolean TEST_ON_BORROW = true;

	private static JedisPool jedisPool = null;

	/**
	 * 初始化Redis连接池
	 */
	static {
		try {
			JedisPoolConfig config = new JedisPoolConfig();
			// config.setMaxActive(MAX_ACTIVE);
			// config.setMaxWait(MAX_WAIT);
			config.setMaxIdle(MAX_IDLE);
			// 新版本的使用
			config.setMaxTotal(MAX_ACTIVE);
			config.setMaxWaitMillis(MAX_WAIT);
			config.setTestOnBorrow(TEST_ON_BORROW);
			jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, PASS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获取Jedis实例
	 * 
	 * @return
	 */
	public synchronized static Jedis getJedis() {
		try {
			if (jedisPool != null) {
				Jedis resource = jedisPool.getResource();
				return resource;
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 释放jedis资源(该方法已经废弃,请使用jedis.close()方法代替)
	 * 
	 * @param jedis
	 */
	public static void returnResource(final Jedis jedis) {
		if (jedis != null) {
			jedisPool.returnResource(jedis);
		}
	}

	/**
	 * 将对象序列化
	 * 
	 * @param obj
	 *            序列化对象
	 * @return 序列化后的byte[]
	 */
	public static byte[] serialize(Object obj) {
		byte[] bytes = null;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			bytes = baos.toByteArray();
			baos.close();
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bytes;
	}

	/**
	 * 反序列化
	 * 
	 * @param bytes
	 *            对象序列化后的byte[]
	 * @return 对象
	 */
	public static Object deSerialize(byte[] bytes) {
		Object obj = null;
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			ObjectInputStream ois = new ObjectInputStream(bais);
			obj = ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	/**
	 * 检验手机是否正确，验证手机验证码是否正确
	 * 
	 * @param phoneNumber
	 *            电话号码
	 * @param verificationCode
	 *            手机验证码
	 * @param type
	 *            1=用户注册，2=找回密码
	 */
//	public static void checkMessage(String phoneNumber, String verificationCode, int type) {
//		// 校验手机号
//		if (!SecurityUtils.isMobileNO(phoneNumber)) {
//			throw new EyedException(ErrCodeApp.INVALID_PHONE_ERROR);
//		}
//
//		// 测试环境默认验证码
//		if ("1".equals(EyedUtils.SERVER_ENVIRONMENT)) {
//			if ("123456".equals(verificationCode)) {
//				return;
//			}
//		}
//		// 检查手机验证码不能为空
//		if (verificationCode == "" || verificationCode == null) {
//			log.warn("验证码为空！");
//			throw new EyedException(ErrCodeApp.INVALID_VERIFICATIONCODE_FAIL);
//		}
//		String key = "";
//		if (type == 1) {
//			key = "eyedRegister" + verificationCode;
//		} else if (type == 2) {
//			key = "eyedForgetPw" + verificationCode;
//		}
//		Jedis jedis = getJedis();
//		byte[] redisPhoneMessageByte = jedis.get(("phone" + phoneNumber).getBytes());
//		if (redisPhoneMessageByte != null) {
//			PhoneMessage redisPhoneMessage = (PhoneMessage) RedisUtils.deSerialize(redisPhoneMessageByte);
//			// 获取两次验证码的时间差.
//			String redisVerificationCode = redisPhoneMessage.getVerificationCode();
//			// 校验验证码
//			if (!key.equals(redisVerificationCode)) {
//				log.info("用户:" + phoneNumber + "校验验证码错误");
//				throw new EyedException(ErrCodeApp.INVALID_VERIFICATIONCODE_FAIL);
//			}
//		} else {
//			log.info("用户:" + phoneNumber + "");
//			throw new EyedException(ErrCodeApp.INVALID_VERIFICATIONCODE_OBSOLETE);
//		}
//	}
}
