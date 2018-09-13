/*
 *  Copyright (C) DAIS TECHNOLOGY, INC - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 */

package com.axiomatics.xacml.json.client;

import com.axiomatics.xacml.json.configuration.PDPConfigurationProperties;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Route;

/**
 * @author Julio Cesar Villalta III <jvillalta@nvisia.com>
 */
public final class PDPClientFactory {

    static OkHttpClient buildPDPClient(PDPConfigurationProperties pdpConfigurationProperties) {
        final String username = pdpConfigurationProperties.getPepUser();
        final String password = pdpConfigurationProperties.getPepPassword();

        return new OkHttpClient.Builder()
            .authenticator((Route route, okhttp3.Response response) -> {
                String credential = Credentials.basic(username, password);
                return response.request().newBuilder().header("Authorization", credential).build();
            })
            .build();
    }

}
