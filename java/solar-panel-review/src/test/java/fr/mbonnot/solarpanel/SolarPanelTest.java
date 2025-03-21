package fr.mbonnot.solarpanel;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class SolarPanelTest {

    @Test
    void initialProduction(){
        // Given
        SolarPanel solarPanel = new SolarPanel(500);

        // When
        double calculatedInstantProduction = solarPanel.getPanelData(true, LocalDate.of(2025, 3, 20));

        // Then
        Assertions.assertThat(calculatedInstantProduction).isEqualTo(490);
    }

    @Test
    void instantProduction_normalTemp() {
        // Given
        SolarPanel panel = new SolarPanel(1000);

        // When
        panel.updateCurrentRealTimeParameters(0.8, 25, false);
        double calculatedInstantProduction = panel.getPanelData(true, LocalDate.of(2025, 3, 20));

        // Then
        Assertions.assertThat(calculatedInstantProduction).isEqualTo(784.0);
    }

    @Test
    void instantProduction_highTemp() {
        // Given
        SolarPanel panel = new SolarPanel(1000);

        // When
        panel.updateCurrentRealTimeParameters(0.8, 35, false);
        double calculatedInstantProduction = panel.getPanelData(true, LocalDate.of(2025, 3, 20));

        // Then
        Assertions.assertThat(calculatedInstantProduction).isEqualTo(627.2);
    }

    @Test
    void nightModeSetsFlag() {
        // Given
        SolarPanel panel = new SolarPanel(1000);
        panel.updateCurrentRealTimeParameters(1.0, 20, true);

        // When
        double calculatedInstantProduction = panel.getPanelData(true, LocalDate.of(2025, 6, 15));

        // Then
        Assertions.assertThat(calculatedInstantProduction).isZero();
    }


    @Test
    void dailyProduction_estimationMarch() {
        // Given
        SolarPanel panel = new SolarPanel(1000);
        panel.updateCurrentRealTimeParameters(0.9, 25, false);

        // When
        double calculatedInstantProduction = panel.getPanelData(false, LocalDate.of(2025, 3, 1));

        // Then
        Assertions.assertThat(calculatedInstantProduction).isEqualTo(5292.0);
    }

    @Test
    void dailyProduction_winterLowSun() {
        // Given
        SolarPanel panel = new SolarPanel(500);
        panel.updateCurrentRealTimeParameters(0.4, 20, false);

        // When
        double calculatedInstantProduction = panel.getPanelData(false, LocalDate.of(2025, 12, 1));

        // Then
        Assertions.assertThat(calculatedInstantProduction).isEqualTo(784.0);
    }

}
