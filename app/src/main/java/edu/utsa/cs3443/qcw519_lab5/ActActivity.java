package edu.utsa.cs3443.qcw519_lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import edu.utsa.cs3443.qcw519_lab5.model.Act;
import edu.utsa.cs3443.qcw519_lab5.model.Role;
import edu.utsa.cs3443.qcw519_lab5.model.Scene;

public class ActActivity extends AppCompatActivity {

    public static final String roleKey = "ROLE";
    public static final String bundle1 = "BUNDLE";
    public static final String actKey = "ACT";

    ArrayList<Role> r1;
    int actVal;

    String returnString = "";
    Act act;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(bundle1);
        r1 = (ArrayList<Role>) bundle.getSerializable(roleKey);
        actVal = bundle.getInt(actKey);

        act = new Act(actVal);
        act.loadScenes(this);

        setupActText(actVal, r1);

        int actLoop = 0;
        int roleLoop = 0;
        if(actVal == 1 && !r1.isEmpty()) {
            //do act 1 stuff
            while(r1.size() > roleLoop) {
                String finalString1 = r1.get(roleLoop).getName().substring(r1.get(roleLoop).getName().indexOf("(") + 1, r1.get(roleLoop).getName().indexOf(")"));
                while(act.getTotalScene().size() > actLoop) {
                    if(act.getTotalScene().get(actLoop).getScene().contains(finalString1)) {
                        returnString += act.getTotalScene().get(actLoop).getScene() + "\n";
                    }
                    actLoop++;
                }
                roleLoop++;
            }

            if(returnString == "") {
                returnString = "No scenes";
            }
            setupTextView(returnString);
        }

        else if(actVal == 2 && !r1.isEmpty()) {
            //do act 2 stuff
            while(r1.size() > roleLoop) {
                String finalString2 = r1.get(roleLoop).getName().substring(r1.get(roleLoop).getName().indexOf("(") + 1, r1.get(roleLoop).getName().indexOf(")"));
                while(act.getTotalScene().size() > actLoop) {
                    if(act.getTotalScene().get(actLoop).getScene().contains(finalString2)) {
                        returnString += act.getTotalScene().get(actLoop).getScene() + "\n";
                    }
                    actLoop++;
                }
                roleLoop++;
            }
            if(returnString == "") {
                returnString = "No scenes";
            }

            setupTextView(returnString);
        }

        else {
            returnString = "No scenes";
            setupTextView(returnString);
        }

    }

    public void setupTextView(String returnString) {
        TextView textView = findViewById(R.id.realAct);
        textView.setText(returnString);
    }

    public void setupActText(int actVal, ArrayList<Role> r1) {
        TextView textView = findViewById(R.id.act);
        if(r1.isEmpty()) {
           textView.setText("Act " + actVal + ":\n");
        }
        if(actVal == 1) {
            textView.setText("Act " + actVal + ":\n");
        }
        else if(actVal == 2) {
            textView.setText("Act " + actVal + ":\n");
        }
    }
}