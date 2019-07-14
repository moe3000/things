package five;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ParkingFeeCollection2 {


    public static double calculateFee(String startTimeStr, String endTimeStr) throws ParseException {
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
        //一共经过的天整数
        long day = duration / (24 * 60 * 60 * 1000);
        //零头
        long remain = duration % (24 * 60 * 60 * 1000);
        //根据起始时间判断 零头收费区间
//        start.set(Calendar.DATE, start.get(Calendar.DATE + ));
        int startHourOfDay = start.get(Calendar.HOUR_OF_DAY);
        if (8 <= startHourOfDay  && startHourOfDay < 20) {
            //计算离20时跨界时间差
            Calendar eightPM = start;
            eightPM.set(Calendar.HOUR_OF_DAY, 20);
            eightPM.set(Calendar.MINUTE, 0);
            eightPM.set(Calendar.SECOND, 0);
            eightPM.set(Calendar.MILLISECOND, 0);

            long remainEightPm = eightPM.getTime().getTime() - startTime.getTime();

            //15分钟内免费
            if (remain <= 15 * 60 * 1000) {
                fee = 0;
            } else if (remain <= 60 * 60 * 1000) {
                //不满一小时 当1小时算
                if (remain > remainEightPm) {
                    //1小时内跨界
                    fee = 4 + 4;
                } else {
                    //1小时内不夸界
                    fee = 4;
                }
            } else if (remainEightPm > remain) {
                //不会跨界每半小时两元
                fee = (remain - 60 * 60 * 1000) / (30 * 60 * 1000) * 2 + 4;
            } else {
                //距离20点时间段每半小时2元 + 跨界后4元
                fee = (remainEightPm - 60 * 60 * 1000) / (30 * 60 * 1000) * 2 + 4 + 4;
            }
        } else {
            //计算离下一个8时 时间差
            Calendar eightAM = start;
            if (startHourOfDay >= 20) {
                eightAM.set(Calendar.DATE, eightAM.get(Calendar.DATE) + 1);
            }
            eightAM.set(Calendar.HOUR_OF_DAY, 8);
            eightAM.set(Calendar.MINUTE, 0);
            eightAM.set(Calendar.SECOND, 0);
            eightAM.set(Calendar.MILLISECOND, 0);

            long remainEightAm = eightAM.getTime().getTime() - startTime.getTime();
            if (remainEightAm >= remain) {
                //没跨界 4元
                fee = 4;
            } else {
                //跨界重新计时
                remain = remain - remainEightAm;
                if (remain <= 15 * 60 * 1000) {
                    //15分钟内免费
                    fee = 4;
                } else if (remain <= 60 * 60 * 1000) {
                    //1小时内4元
                    fee = 4 + 4;
                } else {
                    //超1小时 每半小时2元
                    fee = (remain - 60 * 60 * 1000) / (30 * 60 * 1000) * 2 + 4 + 4;
                }
            }
        }

        //每日封顶 16元
        if (fee > 16) {
            fee = 16;
        }

        return day * 4 * 4 + fee;
    }


    public static void main(String[] args) throws ParseException {
//        1	2014-10-08 12:02:13	2014-10-08 12:13:56
//        2	2014-10-08 13:12:15	2014-10-08 13:48:42
//        3	2014-10-08 14:52:17	2014-10-08 16:28:22
//        4	2014-10-08 15:12:15	2014-10-08 20:38:49
//        5	2014-10-08 16:12:15	2014-10-09 07:29:52
//        6	2014-10-08 20:12:15	2014-10-09 07:45:26
//        7	2014-10-08 16:12:15	2014-10-09 13:49:53
//        8	2014-10-08 17:12:15	2014-10-11 15:12:12

        System.out.println("1:" + ParkingFeeCollection2.calculateFee("2014-10-08 12:02:13", "2014-10-08 12:13:56"));
        System.out.println("2:" + ParkingFeeCollection2.calculateFee("2014-10-08 13:12:15", "2014-10-08 13:48:42"));
        System.out.println("3:" + ParkingFeeCollection2.calculateFee("2014-10-08 14:52:17", "2014-10-08 16:28:22"));
        System.out.println("4:" + ParkingFeeCollection2.calculateFee("2014-10-08 15:12:15", "2014-10-08 20:38:49"));
        System.out.println("5:" + ParkingFeeCollection2.calculateFee("2014-10-08 16:12:15", "2014-10-09 07:29:52"));
        System.out.println("6:" + ParkingFeeCollection2.calculateFee("2014-10-08 20:12:15", "2014-10-09 07:45:26"));
        System.out.println("7:" + ParkingFeeCollection2.calculateFee("2014-10-08 16:12:15", "2014-10-09 13:49:53"));
        System.out.println("8:" + ParkingFeeCollection2.calculateFee("2014-10-08 17:12:15", "2014-10-11 15:12:12"));

    }

}
