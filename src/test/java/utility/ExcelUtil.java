package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

    public static List<String[]> readExcelData(String filePath, String sheetName) {
        List<String[]> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            DataFormatter formatter = new DataFormatter();

            for (Row row : sheet) {
                String[] rowData = new String[row.getLastCellNum()];
                for (int cn = 0; cn < row.getLastCellNum(); cn++) {
                    rowData[cn] = formatter.formatCellValue(row.getCell(cn));
                }
                data.add(rowData);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}

