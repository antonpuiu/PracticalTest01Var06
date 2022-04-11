package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText nr[];
    CheckBox ck[];
    EditText nr1, nr2, nr3;
    CheckBox ck1, ck2, ck3;
    Button b;
    int scor;
    MainActivity main;

    private class PlayButtonClickListener implements View.OnClickListener {
        private String getNext() {
            Random rand = new Random();
            int next = rand.nextInt() % 4;
            char c;

            if (Math.abs(next) > 2)
                return "*";
            else
                return "" + Math.abs(next);
        }

        @Override
        public void onClick(View v) {
            for (int i = 0; i < 3; i++) {
                if (!ck[i].isChecked()){
                    nr[i].setText(getNext());
                }

                Log.i("INFO","check[" + Integer.toString(i) + "] = " + nr[i].getText());

                Intent intent = new Intent(main, PracticalTest01Var06SecondaryActivity.class);
//                Intent intent = new Intent("ro.pub.cs.systems.eim.practicaltest01var06.intent.action.PracticalTest01Var06SecondaryActivity");

                intent.putExtra(Constants.CHECK1_KEY, ck1.isChecked());
                intent.putExtra(Constants.CHECK2_KEY, ck2.isChecked());
                intent.putExtra(Constants.CHECK3_KEY, ck3.isChecked());

                intent.putExtra(Constants.NR1_KEY, nr1.getText());
                intent.putExtra(Constants.NR2_KEY, nr2.getText());
                intent.putExtra(Constants.NR3_KEY, nr3.getText());

                startActivity(intent);
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nr1 = findViewById(R.id.numar1);
        nr2 = findViewById(R.id.numar2);
        nr3 = findViewById(R.id.numar3);

        ck1 = findViewById(R.id.check1);
        ck2 = findViewById(R.id.check2);
        ck3 = findViewById(R.id.check3);

        b = findViewById(R.id.button);

        nr = new EditText[3];
        ck = new CheckBox[3];

        nr[0] = nr1;
        nr[1] = nr2;
        nr[2] = nr3;

        ck[0] = ck1;
        ck[1] = ck2;
        ck[2] = ck3;

        b.setOnClickListener(new PlayButtonClickListener());
        scor = 0;
        main = this;
    }
}
