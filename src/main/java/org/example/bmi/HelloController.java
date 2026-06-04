package org.example.bmi;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField testtomeg;

    @FXML
    private TextField testmagassag;

    @FXML
    private Label ttiEredmeny;

    @FXML
    void calculate(ActionEvent event) {
        try {

            double suly = Double.parseDouble(testtomeg.getText().trim());
            double magassagCenti = Double.parseDouble(testmagassag.getText().trim());


            if (suly <= 0 || magassagCenti <= 0) {
                ttiEredmeny.setText("Hibás adatok! Pozitív számokat adj meg.");
                return;
            }


            double magassagMeter = magassagCenti / 100.0;
            double tti = suly / (magassagMeter * magassagMeter);


            String kategoria;
            if (tti < 18.5) {
                kategoria = "Sovány";
            } else if (tti < 25.0) {
                kategoria = "Normál testsúly";
            } else if (tti < 30.0) {
                kategoria = "Túlsúlyos";
            } else {
                kategoria = "Elhízott";
            }


            ttiEredmeny.setText(String.format("TTI: %.2f -- %s", tti, kategoria));

        } catch (NumberFormatException e) {

            ttiEredmeny.setText("Hiba: Kérlek számokat adj meg!");
        }
    }
}
