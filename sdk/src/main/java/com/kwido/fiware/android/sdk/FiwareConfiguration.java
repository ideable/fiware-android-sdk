package com.kwido.fiware.android.sdk;

import android.content.Context;

/**
 * Created by gonzalo on 15/07/2015.
 */
public final class FiwareConfiguration {

    private final String orionEndpoint;
    private final String orionAuthToken;

    private final String idasEndpoint;
    private final String idasAuthToken;
    private final String idasApiKey;

    private final String cloudlabEndpoint;

    private FiwareConfiguration(Builder builder) {
        this.orionEndpoint = builder.orionEndpoint;
        this.orionAuthToken = builder.orionAuthToken;
        this.idasEndpoint = builder.idasEndpoint;
        this.idasAuthToken = builder.idasAuthToken;
        this.idasApiKey = builder.idasApiKey;
        this.cloudlabEndpoint = builder.cloudlabEndpoint;
    }

    public String getOrionEndpoint() {
        return orionEndpoint;
    }

    public String getOrionAuthToken() {
        return orionAuthToken;
    }

    public String getIdasEndpoint() {
        return idasEndpoint;
    }

    public String getIdasAuthToken() {
        return idasAuthToken;
    }

    public String getIdasApiKey() {
        return idasApiKey;
    }

    public String getCloudlabEndpoint() {
        return cloudlabEndpoint;
    }

    public static class Builder {

        private String orionEndpoint;
        private String orionAuthToken;
        private String idasEndpoint;
        private String idasAuthToken;
        private String idasApiKey;
        private String cloudlabEndpoint;

        public Builder orionEndpoint(String orionEndpoint) {
            this.orionEndpoint = orionEndpoint;
            return this;
        }

        public Builder orionAuthToken(String orionAuthToken) {
            this.orionAuthToken = orionAuthToken;
            return this;
        }

        public Builder idasEndpoint(String idasEndpoint) {
            this.idasEndpoint = idasEndpoint;
            return this;
        }

        public Builder idasAuthToken(String idasAuthToken) {
            this.idasAuthToken = idasAuthToken;
            return this;
        }

        public Builder idasApiKey(String idasApiKey) {
            this.idasApiKey = idasApiKey;
            return this;
        }

        public Builder cloudlabEndpoint(String cloudlabEndpoint) {
            this.cloudlabEndpoint = cloudlabEndpoint;
            return this;
        }

        public FiwareConfiguration build() {
            return new FiwareConfiguration(this);
        }
    }
}
