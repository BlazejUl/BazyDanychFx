package pl.buliasz.widok;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import pl.buliasz.Instancje.DAOinstance;
import pl.buliasz.Instancje.KontrolerPracownikInstance;
import pl.buliasz.Instancje.ModelInstance;
import pl.buliasz.kontroler.KontrolerPracownik;
import pl.buliasz.model.DAO;
import pl.buliasz.model.IDAO;
import pl.buliasz.model.IModel;
import pl.buliasz.model.Model;

import java.io.IOException;

public class LoginViewController {
    @FXML
    private Node root;
    @FXML
    public TextField name;
    @FXML
    public TextField password;
    @FXML
    public Text blad;
    public IDAO dao;
    public IModel model;

    DAOinstance data = DAOinstance.getInstance();
    ModelInstance modelInstance = ModelInstance.getInstance();
    KontrolerPracownikInstance pracownikInstance = KontrolerPracownikInstance.getInstance();

    @FXML
    protected void onLoginButtonClick() throws IOException {
        String url = "jdbc:mysql://localhost:3306/kino";
        try {
            String name = this.name.getText();
            String password = this.password.getText();
            dao = new DAO(password,name,url);
            dao.tryConnection();
            model = new Model(dao);
            modelInstance.setModel(model);
            data.setDao(dao);
            pracownikInstance.setKontroler(new KontrolerPracownik(model));
            new KontrolerPWindow().open();

            root.getScene().getWindow().hide();
        } catch (Exception e) {
            blad.setText("zły login lub hasło");
        }
    }
}
