package com.axiomatics.xacml.json.client;

import com.axiomatics.xacml.json.model.Request;
import com.axiomatics.xacml.json.model.Response;

/**
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
public interface PDPClient {
    Response executeAuthorizationRequest(Request request);
}
