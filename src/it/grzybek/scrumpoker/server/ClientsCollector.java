package it.grzybek.scrumpoker.server;

import java.util.ArrayList;

public class ClientsCollector {
  public ClientsCollector() {
    clients = new ArrayList<Client>();
  }

  public void registerClient(Client client) {
    clients.add(client);
  }

  public int getNumberOfRegisteredClients() {
    return clients.size();
  }

  private ArrayList<Client> clients;
}
