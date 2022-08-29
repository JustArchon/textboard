package config;

public class ApplicationConfig {

    public static String[] anonymousUriList = {
            "members/join",
            "members/login"
    };

    public static String[] hasAuthUriList = {
        "members/logout",
        "members/signout",
        "members/modify"
    };
}
