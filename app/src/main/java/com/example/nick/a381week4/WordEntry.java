package com.example.nick.a381week4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
/**
 * Created by Nick on 27-Jan-17.
 */

public class WordEntry extends AppCompatActivity {

    EditText wordEntryEditText;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_entry);
        wordEntryEditText = (EditText) findViewById(R.id.editText);
    }
    public void onClickButton (View v) {
        String word = wordEntryEditText.getText().toString();
        Toast.makeText(this, word, Toast.LENGTH_SHORT).show();

        Intent i = new Intent();
        i.putExtra("WORD", word);
        setResult(RESULT_OK, i);
        finish();
    }
}
