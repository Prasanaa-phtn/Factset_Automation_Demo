package helpers;

import modules.*;
import modules.interfaces.HigiPlatform;

import java.util.HashMap;

public class PlatformHelper {

    private static HashMap<Platform, HigiPlatform> platforms = new HashMap<>();

    public static <T extends HigiPlatform> T getPlatformInstance(Platform type) {
        if (!platforms.containsKey(type)) {
            HigiPlatform platform;
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

    public static <T extends HigiPlatform> T getCurrentPlatform() {
        return PlatformHelper.getPlatformInstance(ConfigurationHelper.getPlatform());
    }

}
