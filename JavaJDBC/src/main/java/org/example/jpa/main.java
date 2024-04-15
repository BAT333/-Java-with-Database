package org.example.jpa;

import org.example.jpa.Client.Client;
import org.example.jpa.Client.Service.ClientService;

public class main {
    public static void main(String[] args) {
      /*
        //STATIC
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("cadastro");
        EntityManager manager = managerFactory.createEntityManager();
        //DAO




        manager.getTransaction().begin();
        Client client = new Client("CARLOS ROBERTO","50","-------------");
        manager.persist(client);
       Client client1 = manager.find(Client.class,7);
       client1.setAge("90");
       manager.persist(client);
       //manager.remove(client1);
        System.out.println(client1);
        manager.createQuery("SELECT c FROM Client c",Client.class).getResultList().forEach(System.out::println);

        manager.getTransaction().commit();
        manager.close();

        Client client2 = manager.merge(client1);
        client2 = manager.find(Client.class,3);
        client2.setAge("2");
        manager.flush();
        manager.getTransaction().commit();
        manager.close();
         */
        Client client = new Client(" DOIDEIRE OPA ","90","-------------");
        ClientService service = new ClientService();
        service.saveClient(client);
        service.listClient().forEach(System.out::println);
       service.UpdateClient(5);
        service.listClient().forEach(System.out::println);
        //service.deleteClient(9);






    }

}
