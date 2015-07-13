
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

package com.kwido.fiware.android.sdk.model;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "contextResponses"
})
public class QueryContextComplexResponse {

    //Response to queryByEntityType: curl localhost:1026/v1/contextEntityTypes/Car -s -S --header 'Accept: application/json' | python -mjson.tool
    //Response to queryByEntityTypeAndAtrtribute: curl localhost:1026/v1/contextEntityTypes/Car/attributes/speed -s -S --header 'Accept: application/json' | python -mjson.tool
    //Response to getAllEntities: curl localhost:1026/v1/contextEntities -s -S --header 'Content-Type: application/json' --header 'Accept: application/json' | python -mjson.tool

    @JsonProperty("contextResponses")
    private List<ContextComplexResponse> contextComplexResponses = new ArrayList<ContextComplexResponse>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The contextComplexResponses
     */
    @JsonProperty("contextComplexResponses")
    public List<ContextComplexResponse> getContextResponses() {
        return contextComplexResponses;
    }

    /**
     * 
     * @param contextComplexResponses
     *     The contextComplexResponses
     */
    @JsonProperty("contextResponses")
    public void setContextResponses(List<ContextComplexResponse> contextComplexResponses) {
        this.contextComplexResponses = contextComplexResponses;
    }

    public QueryContextComplexResponse withContextResponses(List<ContextComplexResponse> contextComplexResponses) {
        this.contextComplexResponses = contextComplexResponses;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public QueryContextComplexResponse withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
