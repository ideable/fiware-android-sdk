Fiware Android SDK
===================

This open source library allows you to integrate **Fiware Orion Context Broker** and **IDAS** enablers into your Android app. Furthermore you will be able to get a valid token from **Keystone Proxy** for authentication purposes.

A facade (*FiwareFacade*) is provided to encapsulate included clients usage: all of them access service's operations asynchronously. 
* **IDAS** client implements Ultralight 2.0/HTTP protocol and it is prepared to interact with an UL2.0 IoT Agent deployed on IDAS global instance. 
* **Orion** client is OMA Rest API compliant and allows you to bring context awareness to your project by keeping entities' information up-to-date at Orion global instance.
* **Keystone Proxy** client allows you to get a valid token.


> **Note:**
> - Orion and IDAS global instances are used in this library but dedicated instances are recommended for production environments.


Quick start
-------------

Download this repo and run it on an Android device.

Usage
-------------

First of all, FiwareFacade must be instanced as follows:

```javascript
FiwareFacade fiwareFacade = FiwareFacade.getInstance(Config.BASE_URL_ORION,
                Config.BASE_URL_IDAS,
                Config.BASE_URL_CLOUDLAB,
                "change_me_token");
```

Afterwards, you could perform several actions regarding Orion and IDAS enablers. For example, you could register a new device:

```java
			//Firstly, we must build a RegisterDeviceRequest object.
            RegisterDeviceRequest registerDeviceRequest = ObjectCreator.createRegisterDeviceRequest(deviceId,
                    entityId,
                    EntityType.HEALTH_RECORD);

            getFiwareFacade().getIdasClient().registerDevice(registerDeviceRequest, new Callback<Void>() {
                @Override
                public void success(Void aVoid, Response response) {
                    Log.d(TAG, "registerDevice success " + response);
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d(TAG, "registerDevice success " + error);
                }
            });

```

Try it out
-------------

A basic Android activity is provided in *app* module as a playground showing how to perform actions such as entity creation, device registering, sending observations, etc. 

