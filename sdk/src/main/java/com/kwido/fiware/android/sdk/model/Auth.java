
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
    "passwordCredentials"
})
public class Auth {

    @JsonProperty("passwordCredentials")
    private PasswordCredentials passwordCredentials;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The passwordCredentials
     */
    @JsonProperty("passwordCredentials")
    public PasswordCredentials getPasswordCredentials() {
        return passwordCredentials;
    }

    /**
     * 
     * @param passwordCredentials
     *     The passwordCredentials
     */
    @JsonProperty("passwordCredentials")
    public void setPasswordCredentials(PasswordCredentials passwordCredentials) {
        this.passwordCredentials = passwordCredentials;
    }

    public Auth withPasswordCredentials(PasswordCredentials passwordCredentials) {
        this.passwordCredentials = passwordCredentials;
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

    public Auth withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    public static class Builder {
        private PasswordCredentials passwordCredentials;

        private Builder() {
        }

        public static Builder anAuth() {
            return new Builder();
        }

        public Builder withPasswordCredentials(PasswordCredentials passwordCredentials) {
            this.passwordCredentials = passwordCredentials;
            return this;
        }

        public Builder but() {
            return anAuth().withPasswordCredentials(passwordCredentials);
        }

        public Auth build() {
            Auth auth = new Auth();
            auth.setPasswordCredentials(passwordCredentials);
            return auth;
        }
    }

    @Override
    public String toString() {
        return "Auth{" +
                "passwordCredentials=" + passwordCredentials +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
