package pl.buliasz.kontroler;

import pl.buliasz.model.IModel;
import pl.buliasz.model.ISeans;

public class StworzenieNowegoSeansu {
    IModel model;
    int idSali;
    int idFilm;
    String początek;

    StworzenieNowegoSeansu(IModel model,int idSali, int idFilm, String początek){
        this.model = model;
        podanieDanych(idSali, idFilm, początek);
        stwórz();
    }

    public void podanieDanych(int idSali, int idFilm, String początek){
        this.idSali = idSali;
        this.idFilm = idFilm;
        this.początek = początek;
    }
    public void stwórz(){
        this.model.dodajSeans(idSali,idFilm,początek);
    }
}
