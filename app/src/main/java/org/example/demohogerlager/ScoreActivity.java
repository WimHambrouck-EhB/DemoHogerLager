package org.example.demohogerlager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Locale;

public class ScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        int score = getIntent().getIntExtra("score", -1);
        TextView txtScore = findViewById(R.id.txt_score);

        if(score != -1)
        {
            String temp = String.format(Locale.getDefault(), "Score: %d %s", 5, "tekst");
            txtScore.setText(temp);
        } else {
            txtScore.setText("No score!");


        }
    }
}