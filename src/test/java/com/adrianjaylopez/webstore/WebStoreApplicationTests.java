package com.adrianjaylopez.webstore;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * WebStoreApplication tester
 * @Author Adrian Lopez
 * @sinve <pre>Jun 13, 2015</pre>
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WebStoreApplication.class)
@WebAppConfiguration
public class WebStoreApplicationTests {

	@Test
	public void contextLoads() {
	}

}
