package com.example.cart;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Socket;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
    }
    public void Backtohome(View view){
        Intent intent= new Intent(this,HomeActivity.class);
        startActivity(intent);
    }

    public class MainActivity extends Activity {

        TextView textResponse;
        Button buttonConnect;
        EditText welcomeMsg;
        String IpAddress = "192.168.0.117";
        int Port = 8090;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            {

                 {
                    MyClientTask myClientTask = new MyClientTask(welcomeMsg.getText().toString());
                    myClientTask.execute();
                }
            };
        }

        @SuppressLint("StaticFieldLeak")
        public class MyClientTask extends AsyncTask<Void, Void, Void> {
            String response = "";
            String msgToServer;

            MyClientTask(String msgTo) {
                msgToServer = msgTo;
            }

            @Override
            protected Void doInBackground(Void... arg0) {
                Socket socket = null;
                DataOutputStream dataOutputStream = null;
                DataInputStream dataInputStream = null;

                try {
                    socket = new Socket(IpAddress, Port);
                    dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    dataInputStream = new DataInputStream(socket.getInputStream());

                    if(!msgToServer.equals(""))
                        dataOutputStream.writeUTF(msgToServer + "$");

                    response = dataInputStream.readUTF();

                } catch (IOException e) { }
                finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e) {}
                    }
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (IOException e) {}
                    }
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (IOException e) {}
                    }
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                textResponse.setText(response);
                super.onPostExecute(result);
            }
        }
    }

}