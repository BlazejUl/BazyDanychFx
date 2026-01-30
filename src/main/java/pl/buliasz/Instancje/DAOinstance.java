package pl.buliasz.Instancje;

import pl.buliasz.model.IDAO;

public class DAOinstance {
    private static final DAOinstance instance = new DAOinstance();

    private IDAO dao;

    public static DAOinstance getInstance(){
        return instance;
    }

    public IDAO getDao() {
        return dao;
    }

    public void setDao(IDAO dao) {
        this.dao = dao;
    }
}
