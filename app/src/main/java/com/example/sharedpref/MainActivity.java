package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private static final String MESSAGE = "message_prefs";
    private Button button;
    private EditText editText;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        editText=findViewById(R.id.editText);
        textView=findViewById(R.id.textview);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message=editText.getText().toString().trim();
                //Creating SharedPrefernces

                sharedPreferences = getSharedPreferences(MESSAGE,MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("messgae",message);
                editor.commit();
            }
        });
        //Getting Data
        sharedPreferences=getSharedPreferences(MESSAGE,MODE_PRIVATE);
        String data;
        data = sharedPreferences.getString("messgae","NOTHING YET");
        textView.setText(data);
    }
}