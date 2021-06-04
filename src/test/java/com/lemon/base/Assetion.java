package com.lemon.base;

import org.apache.log4j.Logger;
import org.testng.Assert;

/**
 * @Project: autoApp
 * @Author: 54540
 * @Create: 2021-06-02 11:41
 * @Desc：异常封装
 **/
public class Assetion {
    static Logger logger = Logger.getLogger(Assetion.class);

         /**
         * TestNG的assertTrue断言方法二次封装，集成日志
         * @param condition 表达式
         */
        public static void myAssertTrue(boolean condition){
            try {
                Assert.assertTrue(condition);
            }catch (AssertionError e){
                logger.error("断言【"+condition+"】失败");
                logger.error(e);
                //还要继续向TestNG测试框架抛出异常
                throw e;
            }
            logger.info("断言【"+condition+"】是否为真");
        }
        public static void myAssertEquals(boolean condition,boolean expected){
        try{
            logger.error("实际值【"+condition+"】和期望值【"+expected+"】相同");
        }catch (Exception e){
            logger.error("实际值【"+condition+"】和期望值【"+expected+"】异常");
            logger.error(e);
            throw e;
        }
    }
    public static void myAssertEquals(int condition,int expected){
        try{
            logger.error("实际值【"+condition+"】和期望值【"+expected+"】相同");
        }catch (Exception e){
            logger.error("实际值【"+condition+"】和期望值【"+expected+"】异常");
            logger.error(e);
            throw e;
        }
    }
    public static void myAssertEquals(String condition,String expected){
        try{
            logger.info("实际值【"+condition+"】和期望值【"+expected+"】相同");
        }catch (Exception e){
            logger.error("实际值【"+condition+"】和期望值【"+expected+"】异常");
            logger.error(e);
            throw e;
        }
    }
}
