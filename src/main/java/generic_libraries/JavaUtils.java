package generic_libraries;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

public class JavaUtils {
/**
 * This method is used to get random int value
 * @return
 */
	public int getRandom()
	{
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random;
	}
	/**This method is used to get the systemdate
	 * 
	 * @return
	 */
	public String systemdate()
	//only to get date
	{
		
	LocalDate date = LocalDate.now();  //cpature current date
		
		DateTimeFormatter d = DateTimeFormatter.ofPattern("yyyy-MM-dd");  //write in which format you want to get date
		//DateTimeFormatter d = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		String systemDate = d.format(date);  //use the format method, invoke todays dtae
		return systemDate;
		
	} 
	/**This method is used to get the systemdate with timings
	 * 
	 * @return
	 */
	//date with time-(hrs, mins,sec)
	public String sysDate()
	{
		Date date = new Date();
		
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
		 
		 String systemDateInFormat = sim.format(date);
		 return systemDateInFormat;
	}
	
	/**this method is used to get the future date and month
	 * 
	 * @param futureMon
	 * @return
	 */
	//future date and month
	public String futureDateInterestOfMonths(long futureMon)
	{
		LocalDate date = LocalDate.now(); 
		LocalDate future = date.plusMonths(futureMon);
		//LocalDate future = date.plusDays(futureMon);
		//LocalDate future = date.plusYears(futureMon)
		DateTimeFormatter d = DateTimeFormatter.ofPattern("'dd-MM-yyyy");
	String futureMonth = d.format(future);
	return futureMonth;
		
	}
	



}
