package pl.buliasz.model;

public class Rezerwacja implements IRezerwacja{
    String dataRezerwacji;
    Integer id;
    int idSeans;
    int miejsce;
    String nazwiskoKlienta;
    String telefonKlienta;

    public Rezerwacja(Integer id, int idSeans,  int miejsce, String dataRezerwacji, String nazwiskoKlienta, String telefonKlienta) {
        this.dataRezerwacji = dataRezerwacji;
        this.id = id;
        this.idSeans = idSeans;
        this.nazwiskoKlienta = nazwiskoKlienta;
        this.miejsce = miejsce;
        this.telefonKlienta = telefonKlienta;
    }

    public Rezerwacja(int idSeans,  int miejsce, String dataRezerwacji, String nazwiskoKlienta, String telefonKlienta) {
        this.dataRezerwacji = dataRezerwacji;
        this.id = null;
        this.idSeans = idSeans;
        this.nazwiskoKlienta = nazwiskoKlienta;
        this.miejsce = miejsce;
        this.telefonKlienta = telefonKlienta;
    }

    public String getDataRezerwacji() {
        return dataRezerwacji;
    }

    public void setDataRezerwacji(String dataRezerwacji) {
        this.dataRezerwacji = dataRezerwacji;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSeans() {
        return idSeans;
    }

    public void setIdSeans(int idSeans) {
        this.idSeans = idSeans;
    }

    public int getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(int miejsce) {
        this.miejsce = miejsce;
    }

    public String getNazwiskoKlienta() {
        return nazwiskoKlienta;
    }

    public void setNazwiskoKlienta(String nazwiskoKlienta) {
        this.nazwiskoKlienta = nazwiskoKlienta;
    }

    public String getTelefonKlienta() {
        return telefonKlienta;
    }

    public void setTelefonKlienta(String telefonKlienta) {
        this.telefonKlienta = telefonKlienta;
    }
}
