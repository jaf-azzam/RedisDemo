package redisexample;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

public class MyApp {

	public static void main(String[] args) {

		try {
			JedisShardInfo shardInfo = new JedisShardInfo("redis-17190.c290.ap-northeast-1-2.ec2.cloud.redislabs.com", 17190);
			shardInfo.setPassword("redisdb");

			Jedis jedis = new Jedis(shardInfo);
//				Jedis jedis = new Jedis("localhost");

			System.out.println("Successfull connection");
			System.out.println("Running at - " + jedis.ping());
			jedis.set("company-name", "freecharge");
			System.out.println("Stored string in redis - " + jedis.get("company-name"));

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
