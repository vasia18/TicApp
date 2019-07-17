package ru.recyclerview.ticapp.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ru.recyclerview.ticapp.R;
import ru.recyclerview.ticapp.models.TicTacToeModel;

public class TicTacToe extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        View continueGameButton = findViewById(R.id.continue_button);
        continueGameButton.setOnClickListener(this);
        View newGameButton = findViewById(R.id.new_game_button);
        newGameButton.setOnClickListener(this);
        View optionsButton = findViewById(R.id.options_button);
        optionsButton.setOnClickListener(this);
        View aboutButton = findViewById(R.id.about_button);
        aboutButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.continue_button:
                startActivity(new Intent(this, Game.class));
                break;
            case R.id.new_game_button:
                TicTacToeModel.getInstance().newGame();
                startActivity(new Intent(this, Game.class));
                break;
            case R.id.options_button:
                startActivity(new Intent(this, Options.class));
                break;
            case R.id.about_button:
                startActivity(new Intent(this, About.class));
                break;
            default:
                break;
        }

    }
}
