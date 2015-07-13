
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
    "username",
    "password"
})
public class PasswordCredentials {

    @JsonProperty("username")
    private String username;
    @JsonProperty("password")
    private String password;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The username
     */
    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    public PasswordCredentials withUsername(String username) {
        this.username = username;
        return this;
    }

    /**
     * 
     * @return
     *     The password
     */
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * 
     * @param password
     *     The password
     */
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    public PasswordCredentials withPassword(String password) {
        this.password = password;
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

    public PasswordCredentials withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }


    public static class Builder {
        private String username;
        private String password;

        private Builder() {
        }

        public static Builder aPasswordCredentials() {
            return new Builder();
        }

        public Builder withUsername(String username) {
            this.username = username;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder but() {
            return aPasswordCredentials().withUsername(username).withPassword(password);
        }

        public PasswordCredentials build() {
            PasswordCredentials passwordCredentials = new PasswordCredentials();
            passwordCredentials.setUsername(username);
            passwordCredentials.setPassword(password);
            return passwordCredentials;
        }
    }

    @Override
    public String toString() {
        return "PasswordCredentials{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
