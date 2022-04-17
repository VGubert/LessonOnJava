package com.example.p0081_viewbyid;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);
        textView.setText("Asome Text");

        Button button = findViewById(R.id.button);
        button.setText("ALARM");
        button.setEnabled(false);

        CheckBox checkBox = findViewById(R.id.checkBox);
        checkBox.setChecked(true);
    }

}