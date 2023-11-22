package edu.utsa.cs3443.qcw519_lab5.model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Act {
    ArrayList<Scene> totalScene;
    int actNum;

    public Act(int actNum) {
        this.actNum = actNum;
        totalScene = new ArrayList<>();
    }

    public void loadScenes(Context context) {
        AssetManager asset = context.getAssets();

        if(getActNum() == 1) {
            //open act1 and parse text file into scene arraylist
            try {
                InputStream is = asset.open("act1.txt");
                Scanner scan = new Scanner(is);
                String line = "";
                while(scan.hasNextLine()) {
                    line = scan.nextLine();
                    totalScene.add(new Scene(line));
                }
            } catch (IOException e) {
                System.out.println("Failed to read the file");
            }
        }

        else if(getActNum() == 2) {
            //open act2 and parse text file into scene arraylist
            try {
                InputStream is2 = asset.open("act2.txt");
                Scanner scan = new Scanner(is2);
                String line2 = "";
                while (scan.hasNextLine()) {
                    line2 = scan.nextLine();
                    totalScene.add(new Scene(line2));
                }
            } catch (IOException e) {
                    System.out.println("Failed to read the file");
                }
            }
        }

    public void setActNum(int actNum) {
        this.actNum = actNum;
    }

    public void setTotalScene(ArrayList<Scene> scene) {
        this.totalScene = scene;
    }

    public int getActNum() {
        return this.actNum;
    }

    public ArrayList<Scene> getTotalScene() {
        return this.totalScene;
    }
}
