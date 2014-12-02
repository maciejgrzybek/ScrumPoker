package it.grzybek.scrumpoker.server;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VoteRegistrarTest {
  @Before
  public void setUp() {
    registrar = getVoteRegistrarWithComparatorAnsweringAlwaysFalse();
  }

  @Test
  public void noVotesMeansFailure() {
    assertFalse(registrar.isVotingSuccessful());
  }

  @Test
  public void oneVoteIsAlwaysSuccessful() {
    registerVotes(1);

    assertTrue(registrar.isVotingSuccessful());
  }

  @Test
  public void votingFailsOnNonEqualVotes() {
    registerVotes(2);

    assertFalse(registrar.isVotingSuccessful());
  }

  @Test
  public void votingIsSuccessfulWhenAllVotesAreEqual() {
    registrar = getVoteRegistrarWithComparatorAnsweringAlwaysTrue();

    registerVotes(3);

    assertTrue(registrar.isVotingSuccessful());
  }

  private VoteRegistrar getVoteRegistrarWithComparatorAnsweringAlwaysTrue() {
    return new VoteRegistrar(new VoteEnvelopeComparator() {
      @Override
      public boolean compareEnvelopes(VoteEnvelope a, VoteEnvelope b) {
        return true;
      }
    });
  }

  private VoteRegistrar getVoteRegistrarWithComparatorAnsweringAlwaysFalse() {
    return new VoteRegistrar(new VoteEnvelopeComparator() {
      @Override
      public boolean compareEnvelopes(VoteEnvelope a, VoteEnvelope b) {
        return false;
      }
    });
  }

  private void registerVotes(int number) {
    for (int i = 0; i < number; ++i)
      registrar.registerVote(new FakeVoteEnvelope());
  }

  private class FakeVoteEnvelope extends VoteEnvelope {
  }

  private VoteRegistrar registrar;
}