package pl.buliasz.Instancje;

import pl.buliasz.kontroler.IKontrolerPracownik;
import pl.buliasz.model.IModel;

public class KontrolerPracownikInstance {
    private static final KontrolerPracownikInstance instance = new KontrolerPracownikInstance();

    private IKontrolerPracownik kontroler;

    public static KontrolerPracownikInstance getInstance(){
        return instance;
    }

    public IKontrolerPracownik getModel() {
        return kontroler;
    }

    public void setModel(IKontrolerPracownik kontroler) {
        this.kontroler = kontroler;
    }
}
