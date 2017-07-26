package sample.util;


import java.util.Random;

public class Test {

    public static void main(String[] arg){
        StringBuffer stringBuffer = new StringBuffer();
//        for(int i=9;i<18 ;i++){
//            for(int j=0;j<60 ;j++){
//                stringBuffer.append("'"+i+":"+j+"',");
//            }
//        }
        Random random = new Random();
        for(int i = 0;i<200;i++){
            int s = random.nextInt(300)%(300-100+1) + 100;
            stringBuffer.append(s+",");
        }

        System.out.println(stringBuffer.toString());
    }
}
