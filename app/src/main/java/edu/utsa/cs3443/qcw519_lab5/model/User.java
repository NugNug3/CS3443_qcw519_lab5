package edu.utsa.cs3443.qcw519_lab5.model;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class User {
    String username;
    String password;
    String realName;
    String role1;
    String role2;

    public User(String username, String password, String realName, String role1, String role2) {
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.role1 = role1;
        this.role2 = role2;
    }
    public void loadUserInfo(Context context, String username, String password) {
        //break up cvs strings here and put into attributes
        AssetManager asset = context.getAssets();

        try {
            InputStream is = asset.open("users.csv");
            Scanner scan = new Scanner(is);

            while(scan.hasNextLine()) {
                if(scan.findInLine(username) != null && scan.findInLine(password) != null) {
                    String line = scan.nextLine();
                    String[] token = line.split(",");


                }

            }
        } catch(IOException e) {
            System.out.println("Failed to load user database.");
        }
    }

    public boolean validate(String username, String passphrase) {
        return true;
    }
}
