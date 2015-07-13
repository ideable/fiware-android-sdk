
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
    "devices"
})
public class RegisterDeviceRequest {

    @JsonProperty("devices")
    private List<Device> devices = new ArrayList<Device>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The devices
     */
    @JsonProperty("devices")
    public List<Device> getDevices() {
        return devices;
    }

    /**
     * 
     * @param devices
     *     The devices
     */
    @JsonProperty("devices")
    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    public RegisterDeviceRequest withDevices(List<Device> devices) {
        this.devices = devices;
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

    public RegisterDeviceRequest withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    public static class Builder {
        private List<Device> devices = new ArrayList<Device>();

        private Builder() {
        }

        public static Builder aRegisterDeviceRequest() {
            return new Builder();
        }

        public Builder withDevices(List<Device> devices) {
            this.devices = devices;
            return this;
        }

        public Builder but() {
            return aRegisterDeviceRequest().withDevices(devices);
        }

        public RegisterDeviceRequest build() {
            RegisterDeviceRequest registerDeviceRequest = new RegisterDeviceRequest();
            registerDeviceRequest.setDevices(devices);
            return registerDeviceRequest;
        }
    }
}
