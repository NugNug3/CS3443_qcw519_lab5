package edu.utsa.cs3443.qcw519_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        //if password check succeeds, launch role or activity here
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
}