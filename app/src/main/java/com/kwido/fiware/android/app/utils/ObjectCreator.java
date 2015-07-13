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

package com.kwido.fiware.android.app.utils;

import com.kwido.fiware.android.app.model.EntityType;
import com.kwido.fiware.android.sdk.model.Command;
import com.kwido.fiware.android.sdk.model.Device;
import com.kwido.fiware.android.sdk.model.DeviceAttribute;
import com.kwido.fiware.android.sdk.model.RegisterDeviceRequest;
import com.kwido.fiware.android.sdk.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arkaitz on 24/06/2015.
 */
public class ObjectCreator {

    /**
     * @param deviceId   Recommended the 3 lower hexa bytes of MAC. Example: "14:da:e9"
     * @param entityName Used as EntityId on Orion. Example: "kwido:tenant_or_client:personId:hr"
     * @param entityType Kwido Orion EntityTypes available at Constants.ENTITY_TYPES
     * @return RegisterDeviceRequest
     * @see EntityType
     */
    public static RegisterDeviceRequest createRegisterDeviceRequest(final String deviceId,
                                                                    final String entityName,
                                                                    final EntityType entityType) {
        List<Command> commands = null;
        if (entityType.equals(EntityType.DEVICE_CHECK)) {
            Command command = Command.Builder.aCommand()
                    .withName("RawCommand")
                    .withType("command")
                    .withValue("[Dev_ID]@RawCommand|%s")
                    .build();
            commands = new ArrayList<Command>();
            commands.add(command);
        }

        Device device = Device.Builder.aDevice()
                .withDeviceId(deviceId)
                .withEntityName(entityName)
                .withEntityType(entityType.toString())
                .withProtocol(Constants.PROTOCOL_UL20)
                .withTimezone(Constants.TIMEZONE)
                //.withStaticAttributes(createDeviceAttributes(entityType))
                .withAttributes(createDeviceAttributes(entityType))
                .withCommands(commands)
                .build();
        List<Device> devices = new ArrayList<Device>();
        devices.add(device);
        return RegisterDeviceRequest.Builder
                .aRegisterDeviceRequest()
                .withDevices(devices)
                .build();
    }

    /**
     * @param personId  String the PersonId
     * @param tenantId  String Kwido Tenant identifier
     * @param androidId String the AndroidId
     * @param entityType      Constants.ENTITY_TYPES
     * @return String: Example: kwido:tenantId:personId:hr
     * @see EntityType
     */
    public static String createEntityId(String personId, String tenantId, String androidId, EntityType entityType) {
        StringBuilder entityId = new StringBuilder();
        entityId.append(Config.URN_PREFIX)
                .append((null == tenantId) ? "global" : tenantId)
                .append(Constants.COLONS)
                .append((null == personId) ? "ideable" : personId)
                .append(Constants.COLONS);

        switch (entityType) {
            case HEALTH_RECORD:
                entityId.append("hr");
                break;
            case DEVICE_CHECK:
                entityId.append("dc")
                        .append(Constants.COLONS)
                        .append(androidId);
                break;
            default:
                entityId.append("item");
                break;
        }
        return entityId.toString();
    }

    /**
     * Creates a devideID as personId:androidId
     *
     * @param personId   String the PersonId
     * @param androidId  String the AndroidId
     * @param entityType Constants.ENTITY_TYPES
     * @return String: Example: kwido:tenantId:personId:hr
     * @see EntityType
     */
    public static String createDeviceId(String personId, String androidId, EntityType entityType) {
        StringBuilder devideId = new StringBuilder();
        devideId.append(personId)
                .append(Constants.COLONS)
                .append(androidId);
        if (entityType.equals(EntityType.DEVICE_CHECK)) {
            devideId.append(Constants.COLONS)
                    .append("dc");
        } else if (entityType.equals(EntityType.HEALTH_RECORD)) {
            devideId.append(Constants.COLONS)
                    .append("hr");
        }
        return devideId.toString();
    }

    private static List<DeviceAttribute> createDeviceAttributes(EntityType entityType) {
        List<DeviceAttribute> deviceAttributes = null;
        switch (entityType) {
            case HEALTH_RECORD:
                deviceAttributes = createHealthRecordDeviceAttributes();
                break;
            case DEVICE_CHECK:
                deviceAttributes = createDeviceCheckDeviceAttributes();
                break;
        }
        return deviceAttributes;
    }

    private static List<DeviceAttribute> createHealthRecordDeviceAttributes() {
        List<DeviceAttribute> deviceAttributes = new ArrayList<DeviceAttribute>();
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("status")
                .withObjectId("status")
                .withType("boolean").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("weight")
                .withObjectId("weight")
                .withType("double").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("blood_pressure")
                .withObjectId("blood_pressure")
                .withType("double").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("blood_pressure_sis")
                .withObjectId("blood_pressure_sis")
                .withType("double").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("heart_rate")
                .withObjectId("heart_rate")
                .withType("int").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("temperature")
                .withObjectId("temperature")
                .withType("double").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("glucose")
                .withObjectId("glucose")
                .withType("double").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("inr")
                .withObjectId("inr")
                .withType("double").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("cholesterol")
                .withObjectId("cholesterol")
                .withType("double").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("blood_oxygen")
                .withObjectId("blood_oxygen")
                .withType("double").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("date")
                .withObjectId("date")
                .withType("long").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("valid")
                .withObjectId("valid")
                .withType("boolean").build());
        return deviceAttributes;
    }

    private static List<DeviceAttribute> createDeviceCheckDeviceAttributes() {
        List<DeviceAttribute> deviceAttributes = new ArrayList<DeviceAttribute>();
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("timestamp")
                .withObjectId("timestamp")
                .withType("Date").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("appVersion")
                .withObjectId("appVersion")
                .withType("String").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("trafficDataReceived")
                .withObjectId("trafficDataReceived")
                .withType("long").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("trafficDataTransmited")
                .withObjectId("trafficDataTransmited")
                .withType("long").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("batteryStatusMode")
                .withObjectId("batteryStatusMode")
                .withType("String").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("batteryStatusLevel")
                .withObjectId("batteryStatusLevel")
                .withType("int").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("freeSpace")
                .withObjectId("freeSpace")
                .withType("long").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("totalSpace")
                .withObjectId("totalSpace")
                .withType("long").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("usedSpace")
                .withObjectId("usedSpace")
                .withType("long").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("latitude")
                .withObjectId("latitude")
                .withType("double").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("longitude")
                .withObjectId("longitude")
                .withType("double").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("connectedToWifi")
                .withObjectId("connectedToWifi")
                .withType("boolean").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("wifiLevel")
                .withObjectId("wifiLevel")
                .withType("int").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("wifiSpeed")
                .withObjectId("wifiSpeed")
                .withType("int").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("timeZone")
                .withObjectId("timeZone")
                .withType("String").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("locale")
                .withObjectId("locale")
                .withType("String").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("networkInfoSubTypeName")
                .withObjectId("networkInfoSubTypeName")
                .withType("String").build());
        deviceAttributes.add(DeviceAttribute.Builder.aDeviceAttribute()
                .withName("networkInfoTypeName")
                .withObjectId("networkInfoTypeName")
                .withType("String").build());
        return deviceAttributes;
    }
}
