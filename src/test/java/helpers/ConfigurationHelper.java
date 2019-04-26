package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

//import configuration.RunConfig;

public class ConfigurationHelper {

    private static JSONObject platformProperties = null;
    private static String platformStr = null;

    public static String getPlatform() throws FileNotFoundException, IOException, ParseException {
        if (platformStr == null) {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("src/test/configuration/RunConfig.json"));
            JSONObject jsonObject = (JSONObject) obj;
            //JSONObject platformObject = (JSONObject) jsonObject.get("platform");
            platformStr = (String) jsonObject.get("platform"); //platformObject.toString();
            System.out.println("Platform name: " + platformStr);
        }
        return platformStr;
    }

    public static String getFeatureFile() throws FileNotFoundException, IOException, ParseException {
        if (platformStr == null) {
            platformStr = getPlatform();
        }
        if (platformProperties == null) {
            platformProperties = getPlatformProperties();
        }
        String featureFile = (String) platformProperties.get("featureFile");
        return featureFile;
    }

    public static String getBaseUri() throws FileNotFoundException, IOException, ParseException {
        if (platformStr == null) {
            platformStr = getPlatform();
        }
        if (platformProperties == null) {
            platformProperties = getPlatformProperties();
        }
        String baseUri = (String) platformProperties.get("baseUri");
        return baseUri;
    }

    private static JSONObject getPlatformProperties() throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/test/configuration/Config.json"));
        JSONObject jsonObject = (JSONObject) obj;
        JSONObject platformProperties = (JSONObject) jsonObject.get(platformStr);
        return platformProperties;
    }

}