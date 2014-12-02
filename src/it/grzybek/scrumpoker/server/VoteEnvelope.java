package it.grzybek.scrumpoker.server;

abstract public class VoteEnvelope {
}

class DisclosedVoteEnvelope extends VoteEnvelope {
  public DisclosedVoteEnvelope(int value) {
    this.value = value;
  }

  public final int value;
}