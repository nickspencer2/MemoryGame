package cs245.memorygame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by drunk on 11/30/2017.
 */

public class HighScoreActivity extends AppCompatActivity implements View.OnClickListener {
    private int numTiles;
    private int score;
    private EditText nameText;
    private Button mainMenuButton;
    private TextView currentScore;
    private SharedPreferences.Editor editor;
    private SharedPreferences settings;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settings = getSharedPreferences("highscores", 0);
        setContentView(R.layout.activity_highscore);
        numTiles = getIntent().getIntExtra("numTiles", 0);
        score = getIntent().getIntExtra("score", 0);

        updateScores();
        createButtons();
    }

    protected void createButtons() {
        String buttonName = "currentScore";
        int resID = getResources().getIdentifier(buttonName, "id", getPackageName());
        currentScore = ((TextView) findViewById(resID));
        currentScore.setText(currentScore.getText() + " " + score);


        buttonName = "mainMenuButton";
        resID = getResources().getIdentifier(buttonName, "id", getPackageName());
        mainMenuButton = ((Button) findViewById(resID));
        mainMenuButton.setOnClickListener(this);


        buttonName = "message";
        resID = getResources().getIdentifier(buttonName, "id", getPackageName());
        nameText = ((EditText) findViewById(resID));
        nameText.setOnClickListener(this);
    }

    protected void updateScores(){

        if(settings.contains("fourOneScore")){
            String buttonName = "fourOne";
            int resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            TextView temp= ((TextView) findViewById(resID));
            temp.setText(settings.getString("fourOneName","") + settings.getInt("fourOneScore", 0));
            buttonName = "fourTwo";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp = ((TextView) findViewById(resID));
            temp.setText(settings.getString("fourTwoName","") + settings.getInt("fourTwoScore", 0));
            buttonName = "fourThree";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp = ((TextView) findViewById(resID));
            temp.setText(settings.getString("fourThreeName","") + settings.getInt("fourThreeScore", 0));

            buttonName = "sixOne";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp= ((TextView) findViewById(resID));
            temp.setText(settings.getString("sixOneName","") + settings.getInt("sixOneScore", 0));
            buttonName = "sixTwo";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp = ((TextView) findViewById(resID));
            temp.setText(settings.getString("sixTwoName","") + settings.getInt("sixTwoScore", 0));
            buttonName = "sixThree";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp = ((TextView) findViewById(resID));
            temp.setText(settings.getString("sixThreeName","") + settings.getInt("sixThreeScore", 0));

            buttonName = "eightOne";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp= ((TextView) findViewById(resID));
            temp.setText(settings.getString("eightOneName","") + settings.getInt("eightOneScore", 0));
            buttonName = "eightTwo";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp = ((TextView) findViewById(resID));
            temp.setText(settings.getString("eightTwoName","") + settings.getInt("eightTwoScore", 0));
            buttonName = "eightThree";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp = ((TextView) findViewById(resID));
            temp.setText(settings.getString("eightThreeName","") + settings.getInt("eightThreeScore", 0));

            buttonName = "tenOne";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp= ((TextView) findViewById(resID));
            temp.setText(settings.getString("tenOneName","") + settings.getInt("tenOneScore", 0));
            buttonName = "tenTwo";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp = ((TextView) findViewById(resID));
            temp.setText(settings.getString("tenTwoName","") + settings.getInt("tenTwoScore", 0));
            buttonName = "tenThree";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp = ((TextView) findViewById(resID));
            temp.setText(settings.getString("tenThreeName","") + settings.getInt("tenThreeScore", 0));

            buttonName = "twelveOne";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp= ((TextView) findViewById(resID));
            temp.setText(settings.getString("buttonName" + "Name","") + settings.getInt("buttonName" + "Score", 0));
            buttonName = "twelveTwo";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp = ((TextView) findViewById(resID));
            temp.setText(settings.getString("buttonName" + "Name","") + settings.getInt("buttonName" + "Score", 0));
            buttonName = "twelveThree";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp = ((TextView) findViewById(resID));
            temp.setText(settings.getString("buttonName" + "Name","") + settings.getInt("buttonName" + "Score", 0));

            buttonName = "fourteenOne";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp= ((TextView) findViewById(resID));
            temp.setText(settings.getString("buttonName" + "Name","") + settings.getInt("buttonName" + "Score", 0));
            buttonName = "fourteenTwo";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp = ((TextView) findViewById(resID));
            temp.setText(settings.getString("buttonName" + "Name","") + settings.getInt("buttonName" + "Score", 0));
            buttonName = "fourteenThree";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp = ((TextView) findViewById(resID));
            temp.setText(settings.getString("buttonName" + "Name","") + settings.getInt("buttonName" + "Score", 0));

            buttonName = "sixteenOne";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp= ((TextView) findViewById(resID));
            temp.setText(settings.getString("buttonName" + "Name","") + settings.getInt("buttonName" + "Score", 0));
            buttonName = "sixteenTwo";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp = ((TextView) findViewById(resID));
            temp.setText(settings.getString("buttonName" + "Name","") + settings.getInt("buttonName" + "Score", 0));
            buttonName = "sixteenThree";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp = ((TextView) findViewById(resID));
            temp.setText(settings.getString("buttonName" + "Name","") + settings.getInt("buttonName" + "Score", 0));

            buttonName = "eighteenOne";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp= ((TextView) findViewById(resID));
            temp.setText(settings.getString("buttonName" + "Name","") + settings.getInt("buttonName" + "Score", 0));
            buttonName = "eighteenTwo";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp = ((TextView) findViewById(resID));
            temp.setText(settings.getString("buttonName" + "Name","") + settings.getInt("buttonName" + "Score", 0));
            buttonName = "eighteenThree";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp = ((TextView) findViewById(resID));
            temp.setText(settings.getString("buttonName" + "Name","") + settings.getInt("buttonName" + "Score", 0));

            buttonName = "twentyOne";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp= ((TextView) findViewById(resID));
            temp.setText(settings.getString("buttonName" + "Name","") + settings.getInt("buttonName" + "Score", 0));
            buttonName = "twentyTwo";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp = ((TextView) findViewById(resID));
            temp.setText(settings.getString("buttonName" + "Name","") + settings.getInt("buttonName" + "Score", 0));
            buttonName = "twentyThree";
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            temp = ((TextView) findViewById(resID));
            temp.setText(settings.getString("buttonName" + "Name","") + settings.getInt("buttonName" + "Score", 0));


        }
        else{
            editor = settings.edit();
            // four
            editor.putInt("fourOneScore", 0);
            editor.putString("fourOneName", "");
            editor.putInt("fourTwoScore", 0);
            editor.putString("fourTwoName", "");
            editor.putInt("fourThreeScore", 0);
            editor.putString("fourThreeName", "");
            // six
            editor.putInt("sixOneScore", 0);
            editor.putString("sixOneName", "");
            editor.putInt("sixTwoScore", 0);
            editor.putString("sixTwoName", "");
            editor.putInt("sixThreeScore", 0);
            editor.putString("sixThreeName", "");
            // eight
            editor.putInt("eightOneScore", 0);
            editor.putString("eightOneName", "");
            editor.putInt("eightTwoScore", 0);
            editor.putString("fourTwoName", "");
            editor.putInt("eightThreeScore", 0);
            editor.putString("eightThreeName", "");
            // ten
            editor.putInt("tenOneScore", 0);
            editor.putString("tenOneName", "");
            editor.putInt("tenTwoScore", 0);
            editor.putString("tenTwoName", "");
            editor.putInt("tenThreeScore", 0);
            editor.putString("tenThreeName", "");
            // twelve
            editor.putInt("twelveOneScore", 0);
            editor.putString("twelveOneName", "");
            editor.putInt("twelveTwoScore", 0);
            editor.putString("twelveTwoName", "");
            editor.putInt("twelveThreeScore", 0);
            editor.putString("twelveThreeName", "");
            // fourteen
            editor.putInt("fourteenOneScore", 0);
            editor.putString("fourteenOneName", "");
            editor.putInt("fourteenTwoScore", 0);
            editor.putString("fourteenTwoName", "");
            editor.putInt("fourteenThreeScore", 0);
            editor.putString("fourteenThreeName", "");
            // sixteen
            editor.putInt("sixteenOneScore", 0);
            editor.putString("sixteenOneName", "");
            editor.putInt("sixteenTwoScore", 0);
            editor.putString("sixteenTwoName", "");
            editor.putInt("sixteenThreeScore", 0);
            editor.putString("sixteenThreeName", "");
            // eighteen
            editor.putInt("eighteenOneScore", 0);
            editor.putString("eighteenOneName", "");
            editor.putInt("eighteenTwoScore", 0);
            editor.putString("eighteenTwoName", "");
            editor.putInt("eighteenThreeScore", 0);
            editor.putString("eighteenThreeName", "");
            // twenty
            editor.putInt("twentyOneScore", 0);
            editor.putString("twentyOneName", "");
            editor.putInt("twentyTwoScore", 0);
            editor.putString("twentyTwoName", "");
            editor.putInt("twentyThreeScore", 0);
            editor.putString("twentyThreeName", "");
            editor.commit();
        }

    }
    @Override
    public void onClick(View view) {
        if(view == mainMenuButton) {

            editor = settings.edit();
            String num = null;
            switch (numTiles){
                case 4:
                    num = "four";
                    break;
                case 6:
                    num = "six";
                    break;
                case 8:
                    num = "eight";
                    break;
                case 10:
                    num = "ten";
                    break;
                case 12:
                    num = "twelve";
                    break;
                case 14:
                    num = "fourteen";
                    break;
                case 16:
                    num = "sixteen";
                    break;
                case 18:
                    num = "eighteen";
                    break;
                case 20:
                    num = "twenty";
                    break;
            }
            if(score >= settings.getInt(num + "OneScore", 0)){
                editor.putInt(num + "ThreeScore", settings.getInt(num + "TwoScore", 0));
                editor.putString(num + "ThreeName", settings.getString(num + "TwoName", ""));
                editor.putInt(num + "TwoScore", settings.getInt(num + "OneScore", 0));
                editor.putString(num + "TwoName", settings.getString(num + "OneName", ""));
                editor.putInt(num + "OneScore", score);
                editor.putString(num + "OneName",  nameText.getText().toString() + ": ");
            }
            else if(score >= settings.getInt(num + "TwoScore", 0)){
                editor.putInt(num + "ThreeScore", settings.getInt(num + "TwoScore", 0));
                editor.putString(num + "ThreeName", settings.getString(num + "TwoName", ""));
                editor.putInt(num + "TwoScore", score);
                editor.putString(num + "TwoName", nameText.getText().toString() + ": ");
            }
            else if(score >= settings.getInt(num + "ThreeScore", 0)){
                editor.putInt(num + "ThreeScore", score);
                editor.putString(num + "ThreeName",  nameText.getText().toString() + ": ");
            }
            editor.commit();

            Intent i = new Intent(HighScoreActivity.this, MainActivity.class);
            startActivity(i);
        }

    }
}


