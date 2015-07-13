/*
 * Copyright 2015 Ideable Solutions, S.L.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kwido.fiware.android.sdk;

import android.util.Log;

import com.kwido.fiware.android.sdk.endpoints.CloudLabClient;
import com.kwido.fiware.android.sdk.endpoints.IdasClient;
import com.kwido.fiware.android.sdk.endpoints.OrionClient;
import com.kwido.fiware.android.sdk.model.Auth;
import com.kwido.fiware.android.sdk.model.PasswordCredentials;
import com.kwido.fiware.android.sdk.model.TokenRequest;
import com.kwido.fiware.android.sdk.model.TokenResponse;
import com.kwido.fiware.android.sdk.utils.Constants;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by arkaitz on 25/06/2015.
 */
public class FiwareFacade {

    private static final String TAG = "FiwareFacade";

    private static FiwareFacade instance;

    public static FiwareFacade getInstance(String orionBaseUrl, String idasBaseUrl, String cloudlabBaseUrl, String cloudlabUsername, String cloudlabPassword) {
        if (instance == null) {
            instance = new FiwareFacade(orionBaseUrl, idasBaseUrl, cloudlabBaseUrl, cloudlabUsername, cloudlabPassword);
        }
        return instance;
    }

    /**
     * Returns a new instance of FiwareFacade ant initializes Orion, Idas and CloudLab clients
     * @param token String
     * @return FiwareFacade instance
     */
    public static FiwareFacade getInstance(String orionBaseUrl, String idasBaseUrl, String cloudlabBaseUrl, String token) {
        FiwareFacade newInstance = new FiwareFacade(orionBaseUrl, idasBaseUrl, cloudlabBaseUrl, token);

        newInstance.orionClient = ServiceGenerator.createService(OrionClient.class, orionBaseUrl, newInstance.token, false);
        newInstance.idasClient = ServiceGenerator.createService(IdasClient.class, idasBaseUrl, newInstance.token, true);
        newInstance.cloudLabClient = ServiceGenerator.createService(CloudLabClient.class, cloudlabBaseUrl);

        return newInstance;
    }

    private String token = null;

    private OrionClient orionClient = null;
    private IdasClient idasClient = null;
    private CloudLabClient cloudLabClient = null;

    private String orionBaseUrl;
    private String cloudlabBaseUrl;
    private String idasBaseUrl;

    private String cloudlabUsername;
    private String cloudlabPassword;


    private FiwareFacade(String orionBaseUrl, String idasBaseUrl, String cloudlabBaseUrl, String cloudlabUsername, String cloudlabPassword) {

        this.orionBaseUrl = orionBaseUrl;
        this.cloudlabBaseUrl = cloudlabBaseUrl;
        this.idasBaseUrl = idasBaseUrl;
        this.cloudlabUsername = cloudlabUsername;
        this.cloudlabPassword = cloudlabPassword;

        initFacade();

    }

    private FiwareFacade(String orionBaseUrl, String idasBaseUrl, String cloudlabBaseUrl, String cloudlabToken) {

        this.orionBaseUrl = orionBaseUrl;
        this.cloudlabBaseUrl = cloudlabBaseUrl;
        this.idasBaseUrl = idasBaseUrl;

        this.token = cloudlabToken;

        initFacade();

    }

    /**
     * Gets a new token and initializes Orion, Idas and CloudLab clients
     */
    private void initFacade(){
        if(null == cloudLabClient){
            cloudLabClient = ServiceGenerator.createService(CloudLabClient.class, cloudlabBaseUrl);
        }

        if (token == null) {

            cloudLabClient.getToken(TokenRequest.Builder.aTokenRequest()
                    .withAuth(Auth.Builder.anAuth().withPasswordCredentials(PasswordCredentials.Builder.aPasswordCredentials()
                            .withUsername(cloudlabUsername)
                            .withPassword(cloudlabPassword)
                            .build()).build())
                    .build(), new Callback<TokenResponse>() {

                @Override
                public void success(TokenResponse tokenResponse, Response response) {
                    Log.d(TAG, "getToken success " + tokenResponse);
                    token = tokenResponse.getAccess().getToken().getId();
                    orionClient = ServiceGenerator.createService(OrionClient.class, orionBaseUrl, token, false);
                    idasClient = ServiceGenerator.createService(IdasClient.class, idasBaseUrl, token, true);
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d(TAG, "getToken failure " + error);
                }
            });

        }
    }



    /**
     * Returns an OrionClient which contains several operations for working with an Orion Context Broker instance
     * @return OrionClient
     */
    public OrionClient getOrionClient() {
        if (orionClient == null) {
            //orionClient = ServiceGenerator.createService(OrionClient.class, Constants.BASE_URL_ORION, "6d361980346942ae882f0632fe578cf1", false);
            initFacade();
        }
        return orionClient;
    }

    /**
     * Returns an IdasClient which contains several operations for working with an Idas instance
     * @return IdasClient
     */
    public IdasClient getIdasClient() {
        if (idasClient == null) {
            //idasClient = ServiceGenerator.createService(IdasClient.class, Constants.BASE_URL_IDAS, "6d361980346942ae882f0632fe578cf1", true);
            initFacade();
        }
        return idasClient;
    }

    /**
     * Returns a CloudLabClient which contains several operations for working with a CloudLab instance
     * @return
     */
    public CloudLabClient getCloudLabClient() {
        if (cloudLabClient == null) {
            //cloudLabClient = ServiceGenerator.createService(CloudLabClient.class, Constants.BASE_URL_CLOUDLAB);
            initFacade();
        }
        return cloudLabClient;
    }

}
