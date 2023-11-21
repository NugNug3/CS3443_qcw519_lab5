package edu.utsa.cs3443.qcw519_lab5;

import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs3443.qcw519_lab5.model.User;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    User userPass = new User("", "", "", "", "");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupButton(R.id.login);
    }

    public void onClick(View view) {
        //if password check succeeds, launch role or activity here
        String username = setupEditTextUser(R.id.username);
        String passphrase = setupEditTextPass(R.id.passphrase);
        userPass.loadUserInfo(this, username, passphrase);
        if(view.getId() == R.id.login && userPass.validate(username, passphrase)) {
            launchRole();
        }

    }

    public void launchRole() {
        Intent intent = new Intent(this, RoleActivity.class);
        startActivity(intent);
    }

    public void launchAct() {
        Intent intent = new Intent(this, ActActivity.class);
        startActivity(intent);
    }

    public void setupButton(int id) {
        Button button = findViewById(id);
        button.setOnClickListener(this);
    }

    public String setupEditTextUser(int id) {
        EditText editText = (EditText)findViewById(id);
        return editText.getText().toString();
    }

    public String setupEditTextPass(int id) {
        EditText editText = (EditText)findViewById(id);
        return editText.getText().toString();
    }
}