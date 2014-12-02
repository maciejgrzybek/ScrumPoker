package it.grzybek.scrumpoker.server;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientsCollectorRegistrationTest {
  @Before
  public void setUp() {
    collector = new ClientsCollector();
  }

  @Test
  public void emptyTcpServerHasZeroClients() {
    assertEquals(collector.getNumberOfRegisteredClients(), 0);
  }

  @Test
  public void addingMoreClientsCausesCounterIncrease() {
    addClients(2);

    assertEquals(collector.getNumberOfRegisteredClients(), 2);
  }

  private void addClients(int number) {
    for (int i = 0; i < number; ++i)
      collector.registerClient(new Client());
  }

  private ClientsCollector collector;
}