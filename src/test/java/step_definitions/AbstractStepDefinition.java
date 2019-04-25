package step_definitions;

import java.util.HashMap;
import helpers.Platform;
import helpers.PlatformHelper;
import helpers.DataHelper;

public adssa abstract class AbstractStepDefinitions {

    private HashMap<String, String> data;

    private HashMap<String, String> globalData;

    protected Platform platform;

    public AbstractStepDefinitions() {

        data = DataHelper.getCurrentData();

        globalData = DataHelper.getGlobalData();

        platform = PlatformHelper.getCurrentPlatform();

    }
}