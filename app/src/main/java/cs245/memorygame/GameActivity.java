package cs245.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private static Map<Integer, int[]> buttonArrangements;
    private ArrayList<ImageButton> buttonList;
    private Map<ImageButton, Integer> backSideOfCard;
    private int numTiles;
    private int[] buttonArrangement;
    private List<Integer> resAnimals;
    private Button tryButton, newButton, endButton, completedButton;
    private int upCards;
    private ImageButton upButton, upButton2;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setupButtonArrangements();
        setupResAnimals();
        upCards = 0;
        numTiles = getIntent().getIntExtra("numTiles", 0);
        buttonArrangement = buttonArrangements.get(numTiles);
        buttonList = new ArrayList<ImageButton>();
        createButtons();
        score = 0;
    }

    protected void createButtons(){
        System.out.println("Buttons Created");
        String buttonName = "tryAgainButton";
        int resID = getResources().getIdentifier(buttonName, "id", getPackageName());
        tryButton = ((Button) findViewById(resID));
        tryButton.setOnClickListener(this);

        buttonName = "newGameButton";
        resID = getResources().getIdentifier(buttonName, "id", getPackageName());
        newButton = ((Button) findViewById(resID));
        newButton.setOnClickListener(this);

        buttonName = "endGameButton";
        resID = getResources().getIdentifier(buttonName, "id", getPackageName());
        endButton = ((Button) findViewById(resID));
        endButton.setOnClickListener(this);

        buttonName = "completedButton";
        resID = getResources().getIdentifier(buttonName, "id", getPackageName());
        completedButton = ((Button) findViewById(resID));
        completedButton.setOnClickListener(this);


        for(int i = 0; i < 20; i++){
            buttonName = "cardButton" + i;
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            ImageButton cardButton = ((ImageButton) findViewById(resID));
            cardButton.setVisibility(View.INVISIBLE);
        }
        for(int i : buttonArrangement){
            buttonName = "cardButton" + i;
            resID = getResources().getIdentifier(buttonName, "id", getPackageName());
            ImageButton cardButton = ((ImageButton) findViewById(resID));

            buttonList.add(cardButton);
            cardButton.setVisibility(View.VISIBLE);
            cardButton.setOnClickListener(this);
        }
        backSideOfCard = new HashMap<>();
        Random rand = new Random();
        int numAnimals = numTiles/2;
        System.out.println(resAnimals.size());
        int animalPic, buttonListidx;
        ImageButton button;
        for(int i = 0; i < numAnimals; i++) {

            animalPic = resAnimals.get(i);
            buttonListidx = rand.nextInt(buttonList.size());
            button = buttonList.get(buttonListidx);
            backSideOfCard.put(button, animalPic);
            buttonList.remove(buttonListidx);

            buttonListidx = rand.nextInt(buttonList.size());
            button = buttonList.get(buttonListidx);
            backSideOfCard.put(button, animalPic);
            buttonList.remove(buttonListidx);
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

    private void setupResAnimals() {
        resAnimals = new ArrayList<>();
        resAnimals.add(R.drawable.animal0);
        resAnimals.add(R.drawable.animal1);
        resAnimals.add(R.drawable.animal2);
        resAnimals.add(R.drawable.animal3);
        resAnimals.add(R.drawable.animal4);
        resAnimals.add(R.drawable.animal5);
        resAnimals.add(R.drawable.animal6);
        resAnimals.add(R.drawable.animal7);
        resAnimals.add(R.drawable.animal8);
        resAnimals.add(R.drawable.animal9);

    }

    @Override
    public void onClick(View v) {

        if(v == tryButton) {
            for (ImageButton imageButton : backSideOfCard.keySet()) {
                imageButton.setImageResource(R.drawable.original);
                upCards = 0;
                upButton = null;
                upButton2 = null;
            }
        }

        else if(v == completedButton){
            Intent i = new Intent(GameActivity.this, HighScoreActivity.class);
            i.putExtra("numTiles", numTiles);
            if(score < 0){
                score = 0;
            }
            i.putExtra("score", score);
            startActivity(i);

        } else if(v == endButton) {
            for(ImageButton imageButton : backSideOfCard.keySet()) {
                imageButton.setImageResource(backSideOfCard.get(imageButton));
                upCards = 2;
                upButton = null;
            }
        } else if( v == newButton){
            finish();
        } else {
            if(upCards == 0 && upButton == null){
                upButton = (ImageButton) v;
                upButton.setImageResource(backSideOfCard.get(upButton));
                upCards++;
            }
            else if(upCards == 1 && upButton2 == null){
                upButton2 = (ImageButton) v;
                upButton2.setImageResource(backSideOfCard.get(upButton2));
                if (backSideOfCard.get(upButton).equals(backSideOfCard.get(upButton2))){
                    upCards = 0;
                    upButton.setClickable(false);
                    upButton2.setClickable(false);
                    backSideOfCard.remove(upButton);
                    backSideOfCard.remove(upButton2);
                    upButton = null;
                    upButton2 = null;
                    score = score + 2;
                }
                else{
                    score = score - 1;
                    upButton = null;
                    upButton2 = null;
                    upCards = upCards + 1;
                }

            }


        }

    }
}
