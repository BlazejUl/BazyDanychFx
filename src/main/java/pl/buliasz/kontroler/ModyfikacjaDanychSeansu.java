package pl.buliasz.kontroler;

import pl.buliasz.model.IModel;
import pl.buliasz.model.ISeans;

public class ModyfikacjaDanychSeansu {
    IModel model;
    int id_seansu;
    ISeans seans;

    ModyfikacjaDanychSeansu(IModel model, int id_seansu){
        this.model = model;
        this.id_seansu = id_seansu;
        seans = model.dajSeans(this.id_seansu);
        modyfikacjaSeansu();
        model.edytujSeans(seans);
    }

    public void modyfikacjaSeansu(){
        seans.setIdSali(seans.getIdSali());
        seans.setIdFilm(seans.getIdFilm());
        seans.setPoczątek(seans.getPoczątek());
        seans.setKoniec(seans.getKoniec());
        seans.setNapisy(seans.getNapisy());
        seans.setDubbing(seans.getDubbing());
        seans.setWersja3D(seans.getWersja3D());
    }
}
