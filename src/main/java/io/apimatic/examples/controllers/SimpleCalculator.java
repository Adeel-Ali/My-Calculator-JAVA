/*
 * APIMATICCalculatorDevOpsLib
 *
 * This file was automatically generated for testing by APIMATIC v2.0 ( https://apimatic.io ).
 */
package io.apimatic.examples.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

import io.apimatic.examples.*;
import io.apimatic.examples.models.*;
import io.apimatic.examples.exceptions.*;
import io.apimatic.examples.http.client.HttpClient;
import io.apimatic.examples.http.client.HttpContext;
import io.apimatic.examples.http.request.HttpRequest;
import io.apimatic.examples.http.response.HttpResponse;
import io.apimatic.examples.http.response.HttpStringResponse;
import io.apimatic.examples.http.client.APICallBack;
import io.apimatic.examples.controllers.syncwrapper.APICallBackCatcher;

public class SimpleCalculator extends BaseController {
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    private static SimpleCalculator instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the SimpleCalculator class 
     */
    public static SimpleCalculator getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new SimpleCalculator();
                }
            }
        }
        return instance;
    }

    /**
     * Calculates the expression using the specified operation.
     * @param    operation    Required parameter: The operator to apply on the variables
     * @param    x    Required parameter: The LHS value
     * @param    y    Required parameter: The RHS value
     * @return    Returns the Double response from the API call 
     */
    public Double calculate(
                final OperationType operation,
                final double x,
                final double y
    ) throws Throwable {
        APICallBackCatcher<Double> callback = new APICallBackCatcher<Double>();
        calculateAsync(operation, x, y, callback);
        if(!callback.isSuccess())
            throw callback.getError();
        return callback.getResult();
    }

    /**
     * Calculates the expression using the specified operation.
     * @param    operation    Required parameter: The operator to apply on the variables
     * @param    x    Required parameter: The LHS value
     * @param    y    Required parameter: The RHS value
     * @return    Returns the void response from the API call 
     */
    public void calculateAsync(
                final OperationType operation,
                final double x,
                final double y,
                final APICallBack<Double> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {
                final HttpRequest _request;

                try {
                    //the base uri for api requests
                    String _baseUri = Configuration.baseUri;

                    //prepare query string for API call
                    StringBuilder _queryBuilder = new StringBuilder("/{operation}");

                    //process template parameters
                    Map<String, Object> _templateParameters = new HashMap<String, Object>();
                    _templateParameters.put("operation", (operation != null) ? operation.value() : null);
                    APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

                    ///process query parameters
                    Map<String, Object> _queryParameters = new HashMap<String, Object>();
                    _queryParameters.put("x", x);
                    _queryParameters.put("y", y);
                    APIHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);

                    //validate and preprocess url
                    String _queryUrl = APIHelper.cleanUrl(new StringBuilder(_baseUri).append(_queryBuilder));

                    //load all headers for the outgoing API request
                    Map<String, String> _headers = new HashMap<String, String>();
                    _headers.put("user-agent", BaseController.userAgent);


                    //prepare and invoke the API call request to fetch the response
                    _request = getClientInstance().get(_queryUrl, _headers, null);

                    //invoke the callback before request if its not null
                    if (getHttpCallBack() != null) {
                        getHttpCallBack().OnBeforeRequest(_request);
                    }

                } catch (Throwable e) {
                    callBack.onFailure(null, e);
                    return;
                }

                //invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null) {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            String _responseBody = ((HttpStringResponse)_response).getBody();
                            double _result = Double.parseDouble(_responseBody);

                            //let the caller know of the success
                            callBack.onSuccess(_context, _result);
                        } catch (Exception exception) {
                            //let the caller know of the caught Exception
                            callBack.onFailure(_context, exception);
                        }
                    }
                    public void onFailure(HttpContext _context, Throwable _error) {
                        //invoke the callback after response if its not null
                        if (getHttpCallBack() != null)
 {
                            getHttpCallBack().OnAfterResponse(_context);
                        }

                        //let the caller know of the failure
                        callBack.onFailure(_context, _error);
                    }
                });
            }
        };

        //execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

}