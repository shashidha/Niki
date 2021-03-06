package com.niki.bjetf.mobile.base.utils;

/**
 * Created by svasudevajois on 22/04/14.
 */

import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RetryTillPass {

    private static Logger LOGGER  = LoggerFactory.getLogger(RetryTillPass.class);

    private Class c;

    private long getElapsedTime(long startTime) {
        return System.currentTimeMillis() - startTime;
    }

    public RetryTillPass(String className) throws ClassNotFoundException {
        c = Class.forName(className);
    }

    private Object invokeMethod(String methodName, Class[] signature,
                                Object... params) throws InstantiationException,
            IllegalAccessException, NoSuchMethodException, SecurityException {
        Object instance = c.newInstance();

        Method method = c.getDeclaredMethod(methodName, signature);
        Object result = null;

        try {
            result = method.invoke(instance, params);
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
        } catch (InvocationTargetException e) {
            //e.printStackTrace();
        }
        return result;

    }

    public Object waitForCodeToPass(String methodName, Object expectedResult,
                                    Class[] signature, int waitTime, Object... params)
            throws InstantiationException, NoSuchMethodException,
            SecurityException, IllegalAccessException {

        Object instance = c.newInstance();
        Method method = c.getDeclaredMethod(methodName, signature);

        long startTime = System.currentTimeMillis();

        boolean keepLooping = true;
        Object result = null;
        while (keepLooping) {
            try {

                result = invokeMethod(methodName, signature, params);

                if (expectedResult != null) { //elements expect true false
                    if (result != null && result.equals(expectedResult)) {
                        keepLooping = false;
                        break;
                    } else {
                        if (getElapsedTime(startTime) > waitTime) {
                            LOGGER.error("Elapsed time has exceeded the maxWaitTime. Exiting now.");
                            Assert.fail("Wait time has busted out of control while waiting on element. Failing test.");
                            break;
                        }
                        Thread.sleep(100);//100ms wait for element
                    }
                } else { //emails expect null
                    if (result != null) {
                        keepLooping = false;
                        break;
                    } else {
                        if (getElapsedTime(startTime) > waitTime) {
                            LOGGER.error("Elapsed time has exceeded the maxWaitTime. Exiting now.");
                            Assert.fail("Wait time has busted out of control while waiting on email. Failing test.");
                            break;
                        }
                        Thread.sleep(1000);//1 sec wait for emails
                    }
                }
            } catch (IllegalArgumentException e) {
                //e.printStackTrace();
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }

        return result;
    }

    public Object waitForCodeToPassUtil(String methodName, Object expectedResult,
                                    Class[] signature, int waitTime, Object... params)
            throws InstantiationException, NoSuchMethodException,
            SecurityException, IllegalAccessException {

        Object instance = c.newInstance();
        Method method = c.getDeclaredMethod(methodName, signature);
        LOGGER.info("hello");
        long startTime = System.currentTimeMillis();

        boolean keepLooping = true;
        Object result = null;
        while (keepLooping) {
            try {

                result = invokeMethod(methodName, signature, params);

                if (expectedResult != null) { //elements expect true false
                    if (result != null && result.equals(expectedResult)) {
                        keepLooping = false;
                        break;
                    } else {
                        if (getElapsedTime(startTime) > waitTime) {
                            LOGGER.error("Elapsed time has exceeded the maxWaitTime. Exiting now.");
                            //Assert.fail("Wait time has busted out of control while waiting on element. Failing test.");
                            result = -666;
                            break;
                        }
                        Thread.sleep(100);//100ms wait for element
                    }
                } else { //emails expect null
                    if (result != null) {
                        keepLooping = false;
                        break;
                    } else {
                        if (getElapsedTime(startTime) > waitTime) {
                            LOGGER.error("Elapsed time has exceeded the maxWaitTime. Exiting now.");
                            //Assert.fail("Wait time has busted out of control while waiting on email. Failing test.");
                            result = -666;
                            break;
                        }
                        Thread.sleep(1000);//1 sec wait for emails
                    }
                }
            } catch (IllegalArgumentException e) {
                //e.printStackTrace();
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        try {
            RetryTillPass rh = new RetryTillPass(
                    "com.niki.poc.data.SampleClass");
            try {
                Class[] signature = new Class[]{Integer.class, String.class,
                        String.class, String.class};

                Boolean result = (Boolean) rh.waitForCodeToPass("print", true,
                        signature, 3000, 0, "bjn1", "bjn2", "bjn3");
                System.out.println(result);
            } catch (InstantiationException e) {

                e.printStackTrace();
            } catch (IllegalAccessException e) {

                e.printStackTrace();
            } catch (NoSuchMethodException e) {

                e.printStackTrace();
            } catch (SecurityException e) {

                e.printStackTrace();
            } catch (IllegalArgumentException e) {

                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
    }
}