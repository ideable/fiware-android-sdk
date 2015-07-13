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

package com.kwido.fiware.android.app;

import android.app.Activity;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.*;
import com.kwido.fiware.android.app.model.DeviceCheck;
import com.kwido.fiware.android.app.model.HealthRecord;
import com.kwido.fiware.android.app.model.EntityType;
import com.kwido.fiware.android.app.utils.Config;
import com.kwido.fiware.android.app.utils.MockData;
import com.kwido.fiware.android.app.utils.NGSIAdapter;
import com.kwido.fiware.android.app.utils.ObjectCreator;
import com.kwido.fiware.android.sdk.FiwareFacade;
import com.kwido.fiware.android.sdk.model.Entity;
import com.kwido.fiware.android.sdk.model.EntityCreateResponse;
import com.kwido.fiware.android.sdk.model.EntityUpdateResponse;
import com.kwido.fiware.android.sdk.model.RegisterDeviceRequest;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    private static final String TAG = "MainActivity";
    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    private FiwareFacade fiwareFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        fiwareFacade = FiwareFacade.getInstance(Config.BASE_URL_ORION,
                Config.BASE_URL_IDAS,
                Config.BASE_URL_CLOUDLAB,
                "change_me_token");

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();

        String entityId = null;
        String deviceId = null;
        Log.d(TAG, "position " + position);

        String androidId = Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID);
        Log.d(TAG, "androidId " + androidId);

        //Create or Update DeviceCheck Entity
        if (position == 1) {
         /*  ApiDeviceCheck apiDeviceCheck = MockData.getApiDeviceCheck();
            Entity entity = NGSIAdapter.getNGSIEntity(apiDeviceCheck);
            entityId = ObjectsCreator.getEntityId("88001005S", "my", Constants.ENTITY_TYPES.DEVICE_CHECK);
            getFiwareFacade().getOrionClient().createOrUpdateEntity(entityId, entity, new Callback<EntityCreateResponse>() {
                @Override
                public void success(EntityCreateResponse entityCreateResponse, Response response) {
                    Log.d(TAG, "success " + entityCreateResponse);
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d(TAG, "failure " + error);
                }
            });*/

            entityId = ObjectCreator.createEntityId("88001005S", "ideable", androidId, EntityType.HEALTH_RECORD);
            deviceId = ObjectCreator.createDeviceId("88001005S", androidId, EntityType.HEALTH_RECORD);

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

            String measurements = "usedSpace|8854#freeSpace|19500";
            getFiwareFacade().getIdasClient().sendObservations(Config.FIWARE_IDAS_APIKEY,
                    deviceId,
                    measurements, new Callback<Void>() {

                        @Override
                        public void success(Void aVoid, Response response) {
                            Log.d(TAG, "sendObservations success " + response);
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            Log.d(TAG, "sendObservations failure " + error);
                        }
                    });

            getFiwareFacade().getIdasClient().deleteDevice(deviceId, new Callback<Void>() {
                @Override
                public void success(Void aVoid, Response response) {
                    Log.d(TAG, "deleteDevice success " + response);
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d(TAG, "deleteDevice failure " + error);
                }
            });
        }
        //Update DeviceCheck Entity
        else if (position == 2) {
            DeviceCheck deviceCheck = MockData.getApiDeviceCheck();
            Entity entity = NGSIAdapter.getNGSIEntity(deviceCheck);
            entityId = ObjectCreator.createEntityId("88001005S", "my", androidId, EntityType.DEVICE_CHECK);

            getFiwareFacade().getOrionClient().createOrUpdateEntity(entityId, entity, new Callback<EntityCreateResponse>() {
                @Override
                public void success(EntityCreateResponse entityCreateResponse, Response response) {
                    Log.d(TAG, "updateEntity success " + entityCreateResponse);
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d(TAG, "updateEntity error " + error);
                }
            });
        }
        //Create or Update HealthRecord Entity
        else if (position == 7) {
            HealthRecord healthRecord = MockData.getApiHealthRecord();
            Entity entity = NGSIAdapter.getNGSIEntity(healthRecord);
            entityId = ObjectCreator.createEntityId("88001005S", "my", androidId, EntityType.HEALTH_RECORD);
            getFiwareFacade().getOrionClient().createOrUpdateEntity(entityId, entity, new Callback<EntityCreateResponse>() {
                @Override
                public void success(EntityCreateResponse entityCreateResponse, Response response) {
                    Log.d(TAG, "createOrUpdateEntity success " + entityCreateResponse);
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d(TAG, "createOrUpdateEntity failure " + error);
                }
            });
        }
        //Update HealthRecord Entity
        else if (position == 8) {
            HealthRecord healthRecord = MockData.getApiHealthRecord();
            Entity entity = NGSIAdapter.getNGSIEntity(healthRecord);
            entityId = ObjectCreator.createEntityId("88001005S", "my", androidId, EntityType.HEALTH_RECORD);
            getFiwareFacade().getOrionClient().updateEntity(entityId, entity, new Callback<EntityUpdateResponse>() {
                @Override
                public void success(EntityUpdateResponse entityUpdateResponse, Response response) {
                    Log.d(TAG, "updateEntity success " + entityUpdateResponse);
                }

                @Override
                public void failure(RetrofitError error) {
                    Log.d(TAG, "updateEntity error " + error);
                }
            });
        }
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
            case 4:
                mTitle = getString(R.string.title_section4);
                break;
            case 5:
                mTitle = getString(R.string.title_section5);
                break;
            case 6:
                mTitle = getString(R.string.title_section6);
                break;
            case 7:
                mTitle = getString(R.string.title_section7);
                break;
            case 8:
                mTitle = getString(R.string.title_section8);
                break;
            case 9:
                mTitle = getString(R.string.title_section9);
                break;
            case 10:
                mTitle = getString(R.string.title_section10);
                break;
            case 11:
                mTitle = getString(R.string.title_section11);
                break;
            case 12:
                mTitle = getString(R.string.title_section12);
                break;
            case 13:
                mTitle = getString(R.string.title_section13);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public FiwareFacade getFiwareFacade() {
        return fiwareFacade;
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MainActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
