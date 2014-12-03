package it.grzybek.scrumpoker.server;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClientTest {
  @Test
  public void clientsWithTheSameIDAreEqual() {
    Client a = new Client("ID1");
    Client b = new Client("ID1");
    assertTrue(a.equals(b));
  }

  @Test
  public void clientsWithDifferentIDsAreNotEqual() {
    Client a = new Client("first_ID");
    Client b = new Client("ID_two");
    assertFalse(a.equals(b));
  }

  @Test
  public void clientIsNotEqualToNonClient() {
    Client a = new Client("some Client");
    Integer b = new Integer(5);
    assertFalse(a.equals(b));
  }
}