package com.online.shop.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;

import javax.validation.constraints.NotNull;

@Component
@ConfigurationProperties(
        prefix = "shopconfig",
        ignoreUnknownFields = true
)
@PropertySources({@PropertySource(
        value = {"classpath:git.properties"},
        ignoreResourceNotFound = true
), @PropertySource(
        value = {"classpath:META-INF/build-info.properties"},
        ignoreResourceNotFound = true
)})
public class ApplicationCustomProperties {
    private final ApplicationCustomProperties.Async async = new ApplicationCustomProperties.Async();
    private final ApplicationCustomProperties.Http http = new ApplicationCustomProperties.Http();
    private final ApplicationCustomProperties.Mail mail = new ApplicationCustomProperties.Mail();
    private final CorsConfiguration cors = new CorsConfiguration();
    private final ApplicationCustomProperties.Security security = new ApplicationCustomProperties.Security();
    private final ApplicationCustomProperties.Swagger swagger = new ApplicationCustomProperties.Swagger();
    private final ApplicationCustomProperties.Logging logging = new ApplicationCustomProperties.Logging();

    public ApplicationCustomProperties() {
    }

    public ApplicationCustomProperties.Async getAsync() {
        return this.async;
    }

    public ApplicationCustomProperties.Http getHttp() {
        return this.http;
    }


    public ApplicationCustomProperties.Mail getMail() {
        return this.mail;
    }


    public ApplicationCustomProperties.Security getSecurity() {
        return this.security;
    }

    public ApplicationCustomProperties.Swagger getSwagger() {
        return this.swagger;
    }

    public ApplicationCustomProperties.Logging getLogging() {
        return this.logging;
    }

    public CorsConfiguration getCors() {
        return this.cors;
    }




    public static class Logging {
        private boolean useJsonFormat = false;
        private final ApplicationCustomProperties.Logging.Logstash logstash = new ApplicationCustomProperties.Logging.Logstash();

        public Logging() {
        }

        public boolean isUseJsonFormat() {
            return this.useJsonFormat;
        }

        public void setUseJsonFormat(boolean useJsonFormat) {
            this.useJsonFormat = useJsonFormat;
        }

        public ApplicationCustomProperties.Logging.Logstash getLogstash() {
            return this.logstash;
        }

        public static class Logstash {
            private boolean enabled = false;
            private String host = "localhost";
            private int port = 5000;
            private int queueSize = 512;

            public Logstash() {
            }

            public boolean isEnabled() {
                return this.enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public String getHost() {
                return this.host;
            }

            public void setHost(String host) {
                this.host = host;
            }

            public int getPort() {
                return this.port;
            }

            public void setPort(int port) {
                this.port = port;
            }

            public int getQueueSize() {
                return this.queueSize;
            }

            public void setQueueSize(int queueSize) {
                this.queueSize = queueSize;
            }
        }
    }



    public static class Swagger {
        private String title = "Application API";
        private String description = "API documentation";
        private String version = "0.0.1";
        private String termsOfServiceUrl;
        private String contactName;
        private String contactUrl;
        private String contactEmail;
        private String license;
        private String licenseUrl;
        private String defaultIncludePattern;
        private String host;
        private String[] protocols;
        private boolean useDefaultResponseMessages;

        public Swagger() {
            this.termsOfServiceUrl = ApplicationDefaults.Swagger.termsOfServiceUrl;
            this.contactName = ApplicationDefaults.Swagger.contactName;
            this.contactUrl = ApplicationDefaults.Swagger.contactUrl;
            this.contactEmail = ApplicationDefaults.Swagger.contactEmail;
            this.license = ApplicationDefaults.Swagger.license;
            this.licenseUrl = ApplicationDefaults.Swagger.licenseUrl;
            this.defaultIncludePattern = "/api/.*";
            this.host = ApplicationDefaults.Swagger.host;
            this.protocols = ApplicationDefaults.Swagger.protocols;
            this.useDefaultResponseMessages = true;
        }

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return this.description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVersion() {
            return this.version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getTermsOfServiceUrl() {
            return this.termsOfServiceUrl;
        }

        public void setTermsOfServiceUrl(String termsOfServiceUrl) {
            this.termsOfServiceUrl = termsOfServiceUrl;
        }

        public String getContactName() {
            return this.contactName;
        }

        public void setContactName(String contactName) {
            this.contactName = contactName;
        }

        public String getContactUrl() {
            return this.contactUrl;
        }

        public void setContactUrl(String contactUrl) {
            this.contactUrl = contactUrl;
        }

        public String getContactEmail() {
            return this.contactEmail;
        }

        public void setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
        }

        public String getLicense() {
            return this.license;
        }

        public void setLicense(String license) {
            this.license = license;
        }

        public String getLicenseUrl() {
            return this.licenseUrl;
        }

        public void setLicenseUrl(String licenseUrl) {
            this.licenseUrl = licenseUrl;
        }

        public String getDefaultIncludePattern() {
            return this.defaultIncludePattern;
        }

        public void setDefaultIncludePattern(String defaultIncludePattern) {
            this.defaultIncludePattern = defaultIncludePattern;
        }

        public String getHost() {
            return this.host;
        }

        public void setHost(String host) {
            this.host = host;
        }

        public String[] getProtocols() {
            return this.protocols;
        }

        public void setProtocols(String[] protocols) {
            this.protocols = protocols;
        }

        public boolean isUseDefaultResponseMessages() {
            return this.useDefaultResponseMessages;
        }

        public void setUseDefaultResponseMessages(boolean useDefaultResponseMessages) {
            this.useDefaultResponseMessages = useDefaultResponseMessages;
        }
    }

    public static class Security {
        private final ApplicationCustomProperties.Security.ClientAuthorization clientAuthorization = new ApplicationCustomProperties.Security.ClientAuthorization();
        private final ApplicationCustomProperties.Security.Authentication authentication = new ApplicationCustomProperties.Security.Authentication();
        private final ApplicationCustomProperties.Security.RememberMe rememberMe = new ApplicationCustomProperties.Security.RememberMe();

        public Security() {
        }

        public ApplicationCustomProperties.Security.ClientAuthorization getClientAuthorization() {
            return this.clientAuthorization;
        }

        public ApplicationCustomProperties.Security.Authentication getAuthentication() {
            return this.authentication;
        }

        public ApplicationCustomProperties.Security.RememberMe getRememberMe() {
            return this.rememberMe;
        }




        public static class RememberMe {
            @NotNull
            private String key;

            public RememberMe() {
                this.key = ApplicationDefaults.Security.RememberMe.key;
            }

            public String getKey() {
                return this.key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }

        public static class Authentication {
            private final ApplicationCustomProperties.Security.Authentication.Jwt jwt = new ApplicationCustomProperties.Security.Authentication.Jwt();

            public Authentication() {
            }

            public ApplicationCustomProperties.Security.Authentication.Jwt getJwt() {
                return this.jwt;
            }

            public static class Jwt {
                private String secret;
                private String base64Secret;
                private long tokenValidityInSeconds;
                private long tokenValidityInSecondsForRememberMe;

                public Jwt() {
                    this.secret = ApplicationDefaults.Security.Authentication.Jwt.secret;
                    this.base64Secret = ApplicationDefaults.Security.Authentication.Jwt.base64Secret;
                    this.tokenValidityInSeconds = 1800L;
                    this.tokenValidityInSecondsForRememberMe = 2592000L;
                }

                public String getSecret() {
                    return this.secret;
                }

                public void setSecret(String secret) {
                    this.secret = secret;
                }

                public String getBase64Secret() {
                    return this.base64Secret;
                }

                public void setBase64Secret(String base64Secret) {
                    this.base64Secret = base64Secret;
                }

                public long getTokenValidityInSeconds() {
                    return this.tokenValidityInSeconds;
                }

                public void setTokenValidityInSeconds(long tokenValidityInSeconds) {
                    this.tokenValidityInSeconds = tokenValidityInSeconds;
                }

                public long getTokenValidityInSecondsForRememberMe() {
                    return this.tokenValidityInSecondsForRememberMe;
                }

                public void setTokenValidityInSecondsForRememberMe(long tokenValidityInSecondsForRememberMe) {
                    this.tokenValidityInSecondsForRememberMe = tokenValidityInSecondsForRememberMe;
                }
            }
        }

        public static class ClientAuthorization {
            private String accessTokenUri;
            private String tokenServiceId;
            private String clientId;
            private String clientSecret;

            public ClientAuthorization() {
                this.accessTokenUri = ApplicationDefaults.Security.ClientAuthorization.accessTokenUri;
                this.tokenServiceId = ApplicationDefaults.Security.ClientAuthorization.tokenServiceId;
                this.clientId = ApplicationDefaults.Security.ClientAuthorization.clientId;
                this.clientSecret = ApplicationDefaults.Security.ClientAuthorization.clientSecret;
            }

            public String getAccessTokenUri() {
                return this.accessTokenUri;
            }

            public void setAccessTokenUri(String accessTokenUri) {
                this.accessTokenUri = accessTokenUri;
            }

            public String getTokenServiceId() {
                return this.tokenServiceId;
            }

            public void setTokenServiceId(String tokenServiceId) {
                this.tokenServiceId = tokenServiceId;
            }

            public String getClientId() {
                return this.clientId;
            }

            public void setClientId(String clientId) {
                this.clientId = clientId;
            }

            public String getClientSecret() {
                return this.clientSecret;
            }

            public void setClientSecret(String clientSecret) {
                this.clientSecret = clientSecret;
            }
        }
    }

    public static class Mail {
        private boolean enabled = false;
        private String from = "";
        private String baseUrl = "";

        public Mail() {
        }

        public boolean isEnabled() {
            return this.enabled;
        }

        public void setEnabled(boolean enabled) {
            this.enabled = enabled;
        }

        public String getFrom() {
            return this.from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getBaseUrl() {
            return this.baseUrl;
        }

        public void setBaseUrl(String baseUrl) {
            this.baseUrl = baseUrl;
        }
    }

    public static class Http {
        private final io.github.jhipster.config.JHipsterProperties.Http.Cache cache = new io.github.jhipster.config.JHipsterProperties.Http.Cache();

        public Http() {
        }

        public io.github.jhipster.config.JHipsterProperties.Http.Cache getCache() {
            return this.cache;
        }

        public static class Cache {
            private int timeToLiveInDays = 1461;

            public Cache() {
            }

            public int getTimeToLiveInDays() {
                return this.timeToLiveInDays;
            }

            public void setTimeToLiveInDays(int timeToLiveInDays) {
                this.timeToLiveInDays = timeToLiveInDays;
            }
        }
    }

    public static class Async {
        private int corePoolSize = 2;
        private int maxPoolSize = 50;
        private int queueCapacity = 10000;

        public Async() {
        }

        public int getCorePoolSize() {
            return this.corePoolSize;
        }

        public void setCorePoolSize(int corePoolSize) {
            this.corePoolSize = corePoolSize;
        }

        public int getMaxPoolSize() {
            return this.maxPoolSize;
        }

        public void setMaxPoolSize(int maxPoolSize) {
            this.maxPoolSize = maxPoolSize;
        }

        public int getQueueCapacity() {
            return this.queueCapacity;
        }

        public void setQueueCapacity(int queueCapacity) {
            this.queueCapacity = queueCapacity;
        }
    }
}
