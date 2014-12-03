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

  public boolean isClientRegistered(Client client) {
    for (Client c : clients) {
      if (c.equals(client))
        return true;
    }

    return false;
  }

  private ArrayList<Client> clients;
}
