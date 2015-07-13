
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
    "attributes"
})
public class EntityAttributes {

    //curl createEntity: localhost:1026/v1/contextEntities/Room1 -s -S --header 'Content-Type: application/json' --header 'Accept: application/json' -X POST -d @- | python -mjson.tool
    //curl updateEntity: localhost:1026/v1/contextEntities/Room1/attributes -s -S --header 'Content-Type: application/json' --header 'Accept: application/json' -X PUT -d @- | python -mjson.tool

    @JsonProperty("attributes")
    private List<EntityAttribute> attributes = new ArrayList<EntityAttribute>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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

    public EntityAttributes withAttributes(List<EntityAttribute> attributes) {
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

    public EntityAttributes withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    public static class Builder {
        private List<EntityAttribute> attributes = new ArrayList<EntityAttribute>();

        private Builder() {
        }

        public static Builder anEntityAttributes() {
            return new Builder();
        }

        public Builder withAttributes(List<EntityAttribute> attributes) {
            this.attributes = attributes;
            return this;
        }

        public Builder but() {
            return anEntityAttributes().withAttributes(attributes);
        }

        public EntityAttributes build() {
            EntityAttributes entityAttributes = new EntityAttributes();
            entityAttributes.setAttributes(attributes);
            return entityAttributes;
        }
    }
}
