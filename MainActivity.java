package com.example.rr1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button viewJournals= findViewById(R.id.display_jrnals);
        Button chat_to_gemini= findViewById(R.id.chat_Gemini);
        Button write_jrnal=findViewById(R.id.writeJournal);
        viewJournals.setOnClickListener(view -> DisplayJournals());
        chat_to_gemini.setOnClickListener(view -> Chat_to_Gemini());
        write_jrnal.setOnClickListener(view -> WriteJournal());

    }
    public void Chat_to_Gemini(){
        Intent  chat= new Intent(this,ChatWithGemini.class);
        startActivity(chat);
    }
    public void DisplayJournals(){
        Intent display_journals=new Intent(this,SavedJournalsActivity.class);
        startActivity(display_journals);
    }
    public void WriteJournal(){
        Intent add_new_journal=new Intent(this, com.example.rr1.add_new_journal.class);
        startActivity(add_new_journal);
    }
}