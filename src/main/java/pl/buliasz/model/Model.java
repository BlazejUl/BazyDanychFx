package pl.buliasz.model;

import java.util.List;

public class Model implements IModel{
    IDAO dao;
    ListaRezerwacja listaRezerwacja;
    ListaSeans listaSeans;

    public Model(IDAO dao){
        this.dao = dao;
        listaRezerwacja = dao.aktualizujRezerwacja().weźRezerwacje();
        listaSeans = dao.aktualizujSeans().weźSeans();

    }

    @Override
    public List<ISeans> dajWszystkieSeanse() {
        return listaSeans.weźWszystko();
    }

    @Override
    public List<ISeans> dajWszystkieSeansePoIdFilmu(int id) {
        return listaSeans.weźWszystkoPoIdFilmu(id);
    }

    @Override
    public ISeans dajSeans(int id) {
        return listaSeans.znajdźSeans(id);
    }

    @Override
    public List<IRezerwacja> dajWszystkieRezerwacje() {
        return listaRezerwacja.weźWszystko();
    }

    @Override
    public List<IRezerwacja> dajWszystkieRezerwacjePoIdSeansu(int idSeans) {
        return listaRezerwacja.weźPoIdSeansu(idSeans);
    }

    @Override
    public IRezerwacja dajRezerwacje(int id) {
        return listaRezerwacja.znajdźRezerwacje(id);
    }

    @Override
    public void dodajSeans(int idSali, int idFilm, String początek) {
        ISeans seans = new Seans(idSali,idFilm,początek);
        dao.dodajSeans(seans);
        listaSeans = dao.aktualizujSeans().weźSeans();
    }

    @Override
    public void usuńSeans(int id) {
        dao.usuńSeans(id);
        listaSeans = dao.aktualizujSeans().weźSeans();
    }

    @Override
    public void edytujSeans(ISeans seans) {
        dao.edytujSeans(seans);
        listaSeans = dao.aktualizujSeans().weźSeans();
    }

    @Override
    public void dodajRezerwacja(int idSeans,  int miejsce, String dataRezerwacji, String nazwiskoKlienta, String telefonKlienta) {
        IRezerwacja rezerwacja = new Rezerwacja(idSeans,miejsce,dataRezerwacji,nazwiskoKlienta,telefonKlienta);
        dao.dodajRezerwacja(rezerwacja);
        listaRezerwacja = dao.aktualizujRezerwacja().weźRezerwacje();
    }

    @Override
    public void usuńRezerwacja(int id) {
        dao.usuńRezerwacja(id);
        listaRezerwacja = dao.aktualizujRezerwacja().weźRezerwacje();
    }

    @Override
    public void edytujRezerwacja(IRezerwacja rezerwacja) {
        dao.edytujRezerwacja(rezerwacja);
        listaRezerwacja = dao.aktualizujRezerwacja().weźRezerwacje();
    }
}
