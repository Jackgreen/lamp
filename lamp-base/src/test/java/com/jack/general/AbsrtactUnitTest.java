package com.jack.general;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @version 2017年09月08日 10:15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context-base.xml"})
public class AbsrtactUnitTest {
    protected static final Logger logger = LogManager.getLogger();
    @Test
    public void test() {
        logger.info("for test");
    }
}
