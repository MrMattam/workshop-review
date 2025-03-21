package fr.mbonnot.solarpanel;

public class SunlightEstimator {

    private SunlightEstimator() {

    }

    public static int estimateSunlightHours(int month) {
        return switch (month) {
            case 12 -> 4; // full winter
            case 11, 1 -> 5; // slow winter
            case 2, 3, 8, 9 -> 6; // end winter, end summer
            case 4, 10 -> 7; // spring and autumn
            case 7, 5 -> 8; // slow summer
            case 6 -> 9; // full summer
            default -> throw new IllegalArgumentException("Invalid month : " + month);
        };
    }
}
