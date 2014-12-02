package it.grzybek.scrumpoker.server;

public interface VoteEnvelopeComparator {
  boolean compareEnvelopes(VoteEnvelope a, VoteEnvelope b);
}
