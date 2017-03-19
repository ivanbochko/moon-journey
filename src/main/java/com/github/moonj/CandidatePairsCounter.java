package com.github.moonj;

/**
 * Combination: pairs count between disjoint set elements
 *
 * 2N = (a[0] +...+ a[n])^2 - (a[0]^2 +... + a[n]^2)
 *
 */
public final class CandidatePairsCounter {
    private final int totalCandidates;
    private final CandidatesCountryAssociation candidatesCountryAssociation;

    public CandidatePairsCounter(int totalCandidates, CandidatesCountryAssociation candidatesCountryAssociation) {
        this.totalCandidates = totalCandidates;
        this.candidatesCountryAssociation = candidatesCountryAssociation;
    }

    public int getPairsNumber() {
        final int sumOfSquares = getSumOfSquares();
        final int squareOfSum = totalCandidates * totalCandidates;
        return (squareOfSum - sumOfSquares) / 2;
    }

    private int getSumOfSquares() {
        int[] counter = new int[totalCandidates];
        for (int i = 0; i < totalCandidates; i++) {
            int country = candidatesCountryAssociation.getCountry(i);
            counter[country]++;
        }
        int sumOfSquares = 0;
        for (int i = 0; i < totalCandidates; i++) {
            sumOfSquares += counter[i] * counter[i];
        }
        return sumOfSquares;
    }

}
