package ru.recyclerview.ticapp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import ru.recyclerview.ticapp.R;
import ru.recyclerview.ticapp.models.TicTacToeModel;

public class Options extends Activity {

    private void initButton() {
        RadioButton easy = findViewById(R.id.easy_radiobutton);
        easy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TicTacToeModel.getInstance().setDifficulty(TicTacToeModel.EASY_DIF);
            }
        });

        RadioButton medium = findViewById(R.id.medium_radiobutton);
        medium.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TicTacToeModel.getInstance().setDifficulty(TicTacToeModel.MEDIUM_DIF);
            }
        });

        RadioButton hard = findViewById(R.id.hard_radiobutton);
        hard.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TicTacToeModel.getInstance().setDifficulty(TicTacToeModel.HARD_DIF);
            }
        });

        switch (TicTacToeModel.getInstance().getDifficulty()) {
            case TicTacToeModel.EASY_DIF:
                easy.setChecked(true);
                break;
            case TicTacToeModel.MEDIUM_DIF:
                medium.setChecked(true);
                break;
            case TicTacToeModel.HARD_DIF:
                hard.setChecked(true);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.options);
        initButton();
    }

}
