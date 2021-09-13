package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;



public class MainActivity extends Activity {

/*Button login_btn;
EditText email;
EditText password;*/
String Test_userName="salma";
String Test_password="123456";
boolean isValid=false;

@BindView(R.id.button6)Button login_btn;
@BindView(R.id.userName_txt)EditText email;
@BindView(R.id.editTextNumberPassword) EditText password;
@BindView(R.id.upload_image) ImageView image;
@BindView(R.id.url_btn)Button url_btn;

@BindView(R.id.url_txt) EditText URL_txt;






    @Override
        public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


       /* Picasso.get()
                .load("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg")

                .into(image)
        ;*/

        Glide.with(this)
                .load("https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885_960_720.jpg")
                .placeholder(R.drawable.anger)
                .into(image);


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_userName = email.getText().toString();
                String input_userPass = password.getText().toString();

                if (validate(input_userName, input_userPass)) {
                    //go to new activity
                    Intent intent = new Intent(MainActivity.this, listTicket.class);
                    startActivity(intent);
                }

            }

        });






    }

private boolean validate(String email,String pass){
        if(email.equals(Test_userName)&& pass.equals(Test_password))
        {
            Toast.makeText(MainActivity.this,"Success login",Toast.LENGTH_LONG).show();
            return true;
        }
        else if(email.isEmpty()||pass.isEmpty())
        {
            Toast.makeText(MainActivity.this,"Empty user name or password",Toast.LENGTH_LONG).show();
            return false;
        }

        else if(!email.equals(Test_userName))
        {
            Toast.makeText(MainActivity.this,"Wrong email",Toast.LENGTH_LONG).show();
            return false;
        }

        else if(!password.equals((Test_password)))
        {
            Toast.makeText(MainActivity.this,"Wrong password",Toast.LENGTH_LONG).show();
            return false;
        }
        else if(!email.equals(Test_userName)&&!password.equals((Test_password)))
        {
            Toast.makeText(MainActivity.this,"Wrong user name and password",Toast.LENGTH_LONG).show();
            return false;
        }

        return false;
 }

}
