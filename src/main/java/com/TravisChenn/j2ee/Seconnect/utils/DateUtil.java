package com.TravisChenn.j2ee.Seconnect.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {


    /**时间粒度*/
    public enum TimeGranularity {

        /**天*/
        DAY,

        /**小时*/
        HOUR,

        /**分钟*/
        MINUTE,

        /**秒*/
        SECOND

    }

    /**
     * 根据时间粒度计算时间差
     *
     * @param timeGranularity 时间粒度
     * @param beginTime       开始时间
     * @param endTime         结束时间
     * @return 根据时间粒度计算的时间差
     */
    public static long getTimeDifference(TimeGranularity timeGranularity, Long beginTime, Long endTime) {

        long timeDifferenceResult = 0;

        if (beginTime != null && endTime != null) {

            //时间差 [单位: 毫秒]
            long timeDifference = endTime - beginTime;

            if(timeGranularity == TimeGranularity.DAY){
                timeDifferenceResult =  timeDifference/(24 * 60 * 60 * 1000);
            }else if(timeGranularity == TimeGranularity.HOUR){
                timeDifferenceResult =   timeDifference/(60 * 60 * 1000);
            }else if(timeGranularity == TimeGranularity.MINUTE){
                timeDifferenceResult =   timeDifference/(60 * 1000);
            }else if(timeGranularity == TimeGranularity.SECOND){
                timeDifferenceResult =   timeDifference/(1000);
            }else{
                timeDifferenceResult =   0;
            }
        }

        return timeDifferenceResult;
    }

    /**
     * 获取当前时间字符串
     * @return 当前时间字符串
     */
    public static String getTimeNow(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    /**
     * 获取过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String result = format.format(today);
        return result;
    }


}
