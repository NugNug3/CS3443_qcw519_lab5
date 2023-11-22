package edu.utsa.cs3443.qcw519_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import edu.utsa.cs3443.qcw519_lab5.model.Role;
import edu.utsa.cs3443.qcw519_lab5.model.User;

public class RoleActivity extends AppCompatActivity implements View.OnClickListener{
    public static final String roleKey = "ROLE";
    public static final String bundle1 = "BUNDLE";
    public static final String realNameKey = "REALNAME";
    ArrayList<Role> role;
    String realName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(bundle1);

        role = (ArrayList<Role>) bundle.getSerializable(roleKey);
        realName = bundle.getString(realNameKey);

        setupName(realName, R.id.realName);
        setupRole(role, R.id.roles);

        int[] button = {R.id.act1, R.id.act2, R.id.logout};

        for(int i = 0; i < button.length; i++) {
            setupButton(button[i]);
        }

    }

    public void onClick(View view) {
        if(view.getId() == R.id.act1) {

        }
        else if(view.getId() == R.id.act2) {

        }
        else if(view.getId() == R.id.logout) {
            super.finish();
        }
    }

    public void setupButton(int buttonId) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(this);
    }

    public void setupName(String realName, int buttonId) {
        TextView textView = findViewById(buttonId);
        textView.setText(realName);
    }

    public void setupRole(ArrayList<Role> role, int buttonId) {
        TextView textView = findViewById(buttonId);
        String finalString = "";
        int val = 0;

        while(role.size() > val) {
            finalString += role.get(val).getName() + "\n";
            val++;
        }
        textView.setText(finalString);
    }
}