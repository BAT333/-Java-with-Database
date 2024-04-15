package org.example.jpa.Client.Database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    public EntityManagerFactory manager() {
      return Persistence.createEntityManagerFactory("cadastro");

    }

}
