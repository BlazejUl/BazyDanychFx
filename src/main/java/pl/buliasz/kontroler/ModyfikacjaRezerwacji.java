package pl.buliasz.kontroler;

import pl.buliasz.model.IModel;
import pl.buliasz.model.IRezerwacja;

public class ModyfikacjaRezerwacji {
    IModel model;
    int id_rezerwacji;
    IRezerwacja rezerwacja;

    ModyfikacjaRezerwacji(IModel model, int id){
        this.model = model;
        this.id_rezerwacji = id;
        rezerwacja = this.model.dajRezerwacje(id);
        modyfikacjaRezerwacji();
        this.model.edytujRezerwacja(rezerwacja);
    }

    public void modyfikacjaRezerwacji(){
        rezerwacja.setMiejsce(34);
        rezerwacja.setNazwiskoKlienta(rezerwacja.getNazwiskoKlienta());
        rezerwacja.setTelefonKlienta("444782432");
    }
}
