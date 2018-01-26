package com.example.lenovo.workshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
private EditText ed_uname,ed_pass,ed_phone,ed_email;
   private Button btn;
    private DatabaseHelper databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ed_uname = (EditText) findViewById(R.id.username);
        ed_pass = (EditText) findViewById(R.id.password);
        ed_phone = (EditText) findViewById(R.id.phone);
        ed_email = (EditText) findViewById(R.id.email);
        btn = (Button) findViewById(R.id.signupbuttn);
        databaseHelper = new DatabaseHelper(this);
    }
    public void onClickSignup(View view){
        boolean isinserted = databaseHelper.insert_data(ed_uname.getText().toString(),ed_pass.getText().toString(),ed_phone.getText().toString(),ed_email.getText().toString());
        if(isinserted == true){
            Toast.makeText(Signup.this,"Signed Up",Toast.LENGTH_SHORT).show();
            ed_uname.setText(" ");
            ed_pass.setText("");
            ed_phone.setText(" ");
            ed_email.setText(" ");
            startActivity(new Intent(Signup.this,Login.class));
        }
        else {
            Toast.makeText(Signup.this,"Not Signed Up",Toast.LENGTH_SHORT).show();
        }
    }
}
