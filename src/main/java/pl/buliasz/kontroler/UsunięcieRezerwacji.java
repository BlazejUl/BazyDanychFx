package pl.buliasz.kontroler;

import pl.buliasz.model.IModel;

public class UsunięcieRezerwacji {
    IModel model;
    int id;

    UsunięcieRezerwacji(IModel model, int id){
        this.model = model;
        this.id = id;
        this.model.usuńRezerwacja(id);
    }
}
