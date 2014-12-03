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

  @Test
  public void askingForAddedClientReportsTrue() {
    addClients(1);
    assertTrue(collector.isClientRegistered(new Client(Integer.toString(0))));
  }

  @Test
  public void askingForNotAddedClientReportsFalse() {
    assertFalse(collector.isClientRegistered(new Client("non-existing client")));
  }

  private void addClients(int number) {
    for (int i = 0; i < number; ++i)
      collector.registerClient(new Client(Integer.toString(number)));
  }

  private ClientsCollector collector;
}