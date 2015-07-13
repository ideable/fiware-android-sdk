
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

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "auth"
})
public class TokenRequest {

    @JsonProperty("auth")
    private Auth auth;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The auth
     */
    @JsonProperty("auth")
    public Auth getAuth() {
        return auth;
    }

    /**
     * 
     * @param auth
     *     The auth
     */
    @JsonProperty("auth")
    public void setAuth(Auth auth) {
        this.auth = auth;
    }

    public TokenRequest withAuth(Auth auth) {
        this.auth = auth;
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

    public TokenRequest withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }


    public static class Builder {
        private Auth auth;

        private Builder() {
        }

        public static Builder aTokenRequest() {
            return new Builder();
        }

        public Builder withAuth(Auth auth) {
            this.auth = auth;
            return this;
        }

        public Builder but() {
            return aTokenRequest().withAuth(auth);
        }

        public TokenRequest build() {
            TokenRequest tokenRequest = new TokenRequest();
            tokenRequest.setAuth(auth);
            return tokenRequest;
        }
    }

    @Override
    public String toString() {
        return "TokenRequest{" +
                "auth=" + auth +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
