package cs245.memorygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private static Map<Integer, int[]> buttonArrangements;

    private int numTiles;
    private int[] buttonArrangement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setupButtonArrangements();
        numTiles = getIntent().getIntExtra("numTiles", 0);
        buttonArrangement = buttonArrangements.get(numTiles);
        createButtons();
    }

    protected void createButtons(){
        for(int i = 0; i < 20; i++){
            String buttonName = "cardButton" + i;
            int resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            ImageButton cardButton = ((ImageButton) findViewById(resID));
            cardButton.setVisibility(View.INVISIBLE);
        }
        for(int i : buttonArrangement){
            String buttonName = "cardButton" + i;
            int resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            ImageButton cardButton = ((ImageButton) findViewById(resID));
            cardButton.setVisibility(View.VISIBLE);
            cardButton.setOnClickListener(this);
        }
    }

    private void setupButtonArrangements(){
        if(buttonArrangements == null){
            buttonArrangements = new HashMap<>();
            buttonArrangements.put(4, new int[] {5, 6, 9, 10});
            buttonArrangements.put(6, new int[] {5, 6, 9, 10, 13, 14});
            buttonArrangements.put(8, new int[] {4, 5, 6, 7, 8, 9, 10, 11});
            buttonArrangements.put(10, new int[] {1, 2, 5, 6, 9, 10, 13, 14, 17, 18});
            buttonArrangements.put(12, new int[] {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15});
            buttonArrangements.put(14, new int[] {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18});
            buttonArrangements.put(16, new int[] {4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19});
            buttonArrangements.put(18, new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18});
            buttonArrangements.put(20, new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19});
        }
    }

    @Override
    public void onClick(View view) {

    }
}
