package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class PracticalTest01Var06SecondaryActivity extends AppCompatActivity {
    private int getScore(int no_checked) {
        if (no_checked == 0)
            return 100;
        if (no_checked == 1)
            return 50;
        if (no_checked == 2)
            return 10;

        return 0;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        boolean gained = true;
        String ch;
        int no_checked = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_secondary);

        Intent intent = getIntent();
        String text[] = new String[3];
        boolean check[] = new boolean[3];

        text[0] = intent.getStringExtra(Constants.NR1_KEY);
        text[1] = intent.getStringExtra(Constants.NR2_KEY);
        text[2] = intent.getStringExtra(Constants.NR3_KEY);

        check[0] = intent.getBooleanExtra(Constants.CHECK1_KEY, false);
        check[1] = intent.getBooleanExtra(Constants.CHECK2_KEY, false);
        check[2] = intent.getBooleanExtra(Constants.CHECK3_KEY, false);

        ch = text[0];

        for (int i = 1; i < 3; i++) {
            if (!ch.equals(text[i]) && !ch.equals("*")) {
                gained = false;
                break;
            }

            if (check[i])
                no_checked++;
        }

        if (gained) {
            TextView result = findViewById(R.id.result);

            result.setText("Gained: " + getScore(no_checked));
        }
    }
}
