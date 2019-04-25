package helpers;

import java.util.HashMap;

public class PlatformHelper {

    private static HashMap<Platform, HigiPlatform> platforms = new HashMap<>();

    public static <T extends Platform> T getPlatformInstance(Platform type) {
        if (!platforms.containsKey(type)) {
            Platform platform;
            switch (type) {
            case WEB_PORTAL:
                platform = new WebPortalPlatform();
                break;
            default:
                throw new RuntimeException("Invalid platform");
            }

            platforms.put(type, platform);
        }

        return (T) platforms.get(type);
    }

    public static <T extends Platform> T getCurrentPlatform() {
        return PlatformHelper.getPlatformInstance(ConfigurationHelper.getPlatform());
    }

}
