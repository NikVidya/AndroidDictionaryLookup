package com.example.nick.a381week4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_WORD_ENTRY = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickButton (View v) {
        Intent i = new Intent(getApplicationContext(), WordEntry.class);
        startActivityForResult(i, REQUEST_WORD_ENTRY);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == REQUEST_WORD_ENTRY) {
            if (resultCode == RESULT_OK) {
                if (data.hasExtra("WORD")) {
                    String word_entered = data.getExtras().getString("WORD");
                    Uri webpage = Uri.parse("http://www.merriam-webster.com/dictionary/" + word_entered);
                    Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                    startActivity(webIntent);
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
