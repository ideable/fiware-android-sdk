
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
    "name",
    "type",
    "object_id"
})
public class DeviceAttribute {

    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("object_id")
    private String objectId;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public DeviceAttribute withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public DeviceAttribute withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * 
     * @return
     *     The objectId
     */
    @JsonProperty("object_id")
    public String getObjectId() {
        return objectId;
    }

    /**
     * 
     * @param objectId
     *     The object_id
     */
    @JsonProperty("object_id")
    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public DeviceAttribute withObjectId(String objectId) {
        this.objectId = objectId;
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

    public DeviceAttribute withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }


    public static class Builder {
        private String name;
        private String type;
        private String objectId;

        private Builder() {
        }

        public static Builder aDeviceAttribute() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withObjectId(String objectId) {
            this.objectId = objectId;
            return this;
        }

        public Builder but() {
            return aDeviceAttribute().withName(name).withType(type).withObjectId(objectId);
        }

        public DeviceAttribute build() {
            DeviceAttribute deviceAttribute = new DeviceAttribute();
            deviceAttribute.setName(name);
            deviceAttribute.setType(type);
            deviceAttribute.setObjectId(objectId);
            return deviceAttribute;
        }
    }
}
