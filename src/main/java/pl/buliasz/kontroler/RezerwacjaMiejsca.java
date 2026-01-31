package pl.buliasz.kontroler;

import pl.buliasz.model.IModel;

public class RezerwacjaMiejsca {
    private IModel model;
    private int idSeans;
    private int miejsce;
    private String dataRezerwacji;
    private String nazwiskoKlienta;
    private String telefonKlienta;

    RezerwacjaMiejsca(IModel model){
        this.model = model;
    }

    public void podanieDanychRezerwacji(int idSeans,int miejsce,String dataRezerwacji,
                                        String nazwiskoKlienta,String telefonKlienta){
        this.idSeans = idSeans;
        this.miejsce = miejsce;
        this.dataRezerwacji = dataRezerwacji;
        this.telefonKlienta = telefonKlienta;
        this.nazwiskoKlienta  =nazwiskoKlienta;
    }

    public void zarezerwowanieMiejsca(){
        model.dodajRezerwacja(idSeans, miejsce, dataRezerwacji,
                nazwiskoKlienta, telefonKlienta);
    }
}
