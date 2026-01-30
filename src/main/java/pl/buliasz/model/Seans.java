package pl.buliasz.model;

public class Seans implements ISeans{
    Integer id;
    int idSali;
    int idFilm;
    String początek;
    String koniec;
    Boolean napisy;
    Boolean dubbing;
    Boolean wersja3D;

    public Seans(int id, int idSali, int idFilm, String początek, String koniec, Boolean napisy, Boolean dubbing, Boolean wersja3D) {
        this.id = id;
        this.idSali = idSali;
        this.idFilm = idFilm;
        this.początek = początek;
        this.koniec = koniec;
        this.napisy = napisy;
        this.dubbing = dubbing;
        this.wersja3D = wersja3D;
    }

    public Seans(int idSali, int idFilm, String początek) {
        this.id = null;
        this.idSali = idSali;
        this.idFilm = idFilm;
        this.początek = początek;
        this.koniec = null;
        this.napisy = null;
        this.dubbing = null;
        this.wersja3D = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSali() {
        return idSali;
    }

    public void setIdSali(int idSali) {
        this.idSali = idSali;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getPoczątek() {
        return początek;
    }

    public void setPoczątek(String początek) {
        this.początek = początek;
    }

    public String getKoniec() {
        return koniec;
    }

    public void setKoniec(String koniec) {
        this.koniec = koniec;
    }

    public Boolean getNapisy() {
        return napisy;
    }

    public void setNapisy(Boolean napisy) {
        this.napisy = napisy;
    }

    public Boolean getDubbing() {
        return dubbing;
    }

    public void setDubbing(Boolean dubbing) {
        this.dubbing = dubbing;
    }

    public Boolean getWersja3D() {
        return wersja3D;
    }

    public void setWersja3D(Boolean wersja3D) {
        this.wersja3D = wersja3D;
    }
}
