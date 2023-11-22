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

    ArrayList<Scene> s1, finalScene;
    ArrayList<Role> r1;
    int actVal;

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
        finalScene = new ArrayList<>();

        setupActText(actVal);

        int actLoop = 0;
        int roleLoop = 0;

        if(actVal == 1) {
            //do act 1 stuff
            while(r1.size() > roleLoop) {
                String finalString = r1.get(roleLoop).getName().substring(r1.get(roleLoop).getName().indexOf("(") + 1, r1.get(roleLoop).getName().indexOf(")"));
                Toast.makeText(this, finalString, Toast.LENGTH_SHORT).show();
                while(act.getTotalScene().size() > actLoop) {
                    if(act.getTotalScene().get(actLoop).getScene().contains(finalString)) {
                        Toast.makeText(this, "made it here!", Toast.LENGTH_SHORT).show();
                        finalScene.add(new Scene(act.getTotalScene().get(actLoop).getScene()));
                    }
                    actLoop++;
                }
                roleLoop++;
            }
            setupTextView(finalScene);
        }

        else if(actVal == 2) {
            //do act 2 stuff
            while(r1.size() > roleLoop) {
                String finalString = r1.get(roleLoop).getName().substring(r1.get(roleLoop).getName().indexOf("(") + 1, r1.get(roleLoop).getName().indexOf(")"));
                Toast.makeText(this, finalString, Toast.LENGTH_SHORT).show();
                while(act.getTotalScene().size() > actLoop) {
                    if(act.getTotalScene().get(actLoop).getScene().contains(finalString)) {
                        finalScene.add(new Scene(act.getTotalScene().get(actLoop).getScene()));
                    }
                    actLoop++;
                }
                roleLoop++;
            }

            setupTextView(finalScene);
        }

        else {
            setupTextView(finalScene);
        }

    }

    public void setupTextView(ArrayList<Scene> finalScene) {
        TextView textView = findViewById(R.id.realAct);
        if(finalScene.isEmpty()) {
            textView.setText("No acts");
        }

        else {
            int val = 0;
            String finalString = "";
            while(finalScene.size() > val) {
                finalString += finalScene.get(val).getScene() + "\n";
            }
            textView.setText(finalString);
        }
    }

    public void setupActText(int actVal) {
        TextView textView = findViewById(R.id.act);
        if(actVal == 1) {
            textView.setText("Act" + actVal + ":\n");
        }
        else if(actVal == 2) {
            textView.setText("Act" + actVal + ":\n");
        }
    }
}