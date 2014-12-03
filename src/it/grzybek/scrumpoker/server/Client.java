package it.grzybek.scrumpoker.server;

public class Client {
  public Client(String ID) {
    this.ID = ID;
  }

  public final String ID;

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Client))
      return false;

    return (this.ID.equals(((Client)o).ID));
  }
}
