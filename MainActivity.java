package com.example.myapplication2.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "com.example.MyApplication2.MESSAGE";
    public boolean log_success = false; // Indica que el user y pass son correctos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login(); // LLamo a la funcion para el logueo.
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void login() {

        Button Login = (Button) findViewById(R.id.btnLogin);
        Login.setOnClickListener (new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                EditText user=(EditText) findViewById(R.id.room);
                String usuario = user.getText().toString();
                EditText pass=(EditText) findViewById(R.id.pass);
                String password = pass.getText().toString();
                String user_stored="123";
                String pass_stored="123";


                if (usuario.equals(user_stored) & password.equals(pass_stored)){

                    log_success=true;
                    findViewById(R.id.badLog).setVisibility(View.INVISIBLE);
                    change_activity();

                }

                else {
                    log_success=false;
                    findViewById(R.id.badLog).setVisibility(View.VISIBLE); // Hago visible el mensaje de error en el user or pass.

                }
            }

        });
        }

    public void change_activity () {
        Intent myIntent = new Intent(getApplicationContext(), LogIn.class);
        startActivity(myIntent); // Cambio de aplicación
    }


}
