package com.project.alok4.sqlite1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {
    EditText et,et1;
    Button btn;
    String a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        btn= (Button) findViewById(R.id.button4);
        et= (EditText) findViewById(R.id.editText5);
        et1= (EditText) findViewById(R.id.editText6);
         a=Main2Activity.user.toString();
        b=Main2Activity.pass.toString();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String l=et.getText().toString();
                String g=et1.getText().toString();
                if (a.equals(l)){
                   if(b.equals(g)){
                        Toast.makeText(Main3Activity.this,"Correct LogIn",Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Main3Activity.this,"Uncorrect LogIn",Toast.LENGTH_SHORT).show();
                    }}
                else {
                    Toast.makeText(Main3Activity.this,"Uncorrect LogIn",Toast.LENGTH_SHORT).show();
               }

            }
        });
    }
}

