package cs245.memorygame;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static MediaPlayer mediaPlayer;
    private Button musicButton, highScoreButton;
    private boolean musicToggle = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i = 4; i <= 20; i += 2){
            String buttonName = "tilesButton" + i;
            int resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            ((Button) findViewById(resID)).setOnClickListener(this);
        }
        String buttonName = "musicButton";
        int resID = getResources().getIdentifier(buttonName, "id", getPackageName());
        musicButton = ((Button) findViewById(resID));
        musicButton.setOnClickListener(this);
        buttonName = "highscoreButton";
        resID = getResources().getIdentifier(buttonName, "id", getPackageName());
        highScoreButton = ((Button) findViewById(resID));
        highScoreButton.setOnClickListener(this);
        if(mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.song);
        }
        if(musicToggle == true && mediaPlayer.isPlaying()==false){
            startMusic();

        }

    }
    public void startMusic(){
        mediaPlayer.start();


    }
    @Override
    public void onClick(View view) {
        if(view == musicButton) {
            System.out.println("music button clicked");
            if(musicToggle == false && mediaPlayer.isPlaying()==false){
                musicToggle = true;
                startMusic();

            }
            else{
                musicToggle = false;
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
            }

        }
        else if(view == highScoreButton){
            System.out.println("highScore button clicked");
            Intent i = new Intent(MainActivity.this, HighScoreActivity.class);
            i.putExtra("numTiles", 1);
            i.putExtra("score", -20);
            startActivity(i);


        }
        else{

            String buttonText = ((Button) view).getText().toString();
            Integer buttonNum = Integer.parseInt(buttonText.substring(0, buttonText.length() - 6));
            Intent i = new Intent(MainActivity.this, GameActivity.class);
            i.putExtra("numTiles", buttonNum);
            startActivity(i);
        }
    }
}
