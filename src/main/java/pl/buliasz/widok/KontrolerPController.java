package pl.buliasz.widok;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import pl.buliasz.Instancje.DAOinstance;
import pl.buliasz.Instancje.KontrolerPracownikInstance;
import pl.buliasz.Instancje.ModelInstance;
import pl.buliasz.kontroler.IKontrolerPracownik;
import pl.buliasz.model.IDAO;
import pl.buliasz.model.IModel;
import pl.buliasz.model.ISeans;
import pl.buliasz.model.ListaSeans;

import java.io.IOException;
import java.util.List;


public class KontrolerPController {
    @FXML
    public Label label;
    public IDAO dao;
    public DAOinstance data = DAOinstance.getInstance();
    public KontrolerPracownikInstance pracownikInstance = KontrolerPracownikInstance.getInstance();
    public boolean isDAOin = false;
    public boolean isKontrolerin = false;
    public IKontrolerPracownik kontroler;
    public boolean swp = false;

    @FXML
    public Text blod;
    @FXML
    public Button findmovie;
    @FXML
    public TextField seansId;
    @FXML
    public Button toKierownik;
    @FXML
    public Text blod2;
    @FXML
    public Button rezerwacje;
    @FXML
    public Button refresh;
    @FXML
    public ListView seanse;
    Integer filmId;

    @FXML
    public void Szukaj(ActionEvent actionEvent) {
        if(!isDAOin){
            dao = data.getDao();
            isDAOin = true;
        }
        if (!isKontrolerin){
            kontroler = pracownikInstance.getKontroler();
            isKontrolerin = true;
        }
        seanse.getItems().clear();
        blod.setText("");
        try {
            if(seansId.getText().isEmpty()){
                filmId = null;
            }else {
                filmId = Integer.parseInt(seansId.getText());
            }
            List<ISeans> seansList = kontroler.wyszukanieSeansów(filmId);
            seanse.getItems().add("id      id_sali      id_film      początek      koniec      napisy      dubbing    wersja_3D");
            for (ISeans seans:seansList){
                seanse.getItems().add(seans.getId()+"    "+seans.getIdSali()+"    "+ seans.getIdFilm()+" "+
                        seans.getPoczątek()+" "+seans.getKoniec()+" "+seans.getNapisy()+" "+seans.getDubbing()+" "+seans.getWersja3D());
            }
            swp = true;
        } catch (Exception e) {
            blod.setText("zły format Id");
        }
    }

    @FXML
    public void TryKierownik(ActionEvent actionEvent) throws IOException {
        if(!isDAOin){
            dao = data.getDao();
            isDAOin = true;
        }
        if(dao.dajUsername().equals("kierownik")){
            new SeanseWindow().open();
        }else {
            blod2.setText("Nie masz uprawnień");
        }
    }

    @FXML
    public void aktualizuj(ActionEvent actionEvent) {
        if (!isKontrolerin){
            kontroler = pracownikInstance.getKontroler();
            isKontrolerin = true;
        }
        seanse.getItems().clear();
        if(swp){
            List<ISeans> seansList = kontroler.wyszukanieSeansów(filmId);
            seanse.getItems().add("id      id_sali      id_film      początek      koniec      napisy      dubbing    wersja_3D");
            for (ISeans seans:seansList){
                seanse.getItems().add(seans.getId()+"    "+seans.getIdSali()+"    "+ seans.getIdFilm()+" "+
                        seans.getPoczątek()+" "+seans.getKoniec()+" "+seans.getNapisy()+" "+seans.getDubbing()+" "+seans.getWersja3D());
            }
        }
    }

    @FXML
    public void Rezerwacje(ActionEvent actionEvent) throws IOException {
        new RezerwacjeWindow().open();
    }
}
