/*
 * MyCalculatorLib
 *
 * This file was automatically generated by APIMATIC v2.0 ( https://apimatic.io ) on 12/02/2016
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

public class OperationController extends BaseController {    
    //private static variables for the singleton pattern
    private static Object syncObject = new Object();
    private static OperationController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the OperationController class 
     */
    public static OperationController getInstance() {
        synchronized (syncObject) {
            if (null == instance) {
                instance = new OperationController();
            }
        }
        return instance;
    }

    /**
     * Calculates the expression using the specified operation.
     * @param    operation    Required parameter: The operator to apply on the variables
     * @param    x    Required parameter: The LHS value
     * @param    y    Required parameter: The RHS value
     * @return    Returns the DynamicResponse response from the API call 
     */
    public DynamicResponse getCalculate(
                final OperationEnum operation,
                final double x,
                final double y
    ) throws Throwable {
        APICallBackCatcher<DynamicResponse> callback = new APICallBackCatcher<DynamicResponse>();
        getCalculateAsync(operation, x, y, callback);
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
    public void getCalculateAsync(
                final OperationEnum operation,
                final double x,
                final double y,
                final APICallBack<DynamicResponse> callBack
    ) {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;
        
        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri);
        _queryBuilder.append("/{operation}");

        //process template parameters
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 5669144514302030575L;
            {
                    put( "operation", (null != operation) ? operation.value() : null );
            }});

        //process query parameters
        APIHelper.appendUrlWithQueryParameters(_queryBuilder, new HashMap<String, Object>() {
            private static final long serialVersionUID = 4825934918862502264L;
            {
                    put( "x", x );
                    put( "y", y );
            }});
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>() {
            private static final long serialVersionUID = 5733220434860818636L;
            {
                    put( "user-agent", "APIMATIC 2.0" );
                    put( "accept", "application/json" );
            }
        };

        //prepare and invoke the API call request to fetch the response
        final HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        //invoke the callback before request if its not null
        if (getHttpCallBack() != null)
        {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        //invoke request and get response
        Runnable _responseTask = new Runnable() {
            public void run() {
                //make the API call
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {

                            //invoke the callback after response if its not null
                            if (getHttpCallBack() != null)	
                            {
                                getHttpCallBack().OnAfterResponse(_context);
                            }

                            //handle errors defined at the API level
                            validateResponse(_response, _context);

                            //extract result from the http response
                            DynamicResponse _result = new DynamicResponse(_response);

                            callBack.onSuccess(_context, _result);
                        } catch (APIException error) {
                            //let the caller know of the error
                            callBack.onFailure(_context, error);
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