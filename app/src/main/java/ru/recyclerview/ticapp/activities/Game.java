package ru.recyclerview.ticapp.activities;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.AlertDialog;

import ru.recyclerview.ticapp.R;
import ru.recyclerview.ticapp.controllers.TicTacToeController;
import ru.recyclerview.ticapp.models.TicTacToeModel;

public class Game extends Activity implements View.OnClickListener {

    private static TicTacToeModel model = TicTacToeModel.getInstance();
    private static TicTacToeController controller = TicTacToeController.getInstance();

    private Button[] buttons;

    private void initListeners() {
        buttons = new Button[9];
        buttons[0] = findViewById(R.id.button_11);
        buttons[1] = findViewById(R.id.button_12);
        buttons[2] = findViewById(R.id.button_13);
        buttons[3] = findViewById(R.id.button_21);
        buttons[4] = findViewById(R.id.button_22);
        buttons[5] = findViewById(R.id.button_23);
        buttons[6] = findViewById(R.id.button_31);
        buttons[7] = findViewById(R.id.button_32);
        buttons[8] = findViewById(R.id.button_33);

        for (Button btn : buttons) {
            btn.setOnClickListener(this);
        }

        findViewById(R.id.human_vs_droid).setOnClickListener(this);
    }

    private void injectionController() {
        controller.setButtons(buttons);
        controller.setScores((TextView) findViewById(R.id.human_score),
                (TextView) findViewById(R.id.droid_score));
    }

    private void doMove(Button btn) {
        switch (btn.getId()) {
            case R.id.button_11:
                model.doMove(0, 0);
                break;
            case R.id.button_12:
                model.doMove(0, 1);
                break;
            case R.id.button_13:
                model.doMove(0, 2);
                break;
            case R.id.button_21:
                model.doMove(1, 0);
                break;
            case R.id.button_22:
                model.doMove(1, 1);
                break;
            case R.id.button_23:
                model.doMove(1, 2);
                break;
            case R.id.button_31:
                model.doMove(2, 0);
                break;
            case R.id.button_32:
                model.doMove(2, 1);
                break;
            case R.id.button_33:
                model.doMove(2, 2);
                break;
        }
    }

    private void newRound() {
        model.newRound();
        controller.refreshGame();
    }

    private void newGame() {
        model.newGame();
        controller.refreshGame();
    }

    private void showAlertDialog(int status) {
        new AlertDialog.Builder(this).setTitle(R.string.message_title)
                .setMessage(status).setNeutralButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {
                        newRound();
                    }
                }).show();
    }

    private void showRestartDialog() {
        new AlertDialog.Builder(this).setTitle(R.string.question_title)
                .setMessage(R.string.restart_game).setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dlg, int sumthin) {
                        newGame();
                    }
                }).setNegativeButton("No", null).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // //Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        initListeners();
        injectionController();
        controller.refreshGame();
    }

    public void onClick(View v) {
        if (v instanceof Button) {
            doMove((Button) v);
            controller.refreshGame();
            if (model.getState() == TicTacToeModel.STATE_DRAW)
                showAlertDialog(R.string.draw_game);
            else if (model.getState() == TicTacToeModel.STATE_WIN) {
                if (model.getWinner() == TicTacToeModel.NOUGHT)
                    showAlertDialog(R.string.nought_win_game);
                else if (model.getWinner() == TicTacToeModel.CROSS)
                    showAlertDialog(R.string.cross_win_game);
            }

        } else if (v instanceof ImageView) {
            showRestartDialog();
        }

    }
}
