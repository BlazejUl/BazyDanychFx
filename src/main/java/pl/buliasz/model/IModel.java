package pl.buliasz.model;

import java.util.List;

public interface IModel {

    List<ISeans> dajWszystkieSeanse();

    ISeans dajSeans(int id);

    List<IRezerwacja> dajWszystkieRezerwacje();

    List<IRezerwacja> dajWszystkieRezerwacjePoIdSeansu(int idSeans);

    IRezerwacja dajRezerwacje(int id);

    void dodajSeans(int idSali, int idFilm, String początek);

    void usuńSeans(int id);

    void edytujSeans(ISeans seans);

    void dodajRezerwacja(int idSeans,  int miejsce, String dataRezerwacji, String nazwiskoKlienta, String telefonKlienta);

    void usuńRezerwacja(int id);

    void edytujRezerwacja(IRezerwacja rezerwacja);
}
