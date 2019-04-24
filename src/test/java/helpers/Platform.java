package helpers;

public enum Platform {

    WEB_PORTAL("webPortal"),
    ADMIN_PORTAL("adminPortal"),
    ANDROID("android"),
    IOS("iOS"),
    KIOSK_UI("kioskUI"),
    KIOSK_PLATFORM("kioskPlatform"),
    API_PLATFORM("api"),
    UNKNOWN("unknown");
    String name;
    Platform(String name) {
        this.name = name;
    }

    public static Platform getPlatform(String name) {
        for (Platform platform : Platform.values()) {
            if (platform.name.equals(name)) {
                return platform;
            }
        }

        return Platform.UNKNOWN;
    }
}
