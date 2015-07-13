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

import android.util.Log;
import com.kwido.fiware.android.app.model.DeviceCheck;
import com.kwido.fiware.android.app.model.HealthRecord;
import com.kwido.fiware.android.sdk.model.Entity;
import com.kwido.fiware.android.sdk.model.EntityAttribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arkaitz on 18/06/2015.
 */
public class NGSIAdapter {

    private static final String TAG = "NGSIAdapter";

    public static Entity getNGSIEntity(HealthRecord healthRecord) {
        Log.e(TAG, "createNGSIEntity from ApiHealthRecord");

        if(null == healthRecord || null == healthRecord.getType()){
            return null;
        }

        /* JSON objetivo:
            {
                "type": "kwido:HealthRecord",
                "attributes": [
                    {
                        "name": "WEIGHT",
                        "type": "KG",
                        "value": [
                            {
                                "name": "id",
                                "type": "long",
                                "value": "564345"
                            },
                            {
                                "name": "date",
                                "type": "long",
                                "value": "1434622302945"
                            },
                            {
                                "name": "value",
                                "type": "String",
                                "value": "124.2"
                            },
                            {
                                "name": "valid",
                                "type": "boolean",
                                "value": "true"
                            }
                        ]
                    }
                ]
            }
         */

        //TODO gestionar los posibles varios y lanzar exception en su caso, por ahora solo enviamos los no vacíos para poder probar sin NullPointerExceptions
        List<EntityAttribute> attrs = new ArrayList<EntityAttribute>();
        List<EntityAttribute> innerAttrs = new ArrayList<EntityAttribute>();

        if(null != healthRecord.getId()){
            innerAttrs.add(EntityAttribute.Builder.anEntityAttribute()
                    .withName("id")
                    .withType("long")
                    .withValue(String.valueOf(healthRecord.getId()))
                    .build());
        }
        if(null != healthRecord.getDate()) {
            innerAttrs.add(EntityAttribute.Builder.anEntityAttribute()
                    .withName("date")
                    .withType("long")
                    .withValue(String.valueOf(healthRecord.getDate()))
                    .build());
        }
        if(null != healthRecord.getValue()) {
            innerAttrs.add(EntityAttribute.Builder.anEntityAttribute()
                    .withName("value")
                    .withType("String")
                    .withValue(healthRecord.getValue())
                    .build());
        }
        if(null != healthRecord.getValid()) {
            innerAttrs.add(EntityAttribute.Builder.anEntityAttribute()
                    .withName("valid")
                    .withType("boolean")
                    .withValue(String.valueOf(healthRecord.getValid()))
                    .build());
        }

        EntityAttribute entityAttribute = EntityAttribute.Builder.anEntityAttribute()
                .withName(healthRecord.getType().name())
                .withType((null == healthRecord.getUnit()) ? healthRecord.getType().name() : healthRecord.getUnit().name())
                .withValue(innerAttrs)
                .build();

        attrs.add(entityAttribute);

        Entity entity = Entity.Builder.anEntity().withType(Config.URN_PREFIX + HealthRecord.class.getSimpleName()).withAttributes(attrs).build();
        Log.e(TAG, "ApiHealthRecord NGSI Entity created");
        return entity;
    }

    public static Entity getNGSIEntity(DeviceCheck deviceCheck) {
        Log.e(TAG, "createNGSIEntity from ApiDeviceCheck");

        if(null == deviceCheck){
            return null;
        }

        /*
           {
              "type": "kwido:DeviceCheck",
              "attributes" : [
                {
                  "name" : "timeStamp",
                  "type" : "Date",
                  "value" : "1434526385000"
                },
                {
                  "name" : "appVersion",
                  "type" : "String",
                  "value" : "1.2.5"
                },
                {
                  "name" : "trafficData",
                  "type" : "ApiTrafficData",
                  "value" : [ {
                                "name" : "dataReceived",
                                "type" : "long",
                                "value" : "645321"
                                },
                              {
                                "name" : "dataTransmited",
                                "type" : "long",
                                "value" : "562335"
                                }
                             ]
                },
                {
                  "name" : "batteryStatus",
                  "type" : "ApiBatteryStatus",
                  "value" : [ {
                                "name" : "mode",
                                "type" : "String",
                                "value" : "plane"
                                },
                              {
                                "name" : "level",
                                "type" : "int",
                                "value" : "45"
                                }
                             ]
                },
                {
                  "name" : "freeSpace",
                  "type" : "long",
                  "value" : "15620"
                },
                {
                  "name" : "totalSpace",
                  "type" : "long",
                  "value" : "652000"
                },
                {
                  "name" : "usedSpace",
                  "type" : "long",
                  "value" : "48750"
                },
                {
                  "name" : "latitude",
                  "type" : "double",
                  "value" : "-42.1652"
                },
                {
                  "name" : "longitude",
                  "type" : "double",
                  "value" : "1.93"
                },
                {
                  "name" : "connectedToWifi",
                  "type" : "boolean",
                  "value" : "true"
                },
                {
                  "name" : "wifiLevel",
                  "type" : "int",
                  "value" : "5"
                },
                {
                  "name" : "wifiSpeed",
                  "type" : "int",
                  "value" : "150"
                },
                 {
                  "name" : "timeZone",
                  "type" : "String",
                  "value" : "Madrid"
                },
                 {
                  "name" : "locale",
                  "type" : "String",
                  "value" : "es"
                },
                 {
                  "name" : "networkInfo",
                  "type" : "ApiNetworkInfo",
                  "value" : [ {
                                "name" : "typeName",
                                "type" : "String",
                                "value" : "top"
                                },
                              {
                                "name" : "subtypeName",
                                "type" : "String",
                                "value" : "bla"
                                }
                             ]
                }
              ]
            }
         */

        //TODO gestionar los posibles vacíos y lanzar exception en su caso, por ahora sólo enviamos los no vacíos para poder probar sin NullPointerExceptions
        List<EntityAttribute> attrs = new ArrayList<EntityAttribute>();

        if(null != deviceCheck.getTimeStamp()) {
            attrs.add(EntityAttribute.Builder.anEntityAttribute()
                    .withName("timeStamp")
                    .withType("Date")
                    .withValue(String.valueOf(deviceCheck.getTimeStamp()))
                    .build());
        }
        if(null != deviceCheck.getAppVersion()) {
            attrs.add(EntityAttribute.Builder.anEntityAttribute()
                    .withName("appVersion")
                    .withType("String")
                    .withValue(deviceCheck.getAppVersion())
                    .build());
        }
        if(null != deviceCheck.getTrafficData()) {
            attrs.add(EntityAttribute.Builder.anEntityAttribute()
                    .withName("trafficDataReceived")
                    .withType("long")
                    .withValue(String.valueOf(deviceCheck.getTrafficData().getDataReceived()))
                    .build());
            attrs.add(EntityAttribute.Builder.anEntityAttribute()
                    .withName("trafficDataTransmited")
                    .withType("long")
                    .withValue(String.valueOf(deviceCheck.getTrafficData().getDataTransmited()))
                    .build());
        }
        if(null != deviceCheck.getBatteryStatus()) {
            attrs.add(EntityAttribute.Builder.anEntityAttribute()
                    .withName("batteryStatusMode")
                    .withType("String")
                    .withValue(deviceCheck.getBatteryStatus().getMode())
                    .build());
            attrs.add(EntityAttribute.Builder.anEntityAttribute()
                    .withName("batteryStatusLevel")
                    .withType("int")
                    .withValue(String.valueOf(deviceCheck.getBatteryStatus().getLevel()))
                    .build());
        }
        attrs.add(EntityAttribute.Builder.anEntityAttribute()
                .withName("freeSpace")
                .withType("long")
                .withValue(String.valueOf(deviceCheck.getFreeSpace()))
                .build());
        attrs.add(EntityAttribute.Builder.anEntityAttribute()
                .withName("totalSpace")
                .withType("long")
                .withValue(String.valueOf(deviceCheck.getTotalSpace()))
                .build());
        attrs.add(EntityAttribute.Builder.anEntityAttribute()
                .withName("usedSpace")
                .withType("long")
                .withValue(String.valueOf(deviceCheck.getUsedSpace()))
                .build());
        attrs.add(EntityAttribute.Builder.anEntityAttribute()
                .withName("latitude")
                .withType("double")
                .withValue(String.valueOf(deviceCheck.getLatitude()))
                .build());
        attrs.add(EntityAttribute.Builder.anEntityAttribute()
                .withName("longitude")
                .withType("double")
                .withValue(String.valueOf(deviceCheck.getLongitude()))
                .build());
        attrs.add(EntityAttribute.Builder.anEntityAttribute()
                .withName("connectedToWifi")
                .withType("boolean")
                .withValue(String.valueOf(deviceCheck.isConnectedToWifi()))
                        .build());
        attrs.add(EntityAttribute.Builder.anEntityAttribute()
                .withName("wifiLevel")
                .withType("int")
                .withValue(String.valueOf(deviceCheck.getWifiLevel()))
                        .build());
        attrs.add(EntityAttribute.Builder.anEntityAttribute()
                .withName("wifiSpeed")
                .withType("int")
                .withValue(String.valueOf(deviceCheck.getWifiSpeed()))
                        .build());
        if(null != deviceCheck.getTimeZone()) {
            attrs.add(EntityAttribute.Builder.anEntityAttribute()
                    .withName("timeZone")
                    .withType("String")
                    .withValue(deviceCheck.getTimeZone())
                    .build());
        }
        if(null != deviceCheck.getLocale()) {
            attrs.add(EntityAttribute.Builder.anEntityAttribute()
                    .withName("locale")
                    .withType("String")
                    .withValue(deviceCheck.getLocale())
                    .build());
        }
        if(null != deviceCheck.getNetworkInfo()) {
            attrs.add(EntityAttribute.Builder.anEntityAttribute()
                    .withName("networkTypeName")
                    .withType("String")
                    .withValue(deviceCheck.getNetworkInfo().getTypeName())
                    .build());
            attrs.add(EntityAttribute.Builder.anEntityAttribute()
                    .withName("networkSubtypeName")
                    .withType("String")
                    .withValue(deviceCheck.getNetworkInfo().getSubtypeName())
                    .build());
        }

        Entity entity = Entity.Builder.anEntity().withType(Config.URN_PREFIX + DeviceCheck.class.getSimpleName()).withAttributes(attrs).build();
        Log.e(TAG, "ApiDeviceCheck NGSI Entity created");
        return entity;
    }

}
