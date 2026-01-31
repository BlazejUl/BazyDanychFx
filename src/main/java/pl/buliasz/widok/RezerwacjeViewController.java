package pl.buliasz.widok;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import pl.buliasz.Instancje.KontrolerPracownikInstance;
import pl.buliasz.kontroler.IKontrolerPracownik;
import pl.buliasz.model.IRezerwacja;
import pl.buliasz.model.ISeans;

import java.util.List;

public class RezerwacjeViewController {
    @FXML
    public Text blod6;
    @FXML
    public ListView rezerwacje;
    @FXML
    public TextField seansId;
    @FXML
    public Text blod;
    @FXML
    public Text blod3;
    @FXML
    public TextField Idseans;
    @FXML
    public TextField miejsce;
    @FXML
    public TextField dataR;
    @FXML
    public TextField nazwisko;
    @FXML
    public TextField telefon;
    @FXML
    public TextField rezerwacjaId;
    @FXML
    public Text blod2;
    @FXML
    public Text blod4;
    @FXML
    public Text blod7;

    KontrolerPracownikInstance kontrolerInstance;
    IKontrolerPracownik kontroler;
    boolean isKontrolerin = false;
    Integer SeansID;
    boolean znajdzKlik = false;
    IRezerwacja edytowana;

    @FXML
    public void aktualizuj(ActionEvent actionEvent) {
        if (!isKontrolerin){
            kontrolerInstance = KontrolerPracownikInstance.getInstance();
            kontroler = kontrolerInstance.getKontroler();
            isKontrolerin = true;
        }
        rezerwacje.getItems().clear();
        if(SeansID!=null){
            List<IRezerwacja> rezerwacjeList = kontroler.wyszukajRezerwację(SeansID);
            rezerwacje.getItems().add("id idSeans miejsce dataRezerwacji nazwiskoKlienta telefonKlienta");
            for (IRezerwacja rezerwacja:rezerwacjeList){
                rezerwacje.getItems().add(rezerwacja.getId()+"    "+rezerwacja.getIdSeans()+"    "+ rezerwacja.getMiejsce()+" "+
                        rezerwacja.getDataRezerwacji()+" "+rezerwacja.getNazwiskoKlienta()+" "+rezerwacja.getTelefonKlienta());
            }
            blod6.setText("");
        }else {
            blod6.setText("najpierw wyszukaj rezerwacje");
        }
    }

    @FXML
    public void Szukaj(ActionEvent actionEvent) {
        if (!isKontrolerin){
            kontrolerInstance = KontrolerPracownikInstance.getInstance();
            kontroler = kontrolerInstance.getKontroler();
            isKontrolerin = true;
        }
        rezerwacje.getItems().clear();
        try {
            SeansID = Integer.parseInt(seansId.getText());
            List<IRezerwacja> rezerwacjeList = kontroler.wyszukajRezerwację(SeansID);
            rezerwacje.getItems().add("id idSeans miejsce dataRezerwacji nazwiskoKlienta telefonKlienta");
            for (IRezerwacja rezerwacja:rezerwacjeList){
                rezerwacje.getItems().add(rezerwacja.getId()+"    "+rezerwacja.getIdSeans()+"    "+ rezerwacja.getMiejsce()+" "+
                        rezerwacja.getDataRezerwacji()+" "+rezerwacja.getNazwiskoKlienta()+" "+rezerwacja.getTelefonKlienta());
            }
            blod.setText("");
        }catch (Exception e){
            blod.setText("zły format ID");
        }


    }

    @FXML
    public void StworzRezerwacja(ActionEvent actionEvent) {
        if (!isKontrolerin){
            kontrolerInstance = KontrolerPracownikInstance.getInstance();
            kontroler = kontrolerInstance.getKontroler();
            isKontrolerin = true;
        }
        try {
            kontroler.rezerwacjaMiejsca(Integer.parseInt(Idseans.getText()),Integer.parseInt(miejsce.getText()),dataR.getText(),nazwisko.getText(),telefon.getText());

            blod3.setText("");
        } catch (Exception e) {
            blod3.setText("Nieprawidłowe Dane");
        }
    }

    @FXML
    public void EdytujRezeracja(ActionEvent actionEvent) {
        if (!isKontrolerin){
            kontrolerInstance = KontrolerPracownikInstance.getInstance();
            kontroler = kontrolerInstance.getKontroler();
            isKontrolerin = true;
        }
        if(!znajdzKlik){
            blod4.setText("Najpierw znajdz rezerwacje");
        }else {
            try {
                kontroler.modyfikacjaRezerwacji(edytowana.getId(),Integer.parseInt(miejsce.getText()),nazwisko.getText(),telefon.getText());
                blod4.setText("edytowano");
                znajdzKlik=false;
            } catch (Exception e) {
                blod4.setText("Nieprawidłowe Dane");
            }
        }
    }

    @FXML
    public void Znajdz(ActionEvent actionEvent) {
        if (!isKontrolerin){
            kontrolerInstance = KontrolerPracownikInstance.getInstance();
            kontroler = kontrolerInstance.getKontroler();
            isKontrolerin = true;
        }
        try {
            edytowana = kontroler.dajRezerwacje(Integer.parseInt(rezerwacjaId.getText()));
            if(edytowana.getId()==null){
                blod2.setText("nie istnieje");
            }else {
                Idseans.setText(String.valueOf(edytowana.getIdSeans()));
                miejsce.setText(String.valueOf(edytowana.getMiejsce()));
                dataR.setText(edytowana.getDataRezerwacji());
                nazwisko.setText(edytowana.getNazwiskoKlienta());
                telefon.setText(edytowana.getTelefonKlienta());
                znajdzKlik = true;
                blod2.setText("");
            }

        } catch (Exception e) {
            blod2.setText("zły format");
        }

    }

    @FXML
    public void UsunRezerwacja(ActionEvent actionEvent) {
        if (!isKontrolerin){
            kontrolerInstance = KontrolerPracownikInstance.getInstance();
            kontroler = kontrolerInstance.getKontroler();
            isKontrolerin = true;
        }
        try {
            kontroler.usunięcieRezerwacji(Integer.parseInt(rezerwacjaId.getText()));
            blod7.setText("");
        } catch (Exception e) {
            blod7.setText("zły format");
        }

    }
}
