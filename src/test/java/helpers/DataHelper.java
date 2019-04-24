package helpers;

import cucumber.api.Scenario;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.HashMap;

public class DataHelper {

    private static HashMap<String, HashMap<String,String>> data;

    private static HashMap<String, String> globalData;

    private static String currentScenarioKey;


    /**
     * Get data for current feature file being run
     * @return
     */
	public static HashMap<String,String> getCurrentData()
	{

	    if (data == null) {
	        data = new HashMap<>();
            try {
                DataFormatter formatter = new DataFormatter();
                FileInputStream fs = new FileInputStream(ConfigurationHelper.getfeatureDataFile());
                XSSFWorkbook workbook = new XSSFWorkbook(fs);
                int numSheets = workbook.getNumberOfSheets();
                for (int sheetIndex = 1; sheetIndex < numSheets; sheetIndex++) {
                    XSSFSheet sheet = workbook.getSheetAt(sheetIndex);
                    Row headerRow = sheet.getRow(0);
                    int columns = headerRow.getPhysicalNumberOfCells();
                    
                    for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                        Row currentRow = sheet.getRow(i);
                        if (currentRow == null) {
                            break;
                        }
                        HashMap<String, String> currentHash = new HashMap<>();
                        for (int j = 0; j < columns; j++) {
                            String value = formatter.formatCellValue(currentRow.getCell(j));
                            currentHash.put(headerRow.getCell(j).getStringCellValue(), value);

                        }
                        data.put(getScenarioKey(currentHash.get("featureFile"), currentHash.get("scenario")), currentHash);
                    }
                }
                fs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
		
		return data.get(currentScenarioKey);

	}

	public static void setCurrentScenario(Scenario scenario) {
	    String[] parts = scenario.getId().split(";");
	    currentScenarioKey = getScenarioKey(parts[0], parts[1]);
    }

    public static HashMap<String, String> getGlobalData() {
	    if (globalData == null) {
            globalData = new HashMap<>();
        }

        return globalData;
    }

    private static String getScenarioKey(String featureFile, String scenarioName) {
	    return featureFile.toLowerCase().replace(' ', '-') + scenarioName.toLowerCase().replace(' ', '-');
    }

}
