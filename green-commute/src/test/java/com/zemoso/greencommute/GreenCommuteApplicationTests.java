package com.zemoso.greencommute;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertTrue;


@SpringBootTest
@RunWith(SpringRunner.class)
class GreenCommuteApplicationTests {

	@Test
	void contextLoads() {
		GreenCommuteApplication.main(new String[]{});
		assertTrue(true);
	}

}
