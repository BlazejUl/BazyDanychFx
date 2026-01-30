package pl.buliasz.kontroler;

import pl.buliasz.model.IModel;

public class UsunięcieSeansu {
    IModel model;
    int id_seans;

    UsunięcieSeansu(IModel model, int id_seans){
        this.model = model;
        this.id_seans = id_seans;
        this.model.usuńSeans(this.id_seans);
    }
}
