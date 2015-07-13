
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
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "code",
    "reasonPhrase"
})
public class StatusCode {

    @JsonProperty("code")
    private String code;
    @JsonProperty("reasonPhrase")
    private String reasonPhrase;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The code
     */
    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    public StatusCode withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * 
     * @return
     *     The reasonPhrase
     */
    @JsonProperty("reasonPhrase")
    public String getReasonPhrase() {
        return reasonPhrase;
    }

    /**
     * 
     * @param reasonPhrase
     *     The reasonPhrase
     */
    @JsonProperty("reasonPhrase")
    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    public StatusCode withReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
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

    public StatusCode withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

}
