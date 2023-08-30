package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@Sources({
        "classpath:${env}.properties"
})
public interface WebDriverConfig extends Config {
    @Key("baseUrl")
    @DefaultValue("https://render.ru/ru")
    String getBaseUrl();

    @Key("basePath")
    @DefaultValue("/v1/user")
    String getBasePath();

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean getIsRemote();

    @Key("remoteUrl")
    String getRemoteUrl();
}
