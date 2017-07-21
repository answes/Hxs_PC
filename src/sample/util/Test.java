package sample.util;


public class Test {

    public static void main(String[] arg){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=9;i<24 ;i++){
            for(int j=0;j<60 ;j++){
                stringBuffer.append("'"+i+":"+j+"',");
            }
        }
        System.out.println(stringBuffer.toString());
    }
}
