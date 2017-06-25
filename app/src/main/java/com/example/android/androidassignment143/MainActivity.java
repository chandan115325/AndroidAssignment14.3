package com.example.android.androidassignment143;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private final String FILENAME="testfile.txt";
    EditText mEditText;
    TextView mtextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


// Assigning referenced objects
        mEditText = (EditText)findViewById(R.id.editText);
        mtextView = (TextView)findViewById(R.id.textView);


    }

    /**
     * To write the string into file into internal storage
     * @param view
     */
    public void writeFile(View view) {
        try {
            FileOutputStream fileOutputStream =
                    openFileOutput(FILENAME, Context.MODE_PRIVATE);
            fileOutputStream.write(
                    mEditText.getText().toString().getBytes());
            fileOutputStream.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * reading String data from the file from internal storage
     * @param view
     */
    public void readFile(View view) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream inputStream = openFileInput(FILENAME);
            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new
                        InputStreamReader(inputStream);
                BufferedReader bufferedReader = new
                        BufferedReader(inputStreamReader);
                String newLine = null;
                while ((newLine = bufferedReader.readLine()) !=
                        null ) {
                    stringBuilder.append(newLine+"\n");
                }
                inputStream.close();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        mtextView.setText(stringBuilder);
    }
}
