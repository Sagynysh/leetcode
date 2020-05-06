import org.apache.commons.lang3.time.FastDateFormat;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Forming by meta4 on 25-05-16.
 */
public class DateUtils {

    private static Date now() {
        return new Date(System.currentTimeMillis());
    }

    private static FastDateFormat packetListFormatter = FastDateFormat.getInstance("'B'yyyyMMddHHmm");
    private static FastDateFormat registryFormatter = FastDateFormat.getInstance("'R'yyyyMMddHHmmss");
    private static FastDateFormat actFormatter = FastDateFormat.getInstance("'A'yyyyMMddHHmmss");
    private static FastDateFormat packetListFormatter2 = FastDateFormat.getInstance("'BG'yyyyMMddHHmmss");
    private static FastDateFormat labelFormatter = FastDateFormat.getInstance("'G'yyyyMMddHHmm");
    private static FastDateFormat transportListFormatter = FastDateFormat.getInstance("'T'yyyyMMddHHmm");
    private static FastDateFormat returnListFormatter = FastDateFormat.getInstance("'V'yyyyMMddHHmmss");

    private static FastDateFormat destinationListFormatter = FastDateFormat.getInstance("'S'yyyyMMddHHmm");

    private static FastDateFormat generalInvoiceFormatter = FastDateFormat.getInstance("'O'yyyyMMddHHmmss");

    private static FastDateFormat localListFormatter = FastDateFormat.getInstance("'LL'yyyyMMddHHmmss");
    private static FastDateFormat clientListFormatter = FastDateFormat.getInstance("'CL'yyyyMMddHHmmss");
    private static FastDateFormat deliveryListFormatter = FastDateFormat.getInstance("'D'yyyyMMddHHmmss");

    private static FastDateFormat friendlyDateFormatter = FastDateFormat.getInstance("dd/MM/yyyy");
    private static FastDateFormat friendlyDateTimeFormatter = FastDateFormat.getInstance("dd/MM/yyyy HH:mm");

    private static DateTimeFormatter friendlyLocalTimeFormatter = DateTimeFormat.forPattern("HH:mm");

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
    private static SimpleDateFormat simpleDateTimeFormat = new SimpleDateFormat("dd.MM.yy HH:mm:ss");


    private static Integer MaxRandomAppender = 1000;

    private static String getRandomString() {
        return String.format("%03d", ThreadLocalRandom.current().nextInt(MaxRandomAppender));
    }

    public static String getPacketListCode() {
        return packetListFormatter.format(now()) + getRandomString();
    }

    public static String getActCode() {
        return actFormatter.format(now()) + getRandomString();
    }

    public static String getRegistryCode() {
        return registryFormatter.format(now()) + getRandomString();
    }

    public static String getPacketListCode2() {
        return packetListFormatter2.format(now()) + getRandomString();
    }
    public static String getLabelCode() {
        return labelFormatter.format(now()) + getRandomString();
    }
    
    public static String getGeneralInvoiceCode() {
    	return generalInvoiceFormatter.format(now()) + getRandomString();
    }

    public static String getTransportListCode() {
        return transportListFormatter.format(now()) + getRandomString();
    }

    public static String getDestinationListCode() {
        return destinationListFormatter.format(now()) + getRandomString();
    }

    public static String getLocalListCode() {
        return localListFormatter.format(now()) + getRandomString();
    }

    public static String getClientListCode() {
        return clientListFormatter.format(now()) + getRandomString();
    }

    public static String getDeliveryListCode() {
        return deliveryListFormatter.format(now()) + getRandomString();
    }

    public static String getReturnListCode() {
        return returnListFormatter.format(now()) + getRandomString();
    }

    public static Date parseDate(String value) throws ParseException {
        if (value == null) return null;
        return simpleDateFormat.parse(value);
    }

    public static Date parseDateTime(String value) {
        if (value == null) return null;
        try {
            return simpleDateTimeFormat.parse(value);
        } catch (Exception e) {
            return null;
        }
    }

    public static Date parseStartDate(String value) {
        if (value == null) return null;

        Calendar instance = Calendar.getInstance();
        try {
            instance.setTime(simpleDateFormat.parse(value));
        } catch (ParseException e) {
            instance.setTime(new Date());
        }

        instance.set(Calendar.HOUR_OF_DAY, 0);
        instance.set(Calendar.MINUTE, 0);
        return instance.getTime();
    }

    public static Date parseEndDate(String value) {
        if (value == null) return null;

        Calendar instance = Calendar.getInstance();
        try {
            instance.setTime(simpleDateFormat.parse(value));
        } catch (ParseException e) {
            instance.setTime(new Date());
        }

        instance.set(Calendar.HOUR_OF_DAY, 23);
        instance.set(Calendar.MINUTE, 59);
        return instance.getTime();
    }

    public static boolean isToday(Date date) {
        return isSameDay(date, Calendar.getInstance().getTime());
    }

    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        return isSameDay(cal1, cal2);
    }

    public static boolean isSameDay(Calendar cal1, Calendar cal2) {
        if (cal1 == null || cal2 == null) {
            throw new IllegalArgumentException("The dates must not be null");
        }
        return (cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) &&
                cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR));
    }

    public static String getCurrentDateAsString() {
        return simpleDateFormat.format(new Date());
    }

}
