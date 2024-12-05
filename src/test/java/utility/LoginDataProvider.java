package utility;

import org.testng.annotations.DataProvider;
import java.util.List;

public class LoginDataProvider {

    @DataProvider(name = "loginData")
    public Object[][] provideLoginData() {
        String filePath = "C:\\Users\\skd12\\Downloads\\Test_data.xlsx";
        String sheetName = "Sheet1";
        List<String[]> data = ExcelUtil.readExcelData(filePath, sheetName);
        
        // Convert List<String[]> to Object[][]
        Object[][] dataArray = new Object[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i] = data.get(i);
        }
        return dataArray;
    }
}
