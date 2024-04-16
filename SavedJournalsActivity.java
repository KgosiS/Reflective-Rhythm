package com.example.rr1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class SavedJournalsActivity extends AppCompatActivity {

    private ListView listViewJournals;
    private ArrayList<String> journalList;
    private ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_journals);
        listViewJournals = findViewById(R.id.listViewJournals);
        journalList = new ArrayList<>();

        // Retrieve saved journals from database or storage
        // Populate journalList with the saved journals

        // Example:
        journalList.add("Journal 1");
        journalList.add("Journal 2");
        journalList.add("Journal 3");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, journalList);
        listViewJournals.setAdapter(adapter);
    }
}