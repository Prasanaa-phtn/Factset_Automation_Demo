package stepDefinitions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.parser.ParseException;

import helpers.PlatformHelper;
import platforms.FactsetPlatform;
import helpers.DataHelper;

public abstract class AbstractStepDefinition {

    private HashMap<String, String> data;

    private HashMap<String, String> globalData;

    protected FactsetPlatform platform;

    public AbstractStepDefinition() throws FileNotFoundException, IOException, ParseException {

        data = DataHelper.getCurrentData();

        globalData = DataHelper.getGlobalData();

        platform = PlatformHelper.getCurrentPlatform();

    }
}