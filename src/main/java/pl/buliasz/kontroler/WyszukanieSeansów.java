package pl.buliasz.kontroler;

import pl.buliasz.model.IModel;
import pl.buliasz.model.ISeans;

import java.util.ArrayList;
import java.util.List;

public class WyszukanieSeansów {
    private IModel model;
    private Integer filmID;
    private List<ISeans> wyszukaneSeanse;


    WyszukanieSeansów(IModel model,Integer filmID){
        this.model = model;
        this.filmID = filmID;
        szukajSeansów();
    }

    public void szukajSeansów(){
        List<ISeans> wszystko;
        List<ISeans> odp = new ArrayList<>();
        wszystko = model.dajWszystkieSeanse();
        wyszukaneSeanse = wszystko;
        if(filmID!=null){
            for(ISeans seans:wszystko){
                if (seans.getIdFilm()==filmID) odp.add(seans);
            }
            wyszukaneSeanse = odp;

        }

    }

    public List<ISeans> dajSeanse(){
        return wyszukaneSeanse;
    }
}
