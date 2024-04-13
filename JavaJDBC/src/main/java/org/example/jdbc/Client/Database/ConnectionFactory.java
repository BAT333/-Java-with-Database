package org.example.jdbc.Client.Database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection connection() {
        try {
           // return DriverManager.getConnection("jdbc:mysql://localhost:3306/bancotest?user=root&password=Rafael234");
            return this.dataSource().getConnection();
        }catch (SQLException e){
            throw new RuntimeException(e);

        }
    }
    private HikariDataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/cadastro");
        config.setUsername("root");
        config.setPassword("Rafael234");
        config.setMaximumPoolSize(10);
        return new HikariDataSource(config);
    }
}
