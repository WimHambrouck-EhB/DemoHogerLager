package org.example.demohogerlager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    TextView txtScore;
    EditText edtInput;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new Game();
        edtInput = findViewById(R.id.edt_number);
        txtScore = findViewById(R.id.txt_score);

        txtScore.setText(String.format(Locale.getDefault(), getString(R.string.score), 0));

        final Button button = findViewById(R.id.btn_play);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playClicked();
            }
        });
    }


    @Override
    protected void onResume() {

        Snackbar.make(findViewById(R.id.view_base), "Please enable location permission in settings", BaseTransientBottomBar.LENGTH_INDEFINITE).show();
        super.onResume();
    }

    private void playClicked() {
        int userGuess = 0;

        String invoer = edtInput.getText().toString();
        if (!invoer.isEmpty()) {
            userGuess = Integer.parseInt(invoer);
        }

        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("score", userGuess);
        startActivity(intent);
    }
}