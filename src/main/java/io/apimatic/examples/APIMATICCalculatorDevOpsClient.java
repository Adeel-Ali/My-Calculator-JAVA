/*
 * APIMATICCalculatorDevOpsLib
 *
 * This file was automatically generated for testing by APIMATIC v2.0 ( https://apimatic.io ).
 */
package io.apimatic.examples;

import io.apimatic.examples.controllers.*;
import io.apimatic.examples.http.client.HttpClient;

public class APIMATICCalculatorDevOpsClient {
    /**
     * Singleton access to SimpleCalculator controller
     * @return	Returns the SimpleCalculator instance 
     */
    public SimpleCalculator getSimpleCalculator() {
        return SimpleCalculator.getInstance();
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
    public APIMATICCalculatorDevOpsClient() {
    }

}