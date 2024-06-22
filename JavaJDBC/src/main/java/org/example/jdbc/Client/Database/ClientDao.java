package org.example.jdbc.Client.Database;

import org.example.jdbc.Client.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
    private Connection connection;
    public ClientDao(Connection connection){

        this.connection = connection;
    }
    public void save(Client client){
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("insert into usuario(nome,idade,endereco) value(?,?,?)");
            statement.setString(1, client.getName());
            statement.setString(2, client.getAge());
            statement.setString(3, client.getAddress());
            statement.execute();
            connection.commit();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            try {
                connection.rollback();
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }
    }
    public List<Client> clients(){
        List<Client> clients = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuario");
            ResultSet set =  statement.executeQuery();
            while (set.next()){
                String name = set.getString(2);
                String age = set.getString(3);
                String address = set.getString(4);
                Client client = new Client(name,age,address);
                clients.add(client);
            }
            set.close();
            statement.close();
            connection.close();
            return clients;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void update(Client client,int id){
        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("update usuario set nome = ? where id = ?");
            statement.setString(1,client.getName());
            statement.setInt(2,id);
            statement.execute();
            connection.commit();
            statement.close();
            connection.close();

        }catch (SQLException e){
            try {
                connection.rollback();
            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);
        }

    }
    public void delete(int id){

        try {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement("DELETE FROM usuario WHERE id = ?");
            statement.setInt(1,id);
            statement.execute();
            connection.commit();
            statement.close();
            connection.close();


        }catch (SQLException e){
            try {
                connection.rollback();

            }catch (SQLException ex){
                throw new RuntimeException(ex);
            }
            throw new RuntimeException(e);

        }

    }
}
