package config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@Sources({
        "classpath:${env}.properties"
})
public interface WebDriverConfig extends Config {

    @Key("baseUrl")
    @DefaultValue("https://render.ru")
    String baseUrl();

    @Key("basePath")
    @DefaultValue("/ru/v1")
    String basePath();

    @Key("browser")
    @DefaultValue("CHROME")
    String browser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();

    @Key("remoteUrl")
    String remoteUrl();

    @Key("remoteVideoUrl")
    String remoteVideoUrl();
}
