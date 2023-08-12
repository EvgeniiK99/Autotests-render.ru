package config;

import static org.aeonbits.owner.Config.*;

public interface AccountData {
    @Key("email")
    String getEmail();
    @Key("password")
    String getPassword();
}
