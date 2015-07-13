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

import com.kwido.fiware.android.sdk.model.RegisterDeviceErrorResponse;
import com.kwido.fiware.android.sdk.model.RegisterDeviceRequest;
import com.kwido.fiware.android.sdk.model.TokenRequest;
import com.kwido.fiware.android.sdk.model.TokenResponse;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.POST;

/**
 * IDAS client
 */
public interface CloudLabClient {

	/**
	 * Gets a valid token
	 * @param tokenRequest TokenRequest
	 * @param callback Callback<TokenResponse>
	 */
	@POST("/tokens")
	void getToken(@Body TokenRequest tokenRequest, Callback<TokenResponse> callback);

}
