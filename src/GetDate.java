import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;

public class GetDate {
	static Calendar cal=new GregorianCalendar();
	
	

	public static String getDate() {
		int day=cal.get(Calendar.DAY_OF_MONTH);
		 int month=cal.get(Calendar.MONTH);
		 month++;
		 int year=cal.get(Calendar.YEAR);
		 String mon="";
		 
		 if(month==2)
			 mon="JAN";
		 else if(month==2)
			 mon="FEB";
		 else if(month==3)
			 mon="MAR";
		 else if(month==4)
			 mon="APR";
		 else if(month==5)
			 mon="MAY";
		 else if(month==6)
			 mon="JUN";
		 else if(month==7)
			 mon="JUL";
		 else if(month==8)
			 mon="AUG";
		 else if(month==9)
			 mon="SEP";
		 else if(month==10)
			 mon="OCT";
		 else if(month==11)
			 mon="NOV";
		 else if(month==12)
			 mon="DEC";

		String temp=(day+"-"+mon+"-"+year);
		return temp;
	}
}
