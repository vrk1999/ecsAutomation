import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtility {
    public static List<String[]> getAllLoginData(String filePath) throws Exception {
        FileInputStream file = new FileInputStream(new File(filePath));
        Workbook workbook = WorkbookFactory.create(file);
        Sheet sheet = workbook.getSheetAt(0);
        List<String[]> dataList = new ArrayList<>();

        for (Row row : sheet) {
            String[] data = new String[2];
            data[0] = row.getCell(0).getStringCellValue();
            data[1] = row.getCell(1).getStringCellValue();
            dataList.add(data);
        }

        workbook.close();
        file.close();
        return dataList;
    }
}
