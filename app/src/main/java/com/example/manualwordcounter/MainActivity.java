package com.example.manualwordcounter;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText editText = findViewById(R.id.editInputText);
        Spinner spinner = findViewById(R.id.spinnerCountType);
        Button calculateButton = findViewById(R.id.buttonCalculate);
        TextView resultTextView = findViewById(R.id.textResult);
        TextCounter textCounter = new TextCounter();
        calculateButton.setOnClickListener(v -> {
            String inputText = editText.getText().toString();
            if (inputText.trim().isEmpty()) {
                Toast.makeText(this, R.string.error_empty_text, Toast.LENGTH_SHORT).show();
                return;
            }
            int selectedType = spinner.getSelectedItemPosition();
            int result;

            switch (selectedType) {
                case 0:
                    result = textCounter.countSentences(inputText);
                    break;
                case 1:
                    result = textCounter.countWords(inputText);
                    break;
                case 2:
                    result = textCounter.countPunctuation(inputText);
                    break;
                case 3:
                    result = textCounter.countNumbers(inputText);
                    break;
                default:
                    return;
            }

                    resultTextView.setText(String.valueOf(result));
            });

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main), (view, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars());
                    view.setPadding(
                            systemBars.left, systemBars.top,
                            systemBars.right, systemBars.bottom);
                    return insets;
                });
    }
}


