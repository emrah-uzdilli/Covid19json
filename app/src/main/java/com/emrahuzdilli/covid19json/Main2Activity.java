package com.emrahuzdilli.covid19json;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    String deceased,infected,tested,recovered;
    String lastUpdatedAtApify,infectedd,testedd,deceasedd,recoveredd;



    TextView infect,test,deceas,recover,lastUpdatedAtApi;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tanimla();
        al();


    }
    public void tanimla(){
        infect = findViewById(R.id.infecteddd);
        test = findViewById(R.id.testeddd);
        deceas = findViewById(R.id.deceaseddd);
        recover = findViewById(R.id.recovereddd);
        lastUpdatedAtApi = findViewById(R.id.lastUpdatedAtApifydd);

        button=findViewById(R.id.button);

    }

    public void al(){
        Bundle bundle = getIntent().getExtras();

        infected = bundle.getString("Infected");
        tested = bundle.getString("Tested");
        deceased = bundle.getString("deceased");
        recovered =bundle.getString("recovered");
        lastUpdatedAtApify = bundle.getString("lastUpdatedAtApify");

        infectedd=String.valueOf(infected);
        testedd=String.valueOf(tested);
        deceasedd=String.valueOf(deceased);
        recoveredd=String.valueOf(recovered);




            infect.setText("VAKA SAYISI:" + infectedd);
            test.setText("TEST SAYISI:" + testedd);
            deceas.setText("VEFAT SAYISI:" + deceasedd);
            recover.setText("İYLEŞEN SAYISI:" + recoveredd);
            lastUpdatedAtApi.setText("GÜN:" + lastUpdatedAtApify);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
                    startActivity(intent);


                }
            });



       // Log.i("xxxxxx","INFECTED:"+infected+" , "+"TESTED:"+tested);

    }

}
