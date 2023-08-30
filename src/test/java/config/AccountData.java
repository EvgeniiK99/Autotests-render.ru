package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:data.properties"})
public interface AccountData extends Config {
    @Key("email")
    String getEmail();
    @Key("password")
    String getPassword();
    @Key("userId")
    int getUserId();
}
