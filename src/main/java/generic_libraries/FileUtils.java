package generic_libraries;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtils {
/**
 * This method is used to read data from property file
 * @author NAGARAJ
 * @param key
 * @return
 * @throws IOException
 */
	
//	public void readDataFromPropertFile(String key) throws IOException
//	{
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonDataProperties1");
//		Properties pObj = new Properties();
//		pObj.load(fis);
//		String value = pObj.getProperty(key);  //key can b anything, whenever u want to call any class, that time we can send key as either url or username or pwd or browser
//		
		public String readDataFromPropertFile(String key) throws IOException
		{
			FileInputStream fis = new FileInputStream(IPathConstants.filepath);
		    Properties pObj = new Properties();
		    pObj.load(fis);
		    String value = pObj.getProperty(key);  //key can b anything, whenever u want to call any class, that time we can send key as either url or username or pwd or browser
		    return value;
		    
		}
	
		
	
	
//	}
	
}
