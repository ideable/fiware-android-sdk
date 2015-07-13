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
package com.kwido.fiware.android.app.model;


import java.util.Date;

public class DeviceCheck {

    private Date timeStamp;
	private String deviceId;
	private String appVersion;

	private TrafficData trafficData;
	private BatteryStatus batteryStatus;
	private long freeSpace;
	private long totalSpace;
	private long usedSpace;

	private double latitude;
	private double longitude;

	private boolean connectedToWifi;
	private int wifiLevel;
	private int wifiSpeed;

    private String timeZone;
    private String locale;
	
	private NetworkInfo networkInfo;

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public TrafficData getTrafficData() {
		return trafficData;
	}

	public void setTrafficData(TrafficData trafficData) {
		this.trafficData = trafficData;
	}

	public BatteryStatus getBatteryStatus() {
		return batteryStatus;
	}

	public void setBatteryStatus(BatteryStatus batteryStatus) {
		this.batteryStatus = batteryStatus;
	}

	public long getFreeSpace() {
		return freeSpace;
	}

	public void setFreeSpace(long freeSpace) {
		this.freeSpace = freeSpace;
	}

	public long getTotalSpace() {
		return totalSpace;
	}

	public void setTotalSpace(long totalSpace) {
		this.totalSpace = totalSpace;
	}

	public long getUsedSpace() {
		return usedSpace;
	}

	public void setUsedSpace(long usedSpace) {
		this.usedSpace = usedSpace;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public boolean isConnectedToWifi() {
		return connectedToWifi;
	}

	public void setConnectedToWifi(boolean connectedToWifi) {
		this.connectedToWifi = connectedToWifi;
	}

	public int getWifiLevel() {
		return wifiLevel;
	}

	public void setWifiLevel(int wifiLevel) {
		this.wifiLevel = wifiLevel;
	}

	public int getWifiSpeed() {
		return wifiSpeed;
	}

	public void setWifiSpeed(int wifiSpeed) {
		this.wifiSpeed = wifiSpeed;
	}

	public void setNetworkInfo(NetworkInfo networkInfo) {
		this.networkInfo = networkInfo;
	}
	
	public NetworkInfo getNetworkInfo() {
		return networkInfo;
	}

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }
}
