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
package com.kwido.fiware.android.sdk.endpoints;

import com.kwido.fiware.android.sdk.model.RegisterDeviceRequest;

import com.kwido.fiware.android.sdk.utils.Constants;
import retrofit.Callback;
import retrofit.http.*;

/**
 * IDAS client
 */
public interface IdasClient {

    /**
     * Registers a new device
     *
     * @param registerDeviceRequest RegisterDeviceRequest
     * @param callback              Callback<Void>
     */
    @POST("/devices")
    @Headers({"Content-Type: application/json"})
    void registerDevice(@Header(Constants.HEADER_FIWARE_SERVICE) String fiwareService,
                        @Header(Constants.HEADER_FIWARE_SERVICEPATH) String fiwareServicePath,
                        @Body RegisterDeviceRequest registerDeviceRequest, Callback<Void> callback);

    /**
     * Sends observations (measurements) for the given deviceId
     *
     * @param fiwareService String Fiware Service: tenant
     * @param fiwareServicePath String Fiware Service Path: subservice
     * @param apikey       String Idas API Key
     * @param deviceId     String DeviceId
     * @param measurements String. Example: temperature|36.1#weight|87.54
     * @param callback     Callback<Void>
     */
    @POST("/d")
    @Headers({"Content-Type: text/plain"})
    void sendObservations(@Header(Constants.HEADER_FIWARE_SERVICE) String fiwareService,
                          @Header(Constants.HEADER_FIWARE_SERVICEPATH) String fiwareServicePath,
                          @Query("k") String apikey,
                          @Query("i") String deviceId,
                          @Body String measurements,
                          Callback<Void> callback);

    /**
     * Deletes device
     *
     * @param entityId String
     * @param callback Callback<Void>
     */
    @DELETE("/devices/{entityId}")
    void deleteDevice(@Path("entityId") String entityId, Callback<Void> callback);

    /**
     * Get polling commands
     *
     * @param apikey   String Idas API Key
     * @param deviceId String DeviceId
     * @param callback Callback<Void>
     */
    @GET("/d")
    void getPollingCommands(@Query("k") String apikey, @Query("i") String deviceId, Callback<Void> callback);


}
