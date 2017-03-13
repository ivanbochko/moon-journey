package com.github.moonj;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoonJourneyTest {
    private void numberOfCandidatesCanCreatePairs(int totalCandidates, int expectedPairs) {
        MoonJourneyCandidates candidates = new MoonJourneyCandidates(totalCandidates);
        assertEquals(expectedPairs, candidates.getPairsNumber());
    }

    @Test
    public void testLackOfCandidates() {
        numberOfCandidatesCanCreatePairs(0, 0);
        numberOfCandidatesCanCreatePairs(1, 0);
        numberOfCandidatesCanCreatePairs(2, 1);
    }

    @Test
    public void testNoAssociatedPairs() {
        numberOfCandidatesCanCreatePairs(3, 3);
        numberOfCandidatesCanCreatePairs(4, 6);
        numberOfCandidatesCanCreatePairs(5, 10);
    }

    @Test(expected = MoonJourneyCandidates.CandidateNumberOutOfBounds.class)
    public void throwWhenWrongCandidateNumberPassedToAssociate() {
        MoonJourneyCandidates journeyCandidates = new MoonJourneyCandidates(3);
        journeyCandidates.associate(3, -1);
    }

    @Test
    public void testIsAssociated() {
        MoonJourneyCandidates candidates = new MoonJourneyCandidates(10);
        candidates.associate(1, 2);
        candidates.associate(5, 2);
        candidates.associate(9, 5);
        assertTrue(candidates.haveSameCountry(1, 9));
        assertFalse(candidates.haveSameCountry(0, 3));
    }

    @Test
    public void testLackOfCountries() {
        MoonJourneyCandidates candidates = new MoonJourneyCandidates(2);
        candidates.associate(0, 1);
        assertEquals(0, candidates.getPairsNumber());
    }

    @Test
    public void testAssociatedPairsCount() {
        MoonJourneyCandidates candidates = new MoonJourneyCandidates(3);
        candidates.associate(0, 2);
        assertEquals(2, candidates.getPairsNumber());
    }

    @Test
    public void testReadmeUsecase() {
        MoonJourneyCandidates candidates = new MoonJourneyCandidates(6);
        candidates.associate(0, 2);
        candidates.associate(2, 1);
        candidates.associate(3, 4);
        candidates.associate(5, 4);
        assertEquals(9, candidates.getPairsNumber());
    }
}
