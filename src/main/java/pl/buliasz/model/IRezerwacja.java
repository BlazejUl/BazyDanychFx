package pl.buliasz.model;

public interface IRezerwacja {

    String getDataRezerwacji();

    void setDataRezerwacji(String dataRezerwacji);

    int getId();

    void setId(int id);

    int getIdSeans();

    void setIdSeans(int idSeans);

    int getMiejsce();

    void setMiejsce(int miejsce);

    String getNazwiskoKlienta();

    void setNazwiskoKlienta(String nazwiskoKlienta);

    String getTelefonKlienta();

    void setTelefonKlienta(String telefonKlienta);
}
