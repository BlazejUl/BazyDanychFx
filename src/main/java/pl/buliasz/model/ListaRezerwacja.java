package pl.buliasz.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaRezerwacja {
    List<IRezerwacja> listaRezerwacja;

    ListaRezerwacja(List<IRezerwacja> listaRezerwacja){
        this.listaRezerwacja = listaRezerwacja;
    }

    List<IRezerwacja> weźWszystko(){
        return listaRezerwacja;
    }

    List<IRezerwacja> weźPoIdSeansu(int idSeans){
        List<IRezerwacja> out = new ArrayList<>();
        for(IRezerwacja rezerwacja:listaRezerwacja){
            if (rezerwacja.getIdSeans()==idSeans) out.add(rezerwacja);
        }
        return out;
    }
    IRezerwacja znajdźRezerwacje(int id){
        for (IRezerwacja rezerwacja:listaRezerwacja){
            if (rezerwacja.getId()==id) return rezerwacja;
        }
        return null;
    }
}
