package pl.buliasz.kontroler;

import pl.buliasz.model.IModel;

public class KontrolerKierownik implements IKontrolerKierownik{
    IModel model;

    KontrolerKierownik(IModel model){
        this.model = model;
    }
    @Override
    public void modyfikacjaDanychSeansu() {
        ModyfikacjaDanychSeansu pu06 = new ModyfikacjaDanychSeansu(model,9);
    }

    @Override
    public void stworzenieNowegoSeansu() {
        StworzenieNowegoSeansu pu07 = new StworzenieNowegoSeansu(model);
    }

    @Override
    public void usunięcieSeansu() {
        UsunięcieSeansu pu05 = new UsunięcieSeansu(model,9);
    }

}
