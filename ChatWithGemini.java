package com.example.rr1;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.ai.client.generativeai.GenerativeModel;
import com.google.ai.client.generativeai.java.GenerativeModelFutures;
import com.google.ai.client.generativeai.type.Content;
import com.google.ai.client.generativeai.type.GenerateContentResponse;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class ChatWithGemini extends AppCompatActivity {

    private EditText editTextPrompt;
    private TextView textView;
    private List<String> journalEntries;
    // Access your API key as a Build Configuration variable
    String apiKey = "AIzaSyCTNhj9HXE-BZYvtYRg84sze1zlkpzNI28";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_with_gemini);

        editTextPrompt = findViewById(R.id.editTextPrompt);
        textView = findViewById(R.id.textViewResponse);

        journalEntries = new ArrayList<>();
    }

    public void buttonCallGeminiAPI(View view) {
        String prompt = editTextPrompt.getText().toString().trim();
        if (!prompt.isEmpty()) {
            // For text-only input, use the gemini-pro model
            GenerativeModel gm = new GenerativeModel(/* modelName */ "gemini-pro",
                    // Access your API key as a Build Configuration variable (see "Set up your API key" above)
                    /* apiKey */ apiKey);
            GenerativeModelFutures model = GenerativeModelFutures.from(gm);

            Content content = new Content.Builder()
                    .addText(prompt) // Use the text entered by the user
                    .build();

            ListenableFuture<GenerateContentResponse> response = model.generateContent(content);
            Futures.addCallback(response, new FutureCallback<GenerateContentResponse>() {
                @Override
                public void onSuccess(GenerateContentResponse result) {
                    String resultText = result.getText();
                    textView.setText(resultText);
                }

                @Override
                public void onFailure(Throwable t) {
                    textView.setText(t.toString());
                }
            }, this.getMainExecutor());

            // Optionally, clear the input field after sending the prompt
            editTextPrompt.setText("");
        }
    }
}
