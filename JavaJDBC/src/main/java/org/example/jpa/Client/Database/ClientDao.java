package org.example.jpa.Client.Database;

import org.example.jpa.Client.Client;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
    private EntityManager manager;

    public ClientDao(EntityManager manager) {
        this.manager = manager;
    }

    public void save(Client client) {
        this.manager.getTransaction().begin();
        Client client1 = this.manager.merge(client);
        this.manager.persist(client1);
        this.manager.getTransaction().commit();
        this.manager.close();
    }


    public List<Client> clients() {
        this.manager.getTransaction().begin();
        String jpql = "SELECT c FROM Client c ";
        List<Client> clients= manager.createQuery(jpql,Client.class).getResultList();
        this.manager.getTransaction().commit();
        this.manager.close();
        return clients;
    }

    public void update( int id) {
        this.manager.getTransaction().begin();
        Client client1 =manager.find(Client.class,id);
        client1.setAge("foi editado");
        manager.persist(client1);
        this.manager.getTransaction().commit();
        this.manager.close();
    }

    public void delete(int id) {
        this.manager.getTransaction().begin();
        Client client1 =  manager.find(Client.class,id);
       manager.remove(client1);
       this.manager.getTransaction().commit();
       this.manager.close();
    }
}