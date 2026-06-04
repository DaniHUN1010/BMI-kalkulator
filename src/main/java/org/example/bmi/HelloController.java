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
            if (tti < 16) {
                kategoria = "Súlyos soványság";
            } else if (tti < 17) {
                kategoria = "Mérsékelt soványság";
            } else if (tti < 18.5) {
                kategoria = "Enyhe soványság";
            } else if (tti < 25) {
                kategoria = "Normális testsúly";
            } else if (tti < 30) {
                kategoria = "Túlsúlyos";
            } else if (tti < 35) {
                kategoria = "I. fokú elhízás";
            } else if (tti < 40) {
                kategoria = "II. fokú elhízás";
            } else {
                kategoria = "III. fokú (súlyos) elhízás";
            }


            ttiEredmeny.setText(String.format("TTI: %.2f -- %s", tti, kategoria));

        } catch (NumberFormatException e) {

            ttiEredmeny.setText("Hiba: Kérlek számokat adj meg!");
        }
    }
}
