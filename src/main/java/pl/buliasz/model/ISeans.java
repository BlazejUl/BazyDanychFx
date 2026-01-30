package pl.buliasz.model;

public interface ISeans {
    int getId();

    void setId(int id);

    int getIdSali();

    void setIdSali(int idSali);

    int getIdFilm();

    void setIdFilm(int idFilm);

    String getPoczątek();

    void setPoczątek(String początek);

    String getKoniec();

    void setKoniec(String koniec);

    Boolean getNapisy();

    void setNapisy(Boolean napisy);

    Boolean getDubbing();

    void setDubbing(Boolean dubbing);

    Boolean getWersja3D();

    void setWersja3D(Boolean wersja3D);
}
