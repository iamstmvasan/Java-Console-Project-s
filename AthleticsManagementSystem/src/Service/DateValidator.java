package Service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator {
    public boolean validateDate(Date start, Date end){
        if( start.compareTo(end) <= 0)
            return true;
        return false;
    }
}
