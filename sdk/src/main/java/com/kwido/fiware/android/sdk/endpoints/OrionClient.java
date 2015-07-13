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

import com.kwido.fiware.android.sdk.model.AttributeValue;
import com.kwido.fiware.android.sdk.model.ContextResponse;
import com.kwido.fiware.android.sdk.model.Entity;
import com.kwido.fiware.android.sdk.model.EntityCreateResponse;
import com.kwido.fiware.android.sdk.model.EntityUpdateResponse;
import com.kwido.fiware.android.sdk.model.QueryContextComplexResponse;
import com.kwido.fiware.android.sdk.model.QueryContextSimpleResponse;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.POST;
import retrofit.http.Path;

public interface OrionClient {

	// ORION CLIENT

	/**
	 * Creates a new Entity with received initial values
	 * @param entityId String
	 * @param entity Entity
	 * @return EntityCreateResponse {"contextResponses", "id", "isPattern", "type" }
	 */
	@POST("/contextEntities/{entityId}")
	void createOrUpdateEntity(@Path("entityId") String entityId, @Body Entity entity, Callback<EntityCreateResponse> callback);

    /**
     * Updates given entity
     * @param entityId String
	 * @param entity Entity
     * @return EntityUpdateResponse {"contextResponses"}
     */
    @POST("/contextEntities/{entityId}/attributes")
	void updateEntity(@Path("entityId") String entityId, @Body Entity entity, Callback<EntityUpdateResponse> callback);

	/**
	 * Create an attribute for the given Entity.
	 * @param entityId String
	 * @param attributeId String
	 * @param attributeValue AttributeValue
	 * @return
	 */
	@POST("/v1/contextEntities/{entityId}/attributes/{attributeId}")
	void addOrUpdateAttribute(@Path("entityId") String entityId, @Path("attributeId") String attributeId, @Body AttributeValue attributeValue, Callback<EntityCreateResponse> callback);

	/**
	 * Query all the attribute values of a given entity
	 * @return QueryContextComplexResponse {"contextResponses"}
	 */
	@POST("/v1/contextEntities")
	void getEntities(Callback<QueryContextSimpleResponse> callback);

	/**
	 * Query all the attribute values of a given entity
	 * @param entityId String
	 * @return QueryContextSimpleResponse {"contextElement","statusCode"}
	 */
	@POST("/v1/contextEntities/{entityId}")
	void getEntity(String entityId, Callback<QueryContextSimpleResponse> callback);

	/**
	 * Query a single attribute value of a given entity
	 * @param entityId String
	 * @return ContextResponse {"attributes","statusCode"}
	 */
	@POST("/v1/contextEntities/{entityId}/attributes/{attributeId}")
	void getEntityAttribute(String entityId, String attributeId, Callback<ContextResponse> callback);

	/**
	 * Get all the attributes for entities of a given type
	 * @param typeId String
	 * @return QueryContextComplexResponse {"contextResponses"}
	 */
	@POST("/v1/contextEntityTypes/{typeId}")
	void getEntityByType(String typeId, Callback<QueryContextComplexResponse> callback);

	/**
	 * Get a given attribute for entities of a given type
	 * @param typeId String
	 * @param attributeId String
	 * @return QueryContextComplexResponse {"contextResponses"}
	 */
	@POST("/v1/contextEntityTypes/{typeId}/attributes/{attributeId}")
	QueryContextComplexResponse getEntityByTypeAndAttribute(String typeId, String attributeId, Callback<QueryContextComplexResponse> callback);


    /*
        // Añadir un estado de un dispositivo para una persona
        @Post("/v2/devices/{deviceId}/persons/{personId}/checks")
        ApiDeviceCheckResult addDeviceCheck(String deviceId, String personId, ApiDeviceCheck deviceCheck);

        // Enviar registro de salud
        @Post("/v2/persons/{personId}/healthrecords")
        ApiHealthRecordResult addHealthRecord(String personId, ApiHealthRecord healthRecord);
    */

}
