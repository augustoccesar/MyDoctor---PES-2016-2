package database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by augustoccesar on 10/6/16.
 */
public class DatabaseManager {
    private static DatabaseManager self;
    private Connection connection;

    private DatabaseManager(){
        try {
            Options options = new Options("localhost", 3306, "mydoctor", "root", "");
            String connectionUrl = "jdbc:mysql://" + options.dbHost + ":" + options.dbPort + "/" + options.database;

            HikariConfig config = new HikariConfig();
            config.setJdbcUrl(connectionUrl);
            config.setUsername(options.dbUsername);
            config.setPassword(options.dbPassword);

            config.addDataSourceProperty("cachePrepStmts", "true");
            config.addDataSourceProperty("prepStmtCacheSize", "250");
            config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

            HikariDataSource ds = new HikariDataSource(config);
            this.connection = ds.getConnection();

            self = this;
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void initialize(){
        if(self == null){
            self = new DatabaseManager();
        }
    }

    public static Connection getConnection(){
        if(self == null){
            self = new DatabaseManager();
        }
        return self.connection;
    }

    public class Options{
        private String dbHost;
        private int dbPort;
        private String database;
        private String dbUsername;
        private String dbPassword;

        public Options(String dbHost, int dbPort, String database, String dbUsername, String dbPassword) {
            this.dbHost = dbHost;
            this.dbPort = dbPort;
            this.database = database;
            this.dbUsername = dbUsername;
            this.dbPassword = dbPassword;
        }
    }
}
