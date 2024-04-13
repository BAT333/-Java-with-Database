package org.example.jdbc.Client.Service;

import org.example.jdbc.Client.Client;
import org.example.jdbc.Client.Database.ClientDao;
import org.example.jdbc.Client.Database.ConnectionFactory;

import java.util.List;

public class ClientService {
    private ConnectionFactory factory;
    public ClientService(){
        this.factory = new ConnectionFactory();
    }
    public void saveClient(Client client){
        ClientDao dao = new ClientDao(factory.connection());
        dao.save(client);
    }
    public List<Client> listClient(){
        ClientDao dao = new ClientDao(factory.connection());
       return dao.clients();

    }
    public void UpdateClient(Client client,int id){
        ClientDao dao = new ClientDao(factory.connection());
        dao.update(client,id);

    }
    public void deleteClient(int id){
        ClientDao dao = new ClientDao(factory.connection());
        dao.delete(id);

    }

}
