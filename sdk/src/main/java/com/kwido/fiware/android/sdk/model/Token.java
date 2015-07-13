
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
    "issued_at",
    "expires",
    "id",
    "audit_ids"
})
public class Token {

    @JsonProperty("issued_at")
    private String issuedAt;
    @JsonProperty("expires")
    private String expires;
    @JsonProperty("id")
    private String id;
    @JsonProperty("audit_ids")
    private List<String> auditIds = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The issuedAt
     */
    @JsonProperty("issued_at")
    public String getIssuedAt() {
        return issuedAt;
    }

    /**
     * 
     * @param issuedAt
     *     The issued_at
     */
    @JsonProperty("issued_at")
    public void setIssuedAt(String issuedAt) {
        this.issuedAt = issuedAt;
    }

    public Token withIssuedAt(String issuedAt) {
        this.issuedAt = issuedAt;
        return this;
    }

    /**
     * 
     * @return
     *     The expires
     */
    @JsonProperty("expires")
    public String getExpires() {
        return expires;
    }

    /**
     * 
     * @param expires
     *     The expires
     */
    @JsonProperty("expires")
    public void setExpires(String expires) {
        this.expires = expires;
    }

    public Token withExpires(String expires) {
        this.expires = expires;
        return this;
    }

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Token withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * 
     * @return
     *     The auditIds
     */
    @JsonProperty("audit_ids")
    public List<String> getAuditIds() {
        return auditIds;
    }

    /**
     * 
     * @param auditIds
     *     The audit_ids
     */
    @JsonProperty("audit_ids")
    public void setAuditIds(List<String> auditIds) {
        this.auditIds = auditIds;
    }

    public Token withAuditIds(List<String> auditIds) {
        this.auditIds = auditIds;
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

    public Token withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return "Token{" +
                "issuedAt='" + issuedAt + '\'' +
                ", expires='" + expires + '\'' +
                ", id='" + id + '\'' +
                ", auditIds=" + auditIds +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
