
package com.example.sqlite;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    MyHelper myhelper;
    EditText e2,e3;
    TextView t1;
    Button insert, view, del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        myhelper = new MyHelper(this);
        SQLiteDatabase sql = myhelper.getWritableDatabase();

        e2= (EditText) findViewById(R.id.e2);
        e3= (EditText) findViewById(R.id.e3);
        insert = (Button) findViewById(R.id.insert);
        insert.setOnClickListener(this);



    }

    public void onClick(View v) {
        if (v.getId() == R.id.insert) {
            String name = e2.getText().toString();
            String loc = e3.getText().toString();
            long id = myhelper.insertData(name, loc);
            if (id < 0)
                Toast.makeText(this, "Unsuccessful Insertion", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "Successfully Inserted", Toast.LENGTH_LONG).show();


        }
        if (v.getId() == R.id.view) {
            String a = myhelper.getAllData();
            t1.setText(a);
        }
        if (v.getId()==R.id.del){

            int c = myhelper.deleteRow();
            if (c>0)
                Toast.makeText(this, "Deletion Successful", Toast.LENGTH_LONG).show();
            else
                Toast.makeText(this, "Maybe delete at a LATER time", Toast.LENGTH_LONG).show();
        }
    }


}

class MyHelper extends SQLiteOpenHelper {
    MyHelper(Context c) {
        super(c, "deptDB", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE DEPT (deptid INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(30), location VARCHAR(10));");
        } catch (SQLException e) {
        }
    }
    public long insertData(String username, String password) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name", username);
        cv.put("location", password);
        long rowid = db.insert("dept", null, cv);
        return rowid;
    }

    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer) {
        try {
            //db.execSQL("DROP TABLE IF EXISTS DEPT;");
        } catch (SQLException e) {
        }
    }
    public String getAllData() {
        // SELECT id, name, loc FROM dept
        SQLiteDatabase db = getWritableDatabase();
        String columns[] = {"deptid", "name", "location"};
        Cursor cr = db.query("dept", columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cr.moveToNext()) {
            int pid = cr.getInt(0);
            String name = cr.getString(1);
            String password = cr.getString(2);
            buffer.append(pid + " --- " + name + " --- " + password + "\n");
        }
        return buffer.toString();
    }
    public int deleteRow(){
        //DELETE * FROM dept WHERE NAME = ?
        SQLiteDatabase db = getWritableDatabase();

        int count = db.delete("dept",null,null);
        return count;
    }



}