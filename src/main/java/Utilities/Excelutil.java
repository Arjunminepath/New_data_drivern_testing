package Utilities;

import org.apache.poi.ss.formula.eval.TwoOperandNumericOperation;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Excelutil {


    public static Map<String,String> getTestData(String sheetname,int rownum)
    {
        Map<String,String> data= new HashMap<>();

        try
        {
            InputStream is=Excelutil.class.getClassLoader().getResourceAsStream("Testdata/testdata.xlsx");

            Workbook workbook= WorkbookFactory.create(is);
            Sheet sheet=workbook.getSheet(sheetname);

            Row headerrow=sheet.getRow(0);
            Row datarow=sheet.getRow(rownum);

            for(int i=0;i<headerrow.getLastCellNum();i++)
            {
                String key=headerrow.getCell(i).getStringCellValue();
                String value=datarow.getCell(i).getStringCellValue();
                data.put(key,value);
            }
            workbook.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
       return data;

    }
}
