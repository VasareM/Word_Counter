package com.example.wordcounter;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import NewClass.CounterClass;

public class MainActivity extends AppCompatActivity {

    TextView tvCountResult;

    EditText edUserInput;

    Spinner spOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        this.tvCountResult = findViewById(R.id.tvCountResult);
        this.edUserInput =  findViewById(R.id.edUserInput);

        this.spOptions = findViewById(R.id.spOptions);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.count_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spOptions.setAdapter(adapter);
    }

    public void onBtnCountClick(View view) {
        if(this.spOptions.getSelectedItem().toString().equalsIgnoreCase(getString(R.string.chars_selection))) {
            String userPhrase = this.edUserInput.getText().toString();
            int charsCount = CounterClass.getCharsCount(userPhrase);
            this.tvCountResult.setText(String.valueOf(charsCount));
        }

        else {
            this.tvCountResult.setText("Not implemented");
        }
    }
}