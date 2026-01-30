package pl.buliasz.Instancje;

import pl.buliasz.model.IDAO;
import pl.buliasz.model.IModel;
import pl.buliasz.model.Model;

public class ModelInstance {
    private static final ModelInstance instance = new ModelInstance();

    private IModel model;

    public static ModelInstance getInstance(){
        return instance;
    }

    public IModel getModel() {
        return model;
    }

    public void setModel(IModel model) {
        this.model = model;
    }
}
