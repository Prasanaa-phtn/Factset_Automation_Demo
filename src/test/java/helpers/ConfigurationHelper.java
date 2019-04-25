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
    
    private static JSONObject platformObject = null;
    public static String getPlatform() throws FileNotFoundException, IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("src/test/configuration/Run.Config"));
        JSONObject jsonObject = (JSONObject) obj;
        platformObject = (JSONObject) jsonObject.get("platform");
        String platformName = platformObject.toString();
        System.out.println("Platform name: " + platformName);
        return platformName;
    }
    
    public static String getFeatureFile() {
        String featureFile = (String) platformObject.get("featureFile");
        return featureFile;
    }
    
    public static String getBaseUri() {
        String baseUri = (String) platformObject.get("baseUri");
        return baseUri;
    }
    
}











//private static RunConfig runConfig;
//
// private static RunConfig getRunConfig() {
// if (runConfig == null) {
// try {
// BufferedReader reader = new BufferedReader(new
// FileReader("src/test/resources/testData/Run.config"));
// Gson gson = new Gson();
// runConfig = gson.fromJson(reader, RunConfig.class);
// } catch (FileNotFoundException e) {
// e.printStackTrace();
// throw new RuntimeException("Unable to read Run.config");
// }
// }
//
// return runConfig;
// }