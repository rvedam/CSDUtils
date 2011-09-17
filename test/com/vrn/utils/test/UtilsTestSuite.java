/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.vrn.utils.test;

import java.util.List;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;



/**
 *
 * @author vedam
 */
public class UtilsTestSuite
{
    public static void main(String[] args) {
        Class[] classes = {NGramTest.class, NGramFactoryTest.class};
        Result runClasses = JUnitCore.runClasses(classes);
        if(!runClasses.wasSuccessful()) {
            System.out.println("TESTS FAILED: " + runClasses.getFailureCount() + " test(s)");
            for(Failure failure: runClasses.getFailures()) {
                System.out.println(failure.getDescription());
                System.out.println(failure.getMessage());
            }
        } else {
            System.out.println("ALL TESTS PASSED");
        }
    }
}
