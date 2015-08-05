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

    private static final String TAG = FiwareFacade.class.getSimpleName();

    private static final String LOG_DESTROY = "Destroy ImageLoader";
    private static final String LOG_INIT_CONFIG = "Initialize FiwareFacade with configuration";
    private static final String WARNING_RE_INIT_CONFIG = "Try to initialize FiwareFacade which had already been initialized before. " + "To re-init FiwareFacade with new configuration call FiwareFacade.destroy() at first.";
    private static final String ERROR_INIT_CONFIG_WITH_NULL = "FiwareFacade configuration can not be initialized with null";

    private volatile static FiwareFacade instance;

    /** Returns singleton class instance */
    public static FiwareFacade getInstance() {
        if (instance == null) {
            synchronized (FiwareFacade.class) {
                if (instance == null) {
                    instance = new FiwareFacade();
                }
            }
        }
        return instance;
    }

    private OrionClient orionClient = null;
    private IdasClient idasClient = null;
    private CloudLabClient cloudLabClient = null;

    private String token = null;

    private FiwareConfiguration configuration;

    protected FiwareFacade() {
    }

    /**
     * Initializes FiwareFacade instance with configuration.<br />
     * If configurations was set before ( {@link #isInited()} == true) then this method does nothing.<br />
     * To force initialization with new configuration you should {@linkplain #destroy() destroy FiwareFacade} at first.
     *
     * @param configuration {@linkplain FiwareConfiguration ImageLoader configuration}
     * @throws IllegalArgumentException if <b>configuration</b> parameter is null
     */
    public synchronized void init(FiwareConfiguration configuration) {
        if (configuration == null) {
            throw new IllegalArgumentException(ERROR_INIT_CONFIG_WITH_NULL);
        }
        if (!isInited()) {
            Log.d(TAG, LOG_INIT_CONFIG);

            // init clients
            cloudLabClient = ServiceGenerator.createService(CloudLabClient.class, configuration.getCloudlabEndpoint());
            orionClient = ServiceGenerator.createService(OrionClient.class, configuration.getOrionEndpoint(), configuration.getOrionAuthToken());
            idasClient = ServiceGenerator.createService(IdasClient.class, configuration.getIdasEndpoint(), configuration.getIdasAuthToken());

            this.configuration = configuration;
        } else {
            Log.w(TAG, WARNING_RE_INIT_CONFIG);
        }
    }

    /**
     * Returns <b>true</b> - if FiwareFacade {@linkplain #init(FiwareConfiguration) is initialized with
     * configuration}; <b>false</b> - otherwise
     */
    public boolean isInited() {
        return configuration != null;
    }

    /**
     * Clears current configuration. <br />
     * You can {@linkplain #init(FiwareConfiguration) init} FiwareFacade with new configuration after calling this
     * method.
     */
    public void destroy() {
        if (isInited()) {
            Log.d(TAG, LOG_DESTROY);
        }

        // Clear clients
        orionClient = null;
        idasClient = null;
        cloudLabClient = null;

        configuration = null;
    }


    /**
     * Returns an OrionClient which contains several operations for working with an Orion Context Broker instance
     * @return OrionClient
     */
    public OrionClient getOrionClient() {
        return orionClient;
    }

    /**
     * Returns an IdasClient which contains several operations for working with an Idas instance
     * @return IdasClient
     */
    public IdasClient getIdasClient() {
        return idasClient;
    }

    /**
     * Returns a CloudLabClient which contains several operations for working with a CloudLab instance
     * @return
     */
    public CloudLabClient getCloudLabClient() {
        return cloudLabClient;
    }

}
