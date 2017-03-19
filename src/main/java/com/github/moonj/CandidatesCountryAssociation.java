package com.github.moonj;

public class CandidatesCountryAssociation {
    private final int totalCandidates;
    private final int[] associations;

    public CandidatesCountryAssociation(int totalCandidates) {
        this.totalCandidates = totalCandidates;
        this.associations = new int[totalCandidates];
        for (int country = 0; country < totalCandidates; country++) {
            associations[country] = country;
        }
    }

    public void associate(int firstCandidate, int secondCandidate) {
        if (!isValid(firstCandidate) || !isValid(secondCandidate)) {
            throw new CandidateIdOutOfBounds();
        }

        if (!isAssociated(firstCandidate, secondCandidate)) {
            for (int candidate = 0; candidate < totalCandidates; candidate++) {
                if (isAssociated(candidate, secondCandidate)) {
                    associations[candidate] = associations[firstCandidate];
                }
            }
        }
    }

    public int getCountry(int candidate) {
        if (!isValid(candidate)) {
            throw new CandidateIdOutOfBounds();
        }
        return associations[candidate];
    }

    private boolean isValid(int candidate) {
        return candidate >= 0 && candidate < totalCandidates;
    }

    public boolean isAssociated(int firstCandidate, int secondCandidate) {
        return associations[firstCandidate] == associations[secondCandidate];
    }

    public class CandidateIdOutOfBounds extends RuntimeException {
    }
}
