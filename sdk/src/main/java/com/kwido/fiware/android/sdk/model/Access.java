
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "token",
    "serviceCatalog",
    "user",
    "metadata"
})
public class Access {

    @JsonProperty("token")
    private Token token;
    @JsonProperty("serviceCatalog")
    private List<Object> serviceCatalog = new ArrayList<Object>();
    @JsonProperty("user")
    private User user;
    @JsonProperty("metadata")
    private Metadata metadata;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The token
     */
    @JsonProperty("token")
    public Token getToken() {
        return token;
    }

    /**
     * 
     * @param token
     *     The token
     */
    @JsonProperty("token")
    public void setToken(Token token) {
        this.token = token;
    }

    public Access withToken(Token token) {
        this.token = token;
        return this;
    }

    /**
     * 
     * @return
     *     The serviceCatalog
     */
    @JsonProperty("serviceCatalog")
    public List<Object> getServiceCatalog() {
        return serviceCatalog;
    }

    /**
     * 
     * @param serviceCatalog
     *     The serviceCatalog
     */
    @JsonProperty("serviceCatalog")
    public void setServiceCatalog(List<Object> serviceCatalog) {
        this.serviceCatalog = serviceCatalog;
    }

    public Access withServiceCatalog(List<Object> serviceCatalog) {
        this.serviceCatalog = serviceCatalog;
        return this;
    }

    /**
     * 
     * @return
     *     The user
     */
    @JsonProperty("user")
    public User getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    @JsonProperty("user")
    public void setUser(User user) {
        this.user = user;
    }

    public Access withUser(User user) {
        this.user = user;
        return this;
    }

    /**
     * 
     * @return
     *     The metadata
     */
    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    /**
     * 
     * @param metadata
     *     The metadata
     */
    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public Access withMetadata(Metadata metadata) {
        this.metadata = metadata;
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

    public Access withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "Access{" +
                "token=" + token +
                ", serviceCatalog=" + serviceCatalog +
                ", user=" + user +
                ", metadata=" + metadata +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
