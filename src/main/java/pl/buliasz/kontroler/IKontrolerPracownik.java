package pl.buliasz.kontroler;

import pl.buliasz.model.IRezerwacja;
import pl.buliasz.model.ISeans;

import java.util.List;

public interface IKontrolerPracownik {

    List<ISeans> wyszukanieSeansów(Integer filmID);

    void rezerwacjaMiejsca(int idSeans,int miejsce,String dataRezerwacji,
                           String nazwiskoKlienta,String telefonKlienta);

    List<IRezerwacja> wyszukajRezerwację(Integer SeansID);

    IRezerwacja dajRezerwacje(Integer id);

    ISeans dajSeans(Integer seansID);

    void modyfikacjaRezerwacji(Integer id,Integer miejsce,String nazwisko,String telefon);

    void usunięcieRezerwacji(Integer rezerwacjaID);

}
