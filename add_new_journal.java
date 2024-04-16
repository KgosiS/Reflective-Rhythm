package com.example.rr1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rr1.JournalAdapter;

import java.util.ArrayList;
import java.util.List;

public class add_new_journal extends AppCompatActivity {
    private EditText editTextJournal;
    private Button buttonSave;
    private ArrayList<String> journalList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_journal);

        editTextJournal = findViewById(R.id.editTextJournal);
        buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveJournal();
            }
        });
    }

    private void saveJournal() {
        String journalContent = editTextJournal.getText().toString().trim();
        // Implement code to save the journal content (e.g., to a database)
        if (!journalContent.isEmpty()) {
            // Save the journal content
            journalList.add(journalContent); // Add the new journal to the list
            adapter.notifyDataSetChanged(); // Notify the adapter of the data change
            Toast.makeText(this, "Journal saved successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please write something before saving", Toast.LENGTH_SHORT).show();
        }
    }
}