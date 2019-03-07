/*
 * APIMATICCalculatorV1Lib
 *
 * This file was automatically generated for testing by APIMATIC v2.0 ( https://apimatic.io ).
 */
package io.apimatic.examples;

import io.apimatic.examples.controllers.*;
import io.apimatic.examples.http.client.HttpClient;

public class APIMATICCalculatorV1Client {
    /**
     * Singleton access to CalculatorEPs controller
     * @return	Returns the CalculatorEPs instance 
     */
    public CalculatorEPs getCalculatorEPs() {
        return CalculatorEPs.getInstance();
    }

    /**
     * Get the shared http client currently being used for API calls
     * @return The http client instance currently being used
     */
    public HttpClient getSharedHttpClient() {
        return BaseController.getClientInstance();
    }
    
    /**
     * Set a shared http client to be used for API calls
     * @param httpClient The http client to use
     */
    public void setSharedHttpClient(HttpClient httpClient) {
        BaseController.setClientInstance(httpClient);
    }

    /**
     * Default constructor 
     */     
    public APIMATICCalculatorV1Client() {
    }

}