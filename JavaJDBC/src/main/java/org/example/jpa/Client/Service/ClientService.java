package org.example.jpa.Client.Service;

import org.example.jpa.Client.Client;
import org.example.jpa.Client.Database.ClientDao;
import org.example.jpa.Client.Database.ConnectionFactory;

import java.util.List;

public class ClientService {
    private ConnectionFactory factory;
    public ClientService(){
        this.factory=new ConnectionFactory();


    }

    public void saveClient(Client client){
        ClientDao dao = new ClientDao(factory.manager().createEntityManager());
        dao.save(client);
    }
    public List<Client> listClient(){
        ClientDao dao = new ClientDao(factory.manager().createEntityManager());
        return dao.clients();

    }
    public void UpdateClient( int id){
        ClientDao dao = new ClientDao(factory.manager().createEntityManager());
        dao.update(id);

    }
    public void deleteClient(int id){
        ClientDao dao = new ClientDao(factory.manager().createEntityManager());
        dao.delete(id);


    }


}
