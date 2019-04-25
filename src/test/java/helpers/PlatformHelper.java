package helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.ParseException;

import platforms.FactsetPlatform;
import platforms.WebPortal;

public class PlatformHelper {

    public static FactsetPlatform getPlatformInstance(String type) {
        
        FactsetPlatform platform;
            switch (type) {
            case "webPortal_Dev":
                platform = new WebPortal();
                break;
            default:
                throw new RuntimeException("Invalid platform");
            }
            return platform;
    }

    public static FactsetPlatform getCurrentPlatform() throws FileNotFoundException, IOException, ParseException {
        return PlatformHelper.getPlatformInstance(ConfigurationHelper.getPlatform());
    }

}
