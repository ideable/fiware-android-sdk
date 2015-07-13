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

public class NetworkInfo {

	private String typeName;
	
	private String subtypeName;

	public NetworkInfo() {
		super();
	}
	
	public NetworkInfo(String typeName, String subtypeName) {
		this.typeName = typeName;
		this.subtypeName = subtypeName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getSubtypeName() {
		return subtypeName;
	}

	public void setSubtypeName(String subtypeName) {
		this.subtypeName = subtypeName;
	}
	
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(typeName);
		if ( subtypeName!=null && !"".equals(subtypeName) ) {
			stringBuilder.append(" [");
			stringBuilder.append(subtypeName);
			stringBuilder.append("]");
		}
		return stringBuilder.toString();
	}
	
}
