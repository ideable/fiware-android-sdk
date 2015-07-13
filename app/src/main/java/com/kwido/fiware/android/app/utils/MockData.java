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

import com.kwido.fiware.android.app.model.*;

import java.util.Date;
import java.util.Random;

/**
 * Created by arkaitz on 18/06/2015.
 */
public class MockData {

    public static DeviceCheck getApiDeviceCheck() {
        Random random = new Random();
        DeviceCheck deviceCheck = new DeviceCheck();
        deviceCheck.setAppVersion("1.2.5");
        BatteryStatus batteryStatus = new BatteryStatus();
        batteryStatus.setLevel(random.nextInt());
        batteryStatus.setMode("Plane");
        NetworkInfo networkInfo = new NetworkInfo();
        networkInfo.setSubtypeName("subtype");
        networkInfo.setTypeName("type");
        TrafficData apiTrafficData = new TrafficData();
        apiTrafficData.setDataReceived(random.nextLong());
        apiTrafficData.setDataTransmited(random.nextLong());
        deviceCheck.setBatteryStatus(batteryStatus);
        deviceCheck.setConnectedToWifi(true);
        deviceCheck.setDeviceId("12:45:56:56:85:12");
        deviceCheck.setLatitude(random.nextDouble());
        deviceCheck.setLongitude(random.nextDouble());
        deviceCheck.setLocale("es");
        deviceCheck.setTimeStamp(new Date());
        deviceCheck.setTimeZone("Madrid");
        deviceCheck.setTotalSpace(random.nextLong());
        deviceCheck.setUsedSpace(random.nextLong());
        deviceCheck.setFreeSpace(random.nextLong());
        deviceCheck.setNetworkInfo(networkInfo);
        deviceCheck.setTrafficData(apiTrafficData);
        deviceCheck.setWifiLevel(random.nextInt());
        deviceCheck.setWifiSpeed(random.nextInt());
        return deviceCheck;
    }

    public static HealthRecord getApiHealthRecord() {
        Random random = new Random();
        HealthRecord healthRecord = new HealthRecord();
        healthRecord.setId(random.nextLong());
        healthRecord.setValid(true);
        healthRecord.setValue(String.valueOf(random.nextInt()));
        healthRecord.setType(HealthRecord.Type.WEIGHT);
        healthRecord.setUnit(HealthRecord.Unit.KG);
        healthRecord.setDate(System.currentTimeMillis());
        return healthRecord;
    }

}
