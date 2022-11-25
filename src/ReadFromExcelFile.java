import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadFromExcelFile
{


public void GetRowByRowIndex(int rowIndex,XSSFSheet sheet)
{
    Row row = sheet.getRow(rowIndex);
        for (int i = 0; i < row.getLastCellNum()+1; i++) {
            if(row.getCell(i).getCellType() == CellType.NUMERIC)
                    Print("Numeric ", Double.toString(row.getCell(i).getNumericCellValue()));

            else if(row.getCell(i).getCellType() == CellType.STRING)
                    Print("String",row.getCell(i).getStringCellValue());
            else if(row.getCell(i).getCellType() == CellType.FORMULA)
                    Print("Formula " ,row.getCell(i).getStringCellValue());
        }
}
public void GetEntireSheetBySheet(XSSFSheet sheet)
{
    for (int n = 0; n < sheet.getLastRowNum()+1; n++) {
                Row row1 = sheet.getRow(n);
                String rowString = " ";
                for (int i = 0; i < row1.getPhysicalNumberOfCells(); i++) {
                    if(row1.getCell(i).getCellType() == CellType.NUMERIC)
                        rowString+="|"+Double.toString(row1.getCell(i, Row.MissingCellPolicy.RETURN_NULL_AND_BLANK).getNumericCellValue())+"|";

                    else if(row1.getCell(i).getCellType() == CellType.STRING)
                        rowString+="|"+row1.getCell(i, Row.MissingCellPolicy.RETURN_NULL_AND_BLANK).getStringCellValue()+"|";

                    else if(row1.getCell(i).getCellType() == CellType.FORMULA)
                        rowString+="|"+row1.getCell(i, Row.MissingCellPolicy.RETURN_NULL_AND_BLANK).getStringCellValue()+"|";
                    else if(row1.getCell(i).getCellType()==CellType.BLANK)
                        rowString+="|!_!Unavailable!_!|";
                    else if (row1.getPhysicalNumberOfCells() !=0) System.out.println("NULLL ROW");
                }
                System.out.println(rowString);
            }
}



 static void Print(String whatAmI, String Value)
 {
     System.out.println("whatAmI: "+whatAmI +" |"+ " Value: " + Value+"\n" );
 }

    public static void main(String[] args)
    {
       // CellReference cr = new CellReference();
        try
        {
            FileInputStream file = new FileInputStream(new File("src/tablica.xlsx"));

            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            ReadFromExcelFile readFromExcelFile = new ReadFromExcelFile();
            readFromExcelFile.GetRowByRowIndex(5,sheet);
            readFromExcelFile.GetEntireSheetBySheet(sheet);
        }catch (Exception exception)
        {

        }

    }
}

