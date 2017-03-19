package com.github.moonj;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MoonJourneyTest {
    private void numberOfCandidatesCanCreatePairs(int totalCandidates, int expectedPairs) {
        CandidatesCountryAssociation association = new CandidatesCountryAssociation(totalCandidates);
        CandidatePairsCounter candidates = new CandidatePairsCounter(totalCandidates, association);
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

    @Test(expected = CandidatesCountryAssociation.CandidateIdOutOfBounds.class)
    public void throwWhenWrongCandidateNumberPassedToAssociate() {
        CandidatesCountryAssociation candidatesCountryAssociation = new CandidatesCountryAssociation(3);
        candidatesCountryAssociation.associate(3, -1);
    }

    @Test
    public void testIsAssociated() {
        CandidatesCountryAssociation candidates = new CandidatesCountryAssociation(10);
        candidates.associate(1, 2);
        candidates.associate(5, 2);
        candidates.associate(9, 5);
        assertTrue(candidates.isAssociated(1, 9));
        assertFalse(candidates.isAssociated(0, 3));
    }

    @Test
    public void testLackOfCountries() {
        CandidatesCountryAssociation association = new CandidatesCountryAssociation(2);
        CandidatePairsCounter candidates = new CandidatePairsCounter(2, association);
        association.associate(0, 1);
        assertEquals(0, candidates.getPairsNumber());
    }

    @Test
    public void testAssociatedPairsCount() {
        CandidatesCountryAssociation association = new CandidatesCountryAssociation(3);
        CandidatePairsCounter candidates = new CandidatePairsCounter(3, association);
        association.associate(0, 2);
        assertEquals(2, candidates.getPairsNumber());
    }

    @Test
    public void testReadmeUsecase() {
        CandidatesCountryAssociation association = new CandidatesCountryAssociation(6);
        CandidatePairsCounter candidates = new CandidatePairsCounter(6, association);
        association.associate(0, 2);
        association.associate(2, 1);
        association.associate(3, 4);
        association.associate(5, 4);
        assertEquals(9, candidates.getPairsNumber());
    }
}
