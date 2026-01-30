package pl.buliasz.kontroler;

import pl.buliasz.model.IModel;
import pl.buliasz.model.ISeans;

public class StworzenieNowegoSeansu {
    IModel model;
    int idSali;
    int idFilm;
    String początek;
    int wybórOpcji;
    ISeans seans;

    StworzenieNowegoSeansu(IModel model){
        this.model = model;
        podanieDanych(2,2,"2024-08-04 15:20:00");
        this.model.dodajSeans(idSali,idFilm,początek);
        seans = this.model.dajWszystkieSeanse().getLast();
        wyświetl(seans);
        wybórOpcji(1);
        if(wybórOpcji!=1) new ModyfikacjaDanychSeansu(this.model,seans.getId());
    }

    public void podanieDanych(int idSali, int idFilm, String początek){
        this.idSali = idSali;
        this.idFilm = idFilm;
        this.początek = początek;
    }

    public void wyświetl(ISeans seans){
        String seansStr = seans.getId()+" "+seans.getIdSali()+" "+seans.getIdFilm()+" "+
                seans.getPoczątek()+" "+seans.getKoniec()+" "+seans.getNapisy()+" "+
                seans.getDubbing()+" "+seans.getWersja3D();
        System.out.println(seansStr);
    }
    public void wybórOpcji(int opcja){
        this.wybórOpcji = opcja;
    }
}
