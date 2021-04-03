package com.emrahuzdilli.covid19json;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.widget.ListView;

import com.emrahuzdilli.covid19json.Adapters.BilgiAdapter;
import com.emrahuzdilli.covid19json.Models.Bilgi;
import com.emrahuzdilli.covid19json.RestApi.ManagerAll;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.ProgressDialog;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    List<Bilgi> bilgiList;
    ListView listView;
    private int progressStatus = 0;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ProgressDialog pd = new ProgressDialog(MainActivity.this);

        // Set progress dialog style spinner
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        // Set the progress dialog title and message
        pd.setTitle("Lütfen Bekleyiniz.");
        pd.setMessage("Loading.........");

        // Set the progress dialog background color
        pd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFD4D9D0")));

        pd.setIndeterminate(false);

        // Finally, show the progress dialog
        pd.show();
        tanimla();
        istek();


        // Set the progress status zero on each button click
        progressStatus = 0;

        // Start the lengthy operation in a background thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progressStatus < 100) {
                    // Update the progress status
                    progressStatus += 1;

                    // Try to sleep the thread for 20 milliseconds
                    try {
                        Thread.sleep(80);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // Update the progress bar
                    handler.post(new Runnable() {
                        @Override
                        public void run() {

                            // Update the progress status
                            pd.setProgress(progressStatus);
                            // If task execution completed
                            if (progressStatus == 100) {
                                // Dismiss/hide the progress dialog
                                pd.dismiss();


                            }
                        }
                    });
                }
            }
        }).start(); // Start the operation


    }

    public void tanimla() {

        listView = findViewById(R.id.list_view);
    }

    public void istek() {

        bilgiList = new ArrayList<>();

        //ManagerAll clasına istek atıyor.getInstance() demeden ManagerAll clasının içindeki getir() fonksiyonuna ulaşmaıypruz
        Call<List<Bilgi>> listCall = ManagerAll.getInstance().getirBilgi();
        listCall.enqueue(new Callback<List<Bilgi>>() {
            @Override
            public void onResponse(Call<List<Bilgi>> call, Response<List<Bilgi>> response) {
                if (response.isSuccessful()) {
                    bilgiList = response.body();

                    BilgiAdapter bilgiAdapter = new BilgiAdapter(bilgiList, getApplicationContext(),MainActivity.this);
                    listView.setAdapter(bilgiAdapter);
                }

            }

            @Override
            public void onFailure(Call<List<Bilgi>> call, Throwable t) {

            }
        });
    }

}
