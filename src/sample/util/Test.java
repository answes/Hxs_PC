package sample.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Test {

    public static void main(String[] arg){
        /**

        StringBuffer stringBuffer = new StringBuffer();
//        for(int i=9;i<18 ;i++){
//            for(int j=0;j<60 ;j++){
//                stringBuffer.append("'"+i+":"+j+"',");
//            }
//        }
        Random random = new Random();
        for(int j=0;j<5;j++) {
            for (int i = 0; i < 10; i++) {
                int s = random.nextInt(300) % (300 - 100 + 1) + 100;
//                stringBuffer.append(s + ",");
                System.out.println(s);
            }
            for (int i = 0; i < 10; i++) {
                int s = -(random.nextInt(300) % (300 - 100 + 1) + 100);
//                stringBuffer.append(s + ",");
                System.out.println(s);
            }
        }

//        System.out.println(stringBuffer.toString());
         *
         */


        getDate();

    }

    /**
     * 获取某个时间段的毫秒值
     */
    public static void getDate(){

        long old = 1501637400000L;

        long news = 1501662600000L;
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = df.parse("2017-08-02 15:30:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        long timestamp = cal.getTimeInMillis();
//        System.out.println(timestamp);

        StringBuffer stringBuffer = new StringBuffer();
        for(long i =1501637400000L;i<1501662600000L; ){
            i = i+60000;
        }
        Random random = new Random();
        for(int i = 0;i<241;i++){
            int s = random.nextInt(300) % (300 - 100 + 1) + 100;
//                stringBuffer.append(s + ",");
            System.out.println(s);
        }

    }


}
