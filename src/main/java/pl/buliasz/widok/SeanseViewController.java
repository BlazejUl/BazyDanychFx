package pl.buliasz.widok;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import pl.buliasz.Instancje.KontrolerPracownikInstance;
import pl.buliasz.Instancje.ModelInstance;
import pl.buliasz.kontroler.IKontrolerKierownik;
import pl.buliasz.kontroler.IKontrolerPracownik;
import pl.buliasz.kontroler.KontrolerKierownik;
import pl.buliasz.model.ISeans;

public class SeanseViewController {

    KontrolerPracownikInstance kontrolerPInstance;
    IKontrolerPracownik kontrolerP;
    IKontrolerKierownik kontroler;
    ISeans seans;
    boolean isKontrin = false;
    boolean isKontrPin = false;
    boolean seansIn = false;

    @FXML
    public Text blod7;
    @FXML
    public TextField SeansId;
    @FXML
    public Text blod2;
    @FXML
    public Text blod4;
    @FXML
    public TextField Idsali;
    @FXML
    public TextField Idfilm;
    @FXML
    public TextField paczatek;
    @FXML
    public TextField koniec;
    @FXML
    public TextField napisy;
    @FXML
    public TextField dub;
    @FXML
    public TextField wer3d;
    @FXML
    public Text blod3;

    @FXML
    public void Znajdz(ActionEvent actionEvent) {
        if(!isKontrin){
            kontroler = new KontrolerKierownik(ModelInstance.getInstance().getModel());
            isKontrin = true;
        }
        if(!isKontrPin){
            kontrolerPInstance = KontrolerPracownikInstance.getInstance();
            kontrolerP = kontrolerPInstance.getKontroler();
            isKontrPin = true;
        }
        try {
            seans = kontrolerP.dajSeans(Integer.parseInt(SeansId.getText()));
            Idsali.setText(String.valueOf(seans.getIdSali()));
            Idfilm.setText(String.valueOf(seans.getIdFilm()));
            paczatek.setText(seans.getPoczątek());
            koniec.setText(seans.getKoniec());
            napisy.setText(String.valueOf(seans.getNapisy()));
            dub.setText(String.valueOf(seans.getDubbing()));
            wer3d.setText(String.valueOf(seans.getWersja3D()));
            seansIn = true;
            blod2.setText("");
        } catch (Exception e) {
            blod2.setText("złe ID");
        }
    }

    @FXML
    public void EdytujSeans(ActionEvent actionEvent) {
        if(!isKontrin){
            kontroler = new KontrolerKierownik(ModelInstance.getInstance().getModel());
            isKontrin = true;
        }
        if(!isKontrPin){
            kontrolerPInstance = KontrolerPracownikInstance.getInstance();
            kontrolerP = kontrolerPInstance.getKontroler();
            isKontrPin = true;
        }
        if(!seansIn){
            blod4.setText("najpierw wyszukaj");
        }else {
            try {
                kontroler.modyfikacjaDanychSeansu(Integer.parseInt(SeansId.getText()),Integer.parseInt(Idsali.getText()),Integer.parseInt(Idfilm.getText()),paczatek.getText(),koniec.getText(),Boolean.valueOf(napisy.getText()),Boolean.valueOf(dub.getText()),Boolean.valueOf(wer3d.getText()));
                blod4.setText("");
            } catch (Exception e) {
                blod4.setText("złe dane");
            }
        }
    }

    @FXML
    public void StworzSeans(ActionEvent actionEvent) {
        if(!isKontrin){
            kontroler = new KontrolerKierownik(ModelInstance.getInstance().getModel());
            isKontrin = true;
        }
        if(!isKontrPin){
            kontrolerPInstance = KontrolerPracownikInstance.getInstance();
            kontrolerP = kontrolerPInstance.getKontroler();
            isKontrPin = true;
        }
        try {
            kontroler.stworzenieNowegoSeansu(Integer.parseInt(Idfilm.getText()),Integer.parseInt(Idsali.getText()),paczatek.getText());
            blod3.setText("");
        } catch (Exception e) {
            blod3.setText("złe dane");
        }
    }

    @FXML
    public void UsunSeans(ActionEvent actionEvent) {
        if(!isKontrin){
            kontroler = new KontrolerKierownik(ModelInstance.getInstance().getModel());
            isKontrin = true;
        }
        if(!isKontrPin){
            kontrolerPInstance = KontrolerPracownikInstance.getInstance();
            kontrolerP = kontrolerPInstance.getKontroler();
            isKontrPin = true;
        }
        try {
            kontroler.usunięcieSeansu(Integer.parseInt(SeansId.getText()));
        } catch (Exception e) {
            blod7.setText("złe ID");
        }
    }
}
