package ir.cactus.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.util.ResourceBundle;

public class BankAccountConnectionPool {
    private BankAccountConnectionPool(){

    }

    private static String DATABASE_URL=null;

    private static String USER=null;

    private static String PASS=null;

    private static String DATABASE_DRIVER="com.mysql.cj.jdbc.Driver";


    private static DataSource dataSource;


    public static DataSource getDataSource(){
        if (dataSource==null){
            HikariConfig config=new HikariConfig();
            ResourceBundle  resourceBundle=ResourceBundle.getBundle("DB");
            DATABASE_URL=resourceBundle.getString("DATABASE_URL");
            USER=resourceBundle.getString("USER");
            PASS=resourceBundle.getString("PASS");
            config.setJdbcUrl(DATABASE_URL);
            config.setUsername(USER);
            config.setPassword(PASS);

            config.setMaximumPoolSize(20);
            config.setAutoCommit(true);
            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
            dataSource=new HikariDataSource(config);




        }

        return dataSource;
    }




}
