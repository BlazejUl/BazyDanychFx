package pl.buliasz.kontroler;

import pl.buliasz.model.IModel;
import pl.buliasz.model.ISeans;

import java.util.ArrayList;
import java.util.List;

public class WyszukanieSeansów {
    private IModel model;
    private int wybórOpcji;
    private int idSeansu;
    private int idRezerwacji;
    private int miejsce;
    private String dataRezerwacji;
    private String nazwiskoKlienta;
    private String telefonKlienta;


    WyszukanieSeansów(IModel model,int id_filmu){
        this.model = model;
        wyświetlSeanse(szukajSeansów(id_filmu));
        wybórOpcji();
        if(wybórOpcji!=1){
            podajIdSeansu();
            new WyświetlRezerwacje(model,idSeansu);
            if(wybórOpcji==2){
                podajDaneRezerwacji(11,"2025-06-20 10:23:30","Kowal","099782120");
                RezerwacjaMiejsca pu02 = new RezerwacjaMiejsca(model);
                pu02.podanieDanychRezerwacji(idSeansu, miejsce, dataRezerwacji,
                         nazwiskoKlienta, telefonKlienta);
                pu02.zarezerwowanieMiejsca();
            }else if(wybórOpcji==3){
                podajIdRezerwacji();
                ModyfikacjaRezerwacji pu04 = new ModyfikacjaRezerwacji(model,idRezerwacji);
            }else if(wybórOpcji==4){
                podajIdRezerwacji();
                UsunięcieRezerwacji pu03 = new  UsunięcieRezerwacji(model,idRezerwacji);
            }
        }
    }

    public List<ISeans> szukajSeansów(int id_filmu){
        List<ISeans> wszystko;
        List<ISeans> odp = new ArrayList<>();
        wszystko = model.dajWszystkieSeanse();
        for(ISeans seans:wszystko){
            if (seans.getIdFilm()==id_filmu) odp.add(seans);
        }
        return odp;
    }

    public void podajDaneRezerwacji(int miejsce,String dataRezerwacji,
                                    String nazwiskoKlienta,String telefonKlienta){
        this.miejsce=miejsce;
        this.dataRezerwacji=dataRezerwacji;
        this.nazwiskoKlienta=nazwiskoKlienta;
        this.telefonKlienta=telefonKlienta;
    }

    public void wybórOpcji(){
        wybórOpcji = 5;
    }

    public void podajIdSeansu(){
        idSeansu = 2;
    }

    public void podajIdRezerwacji(){
        idRezerwacji=7;
    }

    public List<String> wyświetlSeanse(List<ISeans> seanse){
        List<String> out = new ArrayList<>();
        for (ISeans seans:seanse){
            String seansStr = seans.getId()+" "+seans.getIdSali()+" "+seans.getIdFilm()+" "+
                    seans.getPoczątek()+" "+seans.getKoniec()+" "+seans.getNapisy()+" "+
                    seans.getDubbing()+" "+seans.getWersja3D();
            out.add(seansStr);
            System.out.println(seansStr);
        }
        return out;
    }
}
