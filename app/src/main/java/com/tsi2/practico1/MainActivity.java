package com.tsi2.practico1;

import android.Manifest;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    public static final String USERNAME = "com.example.myfirstapp.MESSAGE";
    public static final String PASSWORD = "com.example.myfirstapp.MESSAGE2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the user taps the Send button
     */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, Login.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        String username = editText.getText().toString();
        String password = editText2.getText().toString();
        intent.putExtra(USERNAME, username);
        intent.putExtra(PASSWORD, password);
        //startActivity(intent);

        AsyncHttpClient client = new AsyncHttpClient();


        //Temporalete la url apunta a google para probar si funcionan los pedidios http
        client.get("https://www.google.com", new AsyncHttpResponseHandler() {




//            @Override
//            public void onStart() {
//                // called before request is started
//            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d("ok", "------------- OK: " +responseBody);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] errorResponse, Throwable e) {
                // called when response HTTP status is "4XX" (eg. 401, 403, 404)
                Log.d("error", "----------------------- ERROR: " + e);
            }

//            @Override
//            public void onRetry(int retryNo) {
//                // called when request is retried
//            }
        });

    }


}

