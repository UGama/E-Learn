package com.example.e_learn;

import org.litepal.crud.DataSupport;

/**
 * Created by Gama on 27/3/17.
 */

public class School extends DataSupport {
    private int id;
    private String Scene;
    private String EScene;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public School(String Scene, String EScene) {
        this.Scene = Scene;
        this.EScene = EScene;
    }

    public String getScene() {
        return Scene;
    }
    public void setScene(String scene) {
        this.Scene = scene;
    }



    public void setEScene(String EScene) {
        this.EScene = EScene;
    }
    public String getEScene() {
        return EScene;
    }
}


