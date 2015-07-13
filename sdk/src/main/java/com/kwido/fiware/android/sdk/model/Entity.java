
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
    "type",
    "attributes"
})
public class Entity {

    @JsonProperty("type")
    private String type;
    @JsonProperty("attributes")
    private List<EntityAttribute> attributes = new ArrayList<EntityAttribute>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public Entity withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * 
     * @return
     *     The attributes
     */
    @JsonProperty("attributes")
    public List<EntityAttribute> getAttributes() {
        return attributes;
    }

    /**
     * 
     * @param attributes
     *     The attributes
     */
    @JsonProperty("attributes")
    public void setAttributes(List<EntityAttribute> attributes) {
        this.attributes = attributes;
    }

    public Entity withAttributes(List<EntityAttribute> attributes) {
        this.attributes = attributes;
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

    public Entity withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }


    public static class Builder {
        private String type;
        private List<EntityAttribute> attributes = new ArrayList<EntityAttribute>();

        private Builder() {
        }

        public static Builder anEntity() {
            return new Builder();
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withAttributes(List<EntityAttribute> attributes) {
            this.attributes = attributes;
            return this;
        }

        public Builder but() {
            return anEntity().withType(type).withAttributes(attributes);
        }

        public Entity build() {
            Entity entity = new Entity();
            entity.setType(type);
            entity.setAttributes(attributes);
            return entity;
        }
    }
}
