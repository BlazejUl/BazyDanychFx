package pl.buliasz.kontroler;

import pl.buliasz.model.IModel;

public class KontrolerPracownik implements IKontrolerPracownik{
    IModel model;

    KontrolerPracownik(IModel model){
        this.model = model;
    }
    @Override
    public void wyszukanieSeansów() {
        WyszukanieSeansów pu01 = new WyszukanieSeansów(model,1);
    }

}
