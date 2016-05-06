package com.bolatu.rest.client.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bolatu.util.UtilityConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestClientTestConfig.class, UtilityConfig.class})
public abstract class BaseTestConfig {

}
