package it.grzybek.scrumpoker.server;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class DisclosedVoteEnvelopeComparatorTest {
  @Test
  public void givenTheSameEnvelopesReturnsTrue() {
    assertTrue(comparator.compareEnvelopes(new DisclosedVoteEnvelope(5), new DisclosedVoteEnvelope(5)));
  }

  @Test
  public void givenDifferentValuesReturnsFalse() {
    assertFalse(comparator.compareEnvelopes(new DisclosedVoteEnvelope(2), new DisclosedVoteEnvelope(4)));
  }

  @Rule
  public ExpectedException exception = ExpectedException.none();

  @Test
  public void givenEnvelopeOfWrongTypeThrows() {
    exception.expect(ClassCastException.class);
    comparator.compareEnvelopes(new FakeVoteEnvelope(), new DisclosedVoteEnvelope(17));
  }

  private final DisclosedVoteEnvelopeComparator comparator = new DisclosedVoteEnvelopeComparator();

  private class FakeVoteEnvelope extends VoteEnvelope {
  }
}