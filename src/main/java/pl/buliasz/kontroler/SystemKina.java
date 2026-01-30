package pl.buliasz.kontroler;

import pl.buliasz.model.DAO;
import pl.buliasz.model.IDAO;
import pl.buliasz.model.IModel;
import pl.buliasz.model.Model;

public class SystemKina {
    public static void main(String[] args) {
        IDAO dao = new DAO("KierownikPass1!","kierownik","jdbc:mysql://localhost:3306/kino");
        IModel model = new Model(dao);
        KontrolerPracownik kontrolerPracownik = new KontrolerPracownik(model);
        KontrolerKierownik kontrolerKierownik = new KontrolerKierownik(model);
        //kontrolerKierownik.stworzenieNowegoSeansu();
        //kontrolerKierownik.modyfikacjaDanychSeansu();
        kontrolerKierownik.usunięcieSeansu();

        kontrolerPracownik.wyszukanieSeansów();
    }
}