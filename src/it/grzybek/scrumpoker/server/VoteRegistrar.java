package it.grzybek.scrumpoker.server;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class VoteRegistrar {
  public VoteRegistrar(VoteEnvelopeComparator comparator) {
    this.comparator = comparator;
  }

  public void registerVote(VoteEnvelope e) {
    votes.add(e);
  }

  public boolean isVotingSuccessful() {
    VoteEnvelope previous;
    Iterator<VoteEnvelope> it = votes.iterator();
    try {
      previous = it.next();
    }
    catch (NoSuchElementException ex) {
      return false;
    }
    while (it.hasNext()) {
      VoteEnvelope currentElement = it.next();
      boolean currentComparison = comparator.compareEnvelopes(previous, currentElement);
      if (!currentComparison)
        return false;
      previous = currentElement;
    }

    return true;
  }

  private ArrayList<VoteEnvelope> votes = new ArrayList<VoteEnvelope>();
  private final VoteEnvelopeComparator comparator;
}
