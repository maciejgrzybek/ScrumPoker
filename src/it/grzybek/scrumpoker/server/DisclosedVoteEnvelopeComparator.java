package it.grzybek.scrumpoker.server;

public class DisclosedVoteEnvelopeComparator implements VoteEnvelopeComparator {
  @Override
  public boolean compareEnvelopes(VoteEnvelope a, VoteEnvelope b) {
    DisclosedVoteEnvelope disclosedA = (DisclosedVoteEnvelope)a;
    DisclosedVoteEnvelope disclosedB = (DisclosedVoteEnvelope)b;

    return (disclosedA.value == disclosedB.value);
  }
}
