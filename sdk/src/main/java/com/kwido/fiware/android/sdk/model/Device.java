
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
        "device_id",
        "entity_name",
        "entity_type",
        "protocol",
        "timezone",
        "commands",
        "attributes",
        "static_attributes"
})
public class Device {

    @JsonProperty("device_id")
    private String deviceId;
    @JsonProperty("entity_name")
    private String entityName;
    @JsonProperty("entity_type")
    private String entityType;
    @JsonProperty("protocol")
    private String protocol;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("commands")
    private List<Command> commands = new ArrayList<Command>();
    @JsonProperty("attributes")
    private List<DeviceAttribute> attributes = new ArrayList<DeviceAttribute>();
    @JsonProperty("static_attributes")
    private List<EntityAttribute> staticAttributes = new ArrayList<EntityAttribute>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The deviceId
     */
    @JsonProperty("device_id")
    public String getDeviceId() {
        return deviceId;
    }

    /**
     * 
     * @param deviceId
     *     The device_id
     */
    @JsonProperty("device_id")
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Device withDeviceId(String deviceId) {
        this.deviceId = deviceId;
        return this;
    }

    /**
     * 
     * @return
     *     The entityName
     */
    @JsonProperty("entity_name")
    public String getEntityName() {
        return entityName;
    }

    /**
     * 
     * @param entityName
     *     The entity_name
     */
    @JsonProperty("entity_name")
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Device withEntityName(String entityName) {
        this.entityName = entityName;
        return this;
    }

    /**
     * 
     * @return
     *     The entityType
     */
    @JsonProperty("entity_type")
    public String getEntityType() {
        return entityType;
    }

    /**
     * 
     * @param entityType
     *     The entity_type
     */
    @JsonProperty("entity_type")
    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }

    public Device withEntityType(String entityType) {
        this.entityType = entityType;
        return this;
    }

    /**
     * 
     * @return
     *     The protocol
     */
    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    /**
     * 
     * @param protocol
     *     The protocol
     */
    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Device withProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

    /**
     * 
     * @return
     *     The timezone
     */
    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    /**
     * 
     * @param timezone
     *     The timezone
     */
    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Device withTimezone(String timezone) {
        this.timezone = timezone;
        return this;
    }

    /**
     * 
     * @return
     *     The commands
     */
    @JsonProperty("commands")
    public List<Command> getCommands() {
        return commands;
    }

    /**
     *
     * @param commands
     *     The commands
     */
    @JsonProperty("commands")
    public void setCommands(List<Command> commands) {
        this.commands = commands;
    }

    public Device withCommands(List<Command> commands) {
        this.commands = commands;
        return this;
    }

    /**
     *
     * @return
     *     The attributes
     */
    @JsonProperty("attributes")
    public List<DeviceAttribute> getAttributes() {
        return attributes;
    }

    /**
     * 
     * @param attributes
     *     The attributes
     */
    @JsonProperty("attributes")
    public void setAttributes(List<DeviceAttribute> attributes) {
        this.attributes = attributes;
    }

    public Device withAttributes(List<DeviceAttribute> attributes) {
        this.attributes = attributes;
        return this;
    }

    /**
     *
     * @return
     *     The staticAttributes
     */
    @JsonProperty("static_attributes")
    public List<EntityAttribute> getStaticAttributes() {
        return staticAttributes;
    }

    /**
     *
     * @param staticAttributes
     *     The static_attributes
     */
    @JsonProperty("static_attributes")
    public void setStaticAttributes(List<EntityAttribute> staticAttributes) {
        this.staticAttributes = staticAttributes;
    }

    public Device withStaticAttributes(List<EntityAttribute> staticAttributes) {
        this.staticAttributes = staticAttributes;
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

    public Device withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }


    public static class Builder {
        private String deviceId;
        private String entityName;
        private String entityType;
        private String protocol;
        private String timezone;
        private List<Command> commands = new ArrayList<Command>();
        private List<DeviceAttribute> attributes = new ArrayList<DeviceAttribute>();
        private List<EntityAttribute> staticAttributes = new ArrayList<EntityAttribute>();

        private Builder() {
        }

        public static Builder aDevice() {
            return new Builder();
        }

        public Builder withDeviceId(String deviceId) {
            this.deviceId = deviceId;
            return this;
        }

        public Builder withEntityName(String entityName) {
            this.entityName = entityName;
            return this;
        }

        public Builder withEntityType(String entityType) {
            this.entityType = entityType;
            return this;
        }

        public Builder withProtocol(String protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder withTimezone(String timezone) {
            this.timezone = timezone;
            return this;
        }

        public Builder withCommands(List<Command> commands) {
            this.commands = commands;
            return this;
        }

        public Builder withAttributes(List<DeviceAttribute> attributes) {
            this.attributes = attributes;
            return this;
        }

        public Builder withStaticAttributes(List<EntityAttribute> staticAttributes) {
            this.staticAttributes = staticAttributes;
            return this;
        }

        public Builder but() {
            return aDevice().withDeviceId(deviceId).withEntityName(entityName).withEntityType(entityType).withProtocol(protocol).withTimezone(timezone).withCommands(commands).withAttributes(attributes).withStaticAttributes(staticAttributes);
        }

        public Device build() {
            Device device = new Device();
            device.setDeviceId(deviceId);
            device.setEntityName(entityName);
            device.setEntityType(entityType);
            device.setProtocol(protocol);
            device.setTimezone(timezone);
            device.setCommands(commands);
            device.setAttributes(attributes);
            device.setStaticAttributes(staticAttributes);
            return device;
        }
    }
}
