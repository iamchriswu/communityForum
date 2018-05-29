package wt.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateModel {
    public static String curTime () {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(date);
    }

    public static long curNumTime () {
        Date date = new Date();
        return date.getTime();
    }
}
