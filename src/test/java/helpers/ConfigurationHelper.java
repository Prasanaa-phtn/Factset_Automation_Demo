package helpers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;

import configuration.RunConfig;

public class ConfigurationHelper {
    private static RunConfig runConfig;

     private static RunConfig getRunConfig() {
        if (runConfig == null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/testData/Run.config"));
                Gson gson = new Gson();
                runConfig = gson.fromJson(reader, RunConfig.class);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException("Unable to read Run.config");
            }
        }

        return runConfig;
    }
}