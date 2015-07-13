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



public class HealthRecord {
	
	public static enum Type {
		STATUS,
		WEIGHT,
		BLOOD_PRESSURE,
		BLOOD_PRESSURE_SIS,
		BLOOD_PRESSURE_DIA,
		HEART_RATE,
		TEMPERATURE,
		GLUCOSE,
		INR,
		CHOLESTEROL,
		BLOOD_OXYGEN;
	}
	
	public static enum Unit {
		KG,
		LB,
		MMHG,
		CELSIUS_DEGREES,
		PPM;
	}

	private Long id;
	private Type type;
	private Unit unit;
	private String value;
	private Long date;
    private Boolean valid;

	public HealthRecord() {
	}

	public HealthRecord(Type type, Unit unit, String value, Long date) {
		super();
		this.type = type;
		this.unit = unit;
		this.value = value;
		this.date = date;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Long getDate() {
		return date;
	}

	public void setDate(Long date) {
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
