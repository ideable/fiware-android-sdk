
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
    "is_admin",
    "roles"
})
public class Metadata {

    @JsonProperty("is_admin")
    private int isAdmin;
    @JsonProperty("roles")
    private List<Object> roles = new ArrayList<Object>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The isAdmin
     */
    @JsonProperty("is_admin")
    public int getIsAdmin() {
        return isAdmin;
    }

    /**
     * 
     * @param isAdmin
     *     The is_admin
     */
    @JsonProperty("is_admin")
    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Metadata withIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
        return this;
    }

    /**
     * 
     * @return
     *     The roles
     */
    @JsonProperty("roles")
    public List<Object> getRoles() {
        return roles;
    }

    /**
     * 
     * @param roles
     *     The roles
     */
    @JsonProperty("roles")
    public void setRoles(List<Object> roles) {
        this.roles = roles;
    }

    public Metadata withRoles(List<Object> roles) {
        this.roles = roles;
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

    public Metadata withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "Metadata{" +
                "isAdmin=" + isAdmin +
                ", roles=" + roles +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
