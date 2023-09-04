package common.dateUtils;

import java.sql.Timestamp;
import java.util.Calendar;

public class DateUtil {
	public static Timestamp addDays(Timestamp date, int days, int hours, int minutes, int seconds) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        cal.add(Calendar.HOUR, hours);
        cal.add(Calendar.MINUTE, minutes);
        cal.add(Calendar.SECOND, seconds);
        return new Timestamp(cal.getTime().getTime());
}
	
	public static Timestamp addMilli(Timestamp d1, long diff) 
	{
		Calendar timeout = Calendar.getInstance();
        timeout.setTimeInMillis(d1.getTime() + diff);        
        Timestamp tsNew = new Timestamp(timeout.getTime().getTime());
        return tsNew;

}
}
