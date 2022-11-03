
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    MyHelpers myhelpers;
    EditText e2, e3;
    TextView t1;
    Button insert, view, del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        myhelpers = new MyHelpers(this);
        SQLiteDatabase sql = myhelpers.getWritableDatabase();


        t1 = (TextView) findViewById(R.id.t1);
        String a = myhelpers.getAllData();
        t1.setText(a);


    }

}
class MyHelpers extends SQLiteOpenHelper {
    MyHelpers(Context c) {
        super(c, "deptDB", null, 1);
    }

    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL("CREATE TABLE DEPT (deptid INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(30), location VARCHAR(10));");
        } catch (SQLException e) {
        }
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