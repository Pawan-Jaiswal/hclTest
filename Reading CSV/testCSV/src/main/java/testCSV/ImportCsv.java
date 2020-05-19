//program to store csv file into database

package testCSV;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class ImportCsv {
	
	 private static void readCsv()
	    {
		 	String filePath = "C:\\Users\\c5292542\\Documents\\Java\\upload.csv";

	        //CSVReader reader = null;
	 
	        try (CSVReader reader = new CSVReader(new FileReader(filePath)); 
	                     Connection connection = Util.getConnection();)
	        {
	                String insertQuery = "Insert into CSVFILE VALUES(\"Result Time\",\"Granularity Period\", \"Object Name\", \"Cell ID\",\"Call Attempts\") values (null,?,?,?,?)";
	                PreparedStatement pstmt = connection.prepareStatement(insertQuery);
	                String[] rowData = null;
	                int i = 0;
	                while((rowData = reader.readNext()) != null)
	                {
	                    for (String data : rowData)
	                    {
	                            pstmt.setString((i % 3) + 1, data);
	 
	                            if (++i % 3 == 0)
	                                    pstmt.addBatch();// add batch
	 
	                            if (i % 30 == 0)// insert when the batch size is 10
	                                    pstmt.executeBatch();
	                    }
	                }
	                System.out.println("Data Successfully Uploaded");
	        }
	        catch (Exception e)
	        {
	                e.printStackTrace();
	        }
	 
	    }
	 
	    private static void readCsvUsingLoad()
	    {
	        try (Connection connection = Util.getConnection())
	        {
	 
	                String loadQuery = "LOAD DATA LOCAL INFILE '" + "filePath" + "' INTO TABLE CSVFILE FIELDS TERMINATED BY ','" + " LINES TERMINATED BY '\n' (\"Granularity Period\",\"Object Name\", \"Cell ID\",\"Call Attempts\") ";
	                System.out.println(loadQuery);
	                Statement stmt = connection.createStatement();
	                stmt.execute(loadQuery);
	        }
	        catch (Exception e)
	        {
	                e.printStackTrace();
	        }
	    }

    public static void main(String[] args) throws CsvValidationException {

    	  readCsv();
          readCsvUsingLoad();


    }

}