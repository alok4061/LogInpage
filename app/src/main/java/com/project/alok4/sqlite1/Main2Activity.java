package com.project.alok4.sqlite1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.alok4.sqlite1.R;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    static SQLiteDatabase sq;
    EditText et,et1,et2;
    Button btn,btn1;
    TextView tv;
    ListView listView;
    ArrayList myarray=new ArrayList();
    static String user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d("pl","ok");
        btn= (Button) findViewById(R.id.button3);
        btn1= (Button) findViewById(R.id.button5);
        et= (EditText) findViewById(R.id.editText);
        et1= (EditText) findViewById(R.id.editText2);
        et2= (EditText) findViewById(R.id.editText3);
        tv= (TextView) findViewById(R.id.textView2);
        listView= (ListView) findViewById(R.id.listView);
        sq=openOrCreateDatabase("My data",MODE_PRIVATE,null);
        ArrayAdapter<String> adapter= new ArrayAdapter<String>(Main2Activity.this,android.R.layout.simple_dropdown_item_1line,myarray);
        listView.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=et.getText().toString();
                String s1=et1.getText().toString();
                Log.d("aok","apk");
                sq.execSQL("CREATE TABLE IF NOT EXISTS student"+"(username VARCHAR,password VARCHAR)");
                Log.d("aok","ok");
                sq.execSQL("INSERT INTO student"+"(username,password)"+"VALUES('"+s+"','"+s1+"')");
                Toast.makeText(Main2Activity.this,"Registration Successfuly",Toast.LENGTH_SHORT).show();
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("po","gh");
                Cursor c=sq.rawQuery("SELECT * FROM student",null);
                while (c.moveToNext())
                {
                    Log.d("po","alod");
                    user= c.getString(0);
                    pass= c.getString(1);
                    myarray.add(user);
                    myarray.add(pass);
                }


            }
        });
    }
}
