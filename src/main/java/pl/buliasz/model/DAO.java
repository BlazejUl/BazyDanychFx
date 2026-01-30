package pl.buliasz.model;

import java.sql.*;

public class DAO implements IDAO{
    private String password;
    private String username;
    private String url;

    public DAO(String password, String username, String url) {
        this.password = password;
        this.username = username;
        this.url = url;
    }

    @Override
    public IFabrykaSeans aktualizujSeans() {
        return new FabrykaSeans(getConnection("select * from seans"));
    }

    @Override
    public IFabrykaRezerwacja aktualizujRezerwacja(){
        return new FabrykaRezerwacja(getConnection("select * from rezerwacja"));

    }

    @Override
    public void dodajSeans(ISeans seans) {
        String sql = String.format("call dodaj_seans(%s,%s,'%s')",seans.getIdSali(),
                seans.getIdFilm(),seans.getPoczątek());
        voidConnection(sql);
    }

    @Override
    public void usuńSeans(int id) {
        String sql =
                String.format("delete from seans where id=%s",id);

        voidConnection(sql);
    }

    @Override
    public void edytujSeans(ISeans seans) {
        int napisy,dubbing,wersja_3D;
        if (seans.getNapisy()){
            napisy = 1;
        }else {napisy = 0;}
        if (seans.getDubbing()){
            dubbing = 1;
        }else {dubbing = 0;}
        if (seans.getWersja3D()){
            wersja_3D = 1;
        }else {wersja_3D = 0;}
        String sql =
                String.format("update seans set id_sali='%s',id_film='%s',początek='%s',koniec='%s',napisy='%s',dubbing='%s',wersja_3D='%s' where id=%s",
                seans.getIdSali(), seans.getIdFilm(),seans.getPoczątek(),
                seans.getKoniec(),napisy,
                dubbing,wersja_3D,seans.getId());
        voidConnection(sql);
    }

    @Override
    public void dodajRezerwacja(IRezerwacja rezerwacja) {
        String sql = String.format("insert into rezerwacja (id_seans, miejsce, data_rezerwacji, nazwisko_klienta, telefon_klienta) values(%s,%s,'%s','%s','%s')",
                rezerwacja.getIdSeans(), rezerwacja.getMiejsce(),rezerwacja.getDataRezerwacji(),
                rezerwacja.getNazwiskoKlienta(),rezerwacja.getTelefonKlienta());
        voidConnection(sql);
    }

    @Override
    public void usuńRezerwacja(int id) {
        String sql =
                String.format("delete from rezerwacja where id=%s",id);

        voidConnection(sql);
    }

    @Override
    public void edytujRezerwacja(IRezerwacja rezerwacja) {
        String sql = String.format("update rezerwacja set id_seans='%s',miejsce='%s',data_rezerwacji='%s',nazwisko_klienta='%s',telefon_klienta='%s' where id=%s",rezerwacja.getIdSeans(),
                rezerwacja.getMiejsce(),rezerwacja.getDataRezerwacji(), rezerwacja.getNazwiskoKlienta(),
                rezerwacja.getTelefonKlienta(), rezerwacja.getId());
        voidConnection(sql);
    }

    @Override
    public ResultSet getConnection(String sql) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);

            Statement statement=connection.createStatement();

            return statement.executeQuery(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void voidConnection(String sql) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url,username,password);

            Statement statement=connection.createStatement();
            statement.executeUpdate(sql);
            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void tryConnection() throws SQLException {
        DriverManager.getConnection(url,username,password).close();
    }

    @Override
    public String dajUsername() {
        return username;
    }
}
