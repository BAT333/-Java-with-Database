package org.example.jdbc;

import org.example.jdbc.Client.Client;
import org.example.jdbc.Client.Database.ClientDao;
import org.example.jdbc.Client.Database.ConnectionFactory;
import org.example.jdbc.Client.Service.ClientService;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("ROBERTO","50","-------------------------");
        ClientService service = new ClientService();
        service.saveClient(client);
       // service.listClient().forEach(System.out::println);
        service.UpdateClient(client,4);
        service.listClient().forEach(System.out::println);
        //service.deleteClient(4);

    }
}