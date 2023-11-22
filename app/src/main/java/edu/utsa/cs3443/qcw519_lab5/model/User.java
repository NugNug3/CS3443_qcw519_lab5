package edu.utsa.cs3443.qcw519_lab5.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class User implements java.io.Serializable{
    String username;
    String password;
    String realName;
    ArrayList<Role> role;

    public User(String username, String password, String realName) {
        this.username = username;
        this.password = password;
        this.realName = realName;
        role = new ArrayList<>();
    }
    public void loadUserInfo(Context context, String username, String password) {
        //break up cvs strings here and put into attributes
        AssetManager asset = context.getAssets();

        try {
            InputStream is = asset.open("users.csv");
            Scanner scan = new Scanner(is);

            while(scan.hasNextLine()) {
                String line = scan.nextLine();
                if(line.contains(username) && line.contains(password)) {
                    String[] token = line.split(",");
                    setUsername(token[0]);
                    setPassword(token[1]);
                    setRealName(token[2]);
                    for(int i = 3; i < token.length; i++) {
                        role.add(new Role(token[i]));
                    }
                    break;
                }
            }
        } catch(IOException e) {
            System.out.println("Failed to load user database.");
        }
    }

    public boolean validate(String username, String passphrase) {
        if(Objects.equals(getUsername(), username) && Objects.equals(getPassword(), passphrase)) {
            return true;
        }
        else {
            return false;
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setRole(ArrayList role) {
        this.role = role;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getRealName() {
        return this.realName;
    }

    public ArrayList<Role> getRole() {
        return this.role;
    }

}
