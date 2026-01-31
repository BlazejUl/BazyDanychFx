package pl.buliasz.kontroler;

import pl.buliasz.model.IModel;
import pl.buliasz.model.IRezerwacja;
import pl.buliasz.model.ISeans;

import java.util.ArrayList;
import java.util.List;

public class WyświetlRezerwacje {
    IModel model;
    int id_seansu;
    List<IRezerwacja> rezerwacje;

    WyświetlRezerwacje(IModel model, int id_seansu){
        this.model = model;
        this.id_seansu = id_seansu;
        rezerwacje = this.model.dajWszystkieRezerwacjePoIdSeansu(this.id_seansu);
    }

    public List<IRezerwacja> dajRezerwacje(){
        return rezerwacje;
    }

}
