package pl.buliasz.kontroler;

import pl.buliasz.model.IModel;

public class KontrolerKierownik implements IKontrolerKierownik{
    IModel model;

    KontrolerKierownik(IModel model){
        this.model = model;
    }
    @Override
    public void modyfikacjaDanychSeansu(Integer seansId,Integer salaId,Integer filmId, String początek,String koniec,Boolean nap,Boolean dub,Boolean w3d) {
        new ModyfikacjaDanychSeansu(model, seansId, salaId, filmId, początek, koniec, nap, dub, w3d);
    }

    @Override
    public void stworzenieNowegoSeansu(int idSali, int idFilm, String początek) {
        new StworzenieNowegoSeansu(model, idSali, idFilm, początek);
    }

    @Override
    public void usunięcieSeansu(Integer seansID) {
        new UsunięcieSeansu(model,seansID);
    }

}
