package pl.buliasz.kontroler;

import pl.buliasz.model.IModel;
import pl.buliasz.model.IRezerwacja;
import pl.buliasz.model.ISeans;

import java.util.List;

public class KontrolerPracownik implements IKontrolerPracownik{
    IModel model;

    KontrolerPracownik(IModel model){
        this.model = model;
    }
    @Override
    public List<ISeans> wyszukanieSeansów(Integer filmID) {
        return new WyszukanieSeansów(model,filmID).dajSeanse();
    }

    @Override
    public void rezerwacjaMiejsca(){new RezerwacjaMiejsca(model);}

    @Override
    public List<IRezerwacja> wyszukajRezerwację(Integer filmID){
        return new WyświetlRezerwacje(model,filmID).dajRezerwacje();
    }

    @Override
    public IRezerwacja dajRezerwacje(Integer id){
        return model.dajRezerwacje(id);
    }

    @Override
    public ISeans dajSeans(Integer seansID){
        return model.dajSeans(seansID);
    }

    @Override
    public void modyfikacjaRezerwacji(Integer id,Integer miejsce,String nazwisko,String telefon){
        new ModyfikacjaRezerwacji(model, id,miejsce, nazwisko, telefon);
    }

    @Override
    public void usunięcieRezerwacji(Integer rezerwacjaID){new UsunięcieRezerwacji(model,rezerwacjaID);}



}
