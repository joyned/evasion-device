package com.venus.evasion.device.reader;

import com.venus.evasion.device.util.StringFormatter;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class ValuesReader {

    public Map<String, Object> readExcel() {
        Map<String, Object> values = new HashMap<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new ClassPathResource("colarobo.xlsx").getFile());
            XSSFSheet worksheet = workbook.getSheetAt(0);
            for (int i = 1; i < worksheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = worksheet.getRow(i);
                values.put(StringFormatter.format(row.getCell(0).getStringCellValue()), getRowValue(row));
            }
        } catch (IOException | InvalidFormatException e) {
            throw new RuntimeException(e);
        }

        return values;
    }

    private Object getRowValue(XSSFRow row) {
        if (row.getCell(1).getCellType() == CellType.STRING) {
            return row.getCell(1).getStringCellValue();
        } else if (row.getCell(1).getCellType() == CellType.NUMERIC) {
            return row.getCell(1).getNumericCellValue();
        }
        return null;
    }


}
