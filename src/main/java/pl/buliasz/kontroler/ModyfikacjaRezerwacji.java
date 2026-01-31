package pl.buliasz.kontroler;

import pl.buliasz.model.IModel;
import pl.buliasz.model.IRezerwacja;

public class ModyfikacjaRezerwacji {
    IModel model;
    Integer id_rezerwacji;
    IRezerwacja rezerwacja;

    ModyfikacjaRezerwacji(IModel model, Integer id,Integer miejsce,String nazwisko,String telefon){
        this.model = model;
        this.id_rezerwacji = id;
        rezerwacja = this.model.dajRezerwacje(id);
        modyfikacjaRezerwacji(miejsce,nazwisko,telefon);
        this.model.edytujRezerwacja(rezerwacja);
    }

    public void modyfikacjaRezerwacji(Integer miejsce,String nazwisko,String telefon){
        rezerwacja.setMiejsce(miejsce);
        rezerwacja.setNazwiskoKlienta(nazwisko);
        rezerwacja.setTelefonKlienta(telefon);
    }
}
