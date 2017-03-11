package com.github.moonj;

public final class MoonJourneyCandidates {
    private final int totalCandidates;
    private final int associations[];

    public MoonJourneyCandidates(int totalCandidates) {
        this.totalCandidates = totalCandidates;
        this.associations = new int[totalCandidates];
        for (int country = 0; country < totalCandidates; country++) {
            associations[country] = country;
        }
    }

    public int getPairsNumber() {
        int sumOfSquares = getSumOfSquares();

        return (totalCandidates * totalCandidates - sumOfSquares) / 2;
    }

    private int getSumOfSquares() {
        int[] counter = new int[totalCandidates];
        for (int i = 0; i < totalCandidates; i++) {
            int country = associations[i];
            counter[country]++;
        }
        int sumOfSquares = 0;
        for (int i = 0; i < totalCandidates; i++) {
            sumOfSquares += counter[i] * counter[i];
        }
        return sumOfSquares;
    }

    public void associate(int firstCandidate, int secondCandidate) {
        if (!isValid(firstCandidate) || !isValid(secondCandidate)) {
            throw new CandidateNumberOutOfBounds();
        }

        if (!haveSameCountry(firstCandidate, secondCandidate)) {
            for (int candidate = 0; candidate < totalCandidates; candidate++) {
                if (haveSameCountry(candidate, secondCandidate)) {
                    associations[candidate] = associations[firstCandidate];
                }
            }
        }
    }

    private boolean isValid(int candidate) {
        return candidate >= 0 && candidate < totalCandidates;
    }

    public boolean haveSameCountry(int firstCandidate, int secondCandidate) {
        return associations[firstCandidate] == associations[secondCandidate];
    }

    public class CandidateNumberOutOfBounds extends RuntimeException {
    }
}
