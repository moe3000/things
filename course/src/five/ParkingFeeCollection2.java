package five;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ParkingFeeCollection2 {


    private double calculateFee(String startTimeStr, String endTimeStr) throws ParseException {
        //处理时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date startTime = sdf.parse(startTimeStr);
        Date endTime = sdf.parse(endTimeStr);
        Calendar start = Calendar.getInstance();
        start.setTime(startTime);
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        double fee = 0;
        long duration = endTime.getTime() - startTime.getTime(); //ms
        //根据起始时间判断收费区间
        int startHourOfDay = start.get(Calendar.HOUR_OF_DAY);
        if (8 <= startHourOfDay  && startHourOfDay < 20) {
            //15分钟内免费
            if (duration <= 15 * 60 * 1000) {
                return fee;
            }

            //不满一小时 当1小时算
            if (duration <= 60 * 60 * 1000) {
                return 4;
            }

            //超出1小时 每半小时2元
//            if ()
            return fee;
        } else {
            return fee;
        }
    }


    public static void main(String[] args) {


    }

}
