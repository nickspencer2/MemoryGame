package cs245.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for(int i = 4; i <= 20; i += 2){
            String buttonName = "tilesButton" + i;
            int resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            ((Button) findViewById(resID)).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        String buttonText = ((Button) view).getText().toString();
        Integer buttonNum = Integer.parseInt(buttonText.substring(0, buttonText.length() - 6));
        Intent i = new Intent(MainActivity.this, GameActivity.class);
        i.putExtra("numTiles", buttonNum);
        startActivity(i);
    }
}
