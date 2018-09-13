package com.axiomatics.xacml.json.client;

import com.axiomatics.xacml.json.configuration.PDPConfigurationProperties;
import com.axiomatics.xacml.json.model.Request;
import com.axiomatics.xacml.json.model.Response;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

import java.io.IOException;

/**
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
public class PDPClientImpl {

    private static final MediaType XACML_JSON = MediaType.parse("application/xacml+json");

    private final OkHttpClient pdpHttpClient;
    private final ObjectMapper objectMapper;
    private final String authorizeUrl;

    public PDPClientImpl(PDPConfigurationProperties pdpConfigurationProperties) {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        this.objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        this.pdpHttpClient = PDPClientFactory.buildPDPClient(pdpConfigurationProperties);
        this.authorizeUrl = pdpConfigurationProperties.getPdpHost() + "/authorize";
    }

    public Response executeAuthorizationRequest(Request request) throws JsonProcessingException, IOException {
        String requestString = objectMapper.writeValueAsString(request);

        RequestBody requestBody = RequestBody.create(XACML_JSON, requestString);
        okhttp3.Request httpRequest = new okhttp3.Request.Builder()
            .url(authorizeUrl)
            .post(requestBody)
            .build();

        okhttp3.Response response = pdpHttpClient.newCall(httpRequest).execute();
        if (!response.isSuccessful()) {
            throw new IOException("Unexpected code " + response);
        }

        ResponseBody responseBody = response.body();
        if (null == responseBody) {
            throw new IOException("No body returned in response " + response);
        }

        return objectMapper.readValue(responseBody.string(), Response.class);
    }

}
