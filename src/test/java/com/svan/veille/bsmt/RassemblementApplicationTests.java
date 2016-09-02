package com.svan.veille.bsmt;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.svan.veille.bsmt.meetup.MeetupApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MeetupApplication.class)
@WebAppConfiguration
public class RassemblementApplicationTests {

	@Test
	public void contextLoads() {
	}

}
