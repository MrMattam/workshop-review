package fr.mbonnot.solarpanel;

import java.time.LocalDate;

public class SolarPanel {

    private final int nominalCapacity;
    private double efficiency = 1.0;
    private boolean mode = false;

    public SolarPanel(int nominalWattCapacity) {
        this.nominalCapacity = nominalWattCapacity;
    }

    public void updateCurrentRealTimeParameters(double sunExposure, int temp, boolean nightMode) {
        efficiency *= sunExposure;

        if (temp > 30) {
            efficiency *= 0.8;
        }

        if (nightMode) {
            mode = true;
        }
    }

    public double getPanelData(boolean returnInstantProduction, LocalDate localDate) {

        if (mode) {
            return 0;
        }

        if (returnInstantProduction) {
            return (nominalCapacity * efficiency) * 0.98;
        } else {
            return nominalCapacity * efficiency * 0.98 * SunlightEstimator.estimateSunlightHours(localDate.getMonth().getValue());
        }
    }
}