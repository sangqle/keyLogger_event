package main;


import com.sun.org.apache.xerces.internal.impl.dv.xs.YearMonthDV;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;

public class currentTime {

    public static String takeTime(){
//        Calendar cal = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//        YearMonthDV sdf1 = new YearMonthDV();
//        System.out.println( sdf.format(cal.getTime()) );
        DateFormat  dateFormat = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");
        Date date = new Date();
        String str = (dateFormat.format(date));
        return str; // trả ra một chuổi thời gian làm tên file.
    }
}