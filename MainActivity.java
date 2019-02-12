package com.example.matts.lab03;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private TextView t;
    private TextView guess;
    private TextView correctLetters;

    private ArrayList secretWords = new ArrayList(Arrays.asList(new String[] {"APPLE", "BANANA", "CHERRY"}));

    private String word;

    private int place;

    private StringBuilder sb;

    
    private String getScramWord(){

        int random = (int )(Math. random() * secretWords.size() + 1);
        word = (String) secretWords.get(random);

        String shuffledWord = "";
        ArrayList<String> splitWord = new ArrayList(Arrays.asList(word.split("")));
        Collections.shuffle(splitWord);
        for (String c : splitWord){
            shuffledWord += c;
        }

        return shuffledWord;
    }
    
    public void btnClicked(View v){
        String guessedLetter = guess.getText().toString();
        guessedLetter = guessedLetter.toUpperCase();
        if(guessedLetter.charAt(0)==word.charAt(place)){
            sb.append(guessedLetter);
        }
        correctLetters.setText(sb.toString());
        guess.setText("");
        place++;



        //winning condition
        if(sb.length() == word.length()){
            correctLetters.setText("You Win!!");
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        String w = getScramWord();
        sb = new StringBuilder();
        t = findViewById(R.id.scramWord);
        t.setText(w);
        guess = findViewById(R.id.guessField);
        correctLetters = findViewById(R.id.correctGuessesView);
        place = 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
