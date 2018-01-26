package com.example.lenovo.workshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
private EditText ed_name,ed_pass;
   private Button btn;
   private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ed_name = (EditText) findViewById(R.id.name);
        ed_pass = (EditText) findViewById(R.id.pass);
        btn = (Button) findViewById(R.id.Loginbtn);
        databaseHelper = new DatabaseHelper(this);
    }
    public void onClickLogin(View view){
 String username = ed_name.getText().toString();
   String password = ed_pass.getText().toString();
   String db_pass = databaseHelper.searchpass(username);
        if(password.equals(db_pass)){

        }
        else {
            Toast.makeText(Login.this, "Password and username do not match", Toast.LENGTH_SHORT).show();

        }
    }
}
