/*
 * APIMATICCalculatorDevOpsLib
 *
 * This file was automatically generated for testing by APIMATIC v2.0 ( https://apimatic.io ).
 */
package io.apimatic.examples.controllers;

import static org.junit.Assert.*;

import java.io.*;
import java.util.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import io.apimatic.examples.models.*;
import io.apimatic.examples.exceptions.*;
import io.apimatic.examples.APIHelper;
import io.apimatic.examples.Configuration;
import io.apimatic.examples.testing.TestHelper;
import io.apimatic.examples.controllers.SimpleCalculator;

import com.fasterxml.jackson.core.type.TypeReference;

public class SimpleCalculatorTest extends ControllerTestBase {
    
    /**
     * Controller instance (for all tests)
     */
    private static SimpleCalculator controller;
    
    /**
     * Setup test class
     */
    @BeforeClass
    public static void setUpClass() {
        controller = getClient().getSimpleCalculator();
    }

    /**
     * Tear down test class
     * @throws IOException
     */
    @AfterClass
    public static void tearDownClass() throws IOException {
        controller = null;
    }

    /**
     * Todo Add description for test testSum
     * @throws Throwable
     */
    @Test
    public void testSum() throws Throwable {
        // Parameters for the API call
        OperationType operation = OperationType.fromString("SUM");
        double x = 5d;
        double y = 20d;

        // Set callback and perform API call
        double result = 0;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.calculate(operation, x, y);
        } catch(APIException e) {};

       // Test whether the response is null
        assertNotNull("Response is null", 
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 200", 
                200, httpResponse.getResponse().getStatusCode());

        // Test whether the captured response is as we expected
        assertNotNull("Result does not exist", 
                result);
 
        assertEquals("Response does not match expected value", 
            25, result, ASSERT_PRECISION);
    }

    /**
     * Todo Add description for test testSubtract
     * @throws Throwable
     */
    @Test
    public void testSubtract() throws Throwable {
        // Parameters for the API call
        OperationType operation = OperationType.fromString("SUBTRACT");
        double x = 20d;
        double y = 5d;

        // Set callback and perform API call
        double result = 0;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.calculate(operation, x, y);
        } catch(APIException e) {};

       // Test whether the response is null
        assertNotNull("Response is null", 
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 200", 
                200, httpResponse.getResponse().getStatusCode());

        // Test whether the captured response is as we expected
        assertNotNull("Result does not exist", 
                result);
 
        assertEquals("Response does not match expected value", 
            15, result, ASSERT_PRECISION);
    }

    /**
     * Todo Add description for test testDivide
     * @throws Throwable
     */
    @Test
    public void testDivide() throws Throwable {
        // Parameters for the API call
        OperationType operation = OperationType.fromString("DIVIDE");
        double x = 20d;
        double y = 4d;

        // Set callback and perform API call
        double result = 0;
        controller.setHttpCallBack(httpResponse);
        try {
            result = controller.calculate(operation, x, y);
        } catch(APIException e) {};

       // Test whether the response is null
        assertNotNull("Response is null", 
                httpResponse.getResponse());
        // Test response code
        assertEquals("Status is not 200", 
                200, httpResponse.getResponse().getStatusCode());

        // Test whether the captured response is as we expected
        assertNotNull("Result does not exist", 
                result);
 
        assertEquals("Response does not match expected value", 
            5, result, ASSERT_PRECISION);
    }

}
