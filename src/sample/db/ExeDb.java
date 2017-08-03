package sample.db;

/**
 *
 */
public class ExeDb {
    private String dbName;
    private String db;
    private static  ExeDb exeDb;

    private ExeDb(){

    }

    public ExeDb getDb(){
        if(exeDb== null){
            exeDb = new ExeDb();
        }
        return  exeDb;
    }


}
