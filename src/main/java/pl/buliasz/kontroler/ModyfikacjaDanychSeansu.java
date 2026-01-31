package pl.buliasz.kontroler;

import pl.buliasz.model.IModel;
import pl.buliasz.model.ISeans;

public class ModyfikacjaDanychSeansu {
    IModel model;
    int id_seansu;
    ISeans seans;

    ModyfikacjaDanychSeansu(IModel model, int id_seansu,Integer salaId,Integer filmId, String początek,String koniec,Boolean nap,Boolean dub,Boolean w3d){
        this.model = model;
        this.id_seansu = id_seansu;
        seans = model.dajSeans(this.id_seansu);
        modyfikacjaSeansu(salaId, filmId, początek, koniec, nap, dub, w3d);
        modyfikuj();
    }

    public void modyfikacjaSeansu(Integer salaId,Integer filmId, String początek,String koniec,Boolean nap,Boolean dub,Boolean w3d){
        seans.setIdSali(salaId);
        seans.setIdFilm(filmId);
        seans.setPoczątek(początek);
        seans.setKoniec(koniec);
        seans.setNapisy(nap);
        seans.setDubbing(dub);
        seans.setWersja3D(w3d);
    }
    public void modyfikuj(){
        model.edytujSeans(seans);
    }
}
