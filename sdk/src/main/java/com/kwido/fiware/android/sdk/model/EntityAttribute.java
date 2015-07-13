
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
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "name",
    "type",
    "value"
})
public class EntityAttribute {

    @JsonProperty("name")
    private String name;
    @JsonProperty("type")
    private String type;
    @JsonProperty("value")
    private Object value;
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

    public EntityAttribute withName(String name) {
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

    public EntityAttribute withType(String type) {
        this.type = type;
        return this;
    }

    /**
     * 
     * @return
     *     The value
     */
    @JsonProperty("value")
    public Object getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    @JsonProperty("value")
    public void setValue(Object value) {
        this.value = value;
    }

    public EntityAttribute withValue(String value) {
        this.value = value;
        return this;
    }
    public EntityAttribute withValue(List<EntityAttribute> value) {
        this.value = value;
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

    public EntityAttribute withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    public static class Builder {
        private String name;
        private String type;
        private Object value;

        private Builder() {
        }

        public static Builder anEntityAttribute() {
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

        public Builder withValue(Object value) {
            this.value = value;
            return this;
        }

        public Builder but() {
            return anEntityAttribute().withName(name).withType(type).withValue(value);
        }

        public EntityAttribute build() {
            EntityAttribute entityAttribute = new EntityAttribute();
            entityAttribute.setName(name);
            entityAttribute.setType(type);
            if(value instanceof List){
                entityAttribute.setValue((List<EntityAttribute>) value);
            } else {
                entityAttribute.setValue((String) value);
            }
            return entityAttribute;
        }
    }
}
