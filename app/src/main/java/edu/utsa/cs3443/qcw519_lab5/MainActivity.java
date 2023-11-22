package edu.utsa.cs3443.qcw519_lab5;

import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs3443.qcw519_lab5.model.User;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    User userPass = new User("", "", "");
    public static final String roleKey = "ROLE";
    public static final String bundle1 = "BUNDLE";
    public final static String realNameKey = "REALNAME";
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
        else {
            Toast.makeText(view.getContext(), "Incorrect username or passphrase", Toast.LENGTH_LONG).show();
        }
        wipe(R.id.username, R.id.passphrase);
    }

    public void launchRole() {
        Intent intent = new Intent(this, RoleActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(realNameKey, userPass.getRealName());
        bundle.putSerializable(roleKey, (Serializable)userPass.getRole());
        intent.putExtra(bundle1, bundle);
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

    public void wipe(int buttonId, int buttonId2) {
        EditText editText = findViewById(buttonId);
        EditText editText1 = findViewById(buttonId2);
        editText.getText().clear();
        editText1.getText().clear();
    }
}