package pl.buliasz.kontroler;

public interface IKontrolerKierownik {

    void modyfikacjaDanychSeansu(Integer seansId,Integer salaId,Integer filmId, String początek,String koniec,Boolean nap,Boolean dub,Boolean w3d);

    void stworzenieNowegoSeansu(int idSali, int idFilm, String początek);

    void usunięcieSeansu(Integer seansID);

}
