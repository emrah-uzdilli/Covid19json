package com.emrahuzdilli.covid19json.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.emrahuzdilli.covid19json.Main2Activity;
import com.emrahuzdilli.covid19json.Models.Bilgi;
import com.emrahuzdilli.covid19json.R;

import java.util.List;

public class BilgiAdapter extends BaseAdapter {
    List<Bilgi> bilgiList;
    Context context;
    Activity activity;


    public BilgiAdapter(List<Bilgi> bilgiList, Context context, Activity activity) {
        this.bilgiList = bilgiList;
        this.context = context;
        this.activity = activity;
    }


    @Override
    public int getCount() {
        return bilgiList.size();
    }

    @Override
    public Object getItem(int position) {


        return bilgiList.get(position);
    }

    @Override
    public long getItemId(int position) {


        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        convertView = LayoutInflater.from(context).inflate(R.layout.layout, parent, false);
        LinearLayout layoutList;
        layoutList = convertView.findViewById(R.id.layoutList);

        TextView infected = convertView.findViewById(R.id.infected);
        TextView tested = convertView.findViewById(R.id.tested);
        TextView deceased = convertView.findViewById(R.id.deceased);
        TextView recovered = convertView.findViewById(R.id.recovered);
        TextView lastUpdatedAtApify = convertView.findViewById(R.id.lastUpdatedAtApify);

        infected.setText(infected.getText() + " " + bilgiList.get(position).getInfected());
        tested.setText(tested.getText() + " " + bilgiList.get(position).getTested());
        deceased.setText(deceased.getText() + " " + bilgiList.get(position).getDeceased());
        recovered.setText(recovered.getText() + " " + bilgiList.get(position).getRecovered());
        lastUpdatedAtApify.setText(lastUpdatedAtApify.getText() + " " + bilgiList.get(position).getLastUpdatedAtApify());

        if (position == 0) {
            final String infectedd, testedd, deceasedd, recoveredd;
            final String lastUpdatedAtApifyd;

            infectedd =""+bilgiList.get(position).getInfected();
            testedd = ""+ bilgiList.get(position).getTested();
            deceasedd = ""+ bilgiList.get(position).getDeceased();
            recoveredd =  ""+bilgiList.get(position).getRecovered();
            lastUpdatedAtApifyd = ""+ bilgiList.get(position).getLastUpdatedAtApify();
            layoutList.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(activity, Main2Activity.class);
                    intent.putExtra("Infected", infectedd);
                    intent.putExtra("Tested", testedd);
                    intent.putExtra("deceased", deceasedd);
                    intent.putExtra("recovered", recoveredd);
                    intent.putExtra("lastUpdatedAtApify", lastUpdatedAtApifyd);

                    activity.startActivity(intent);
                }
            });
        }
        else {

            try {
                Integer infectedd, testedd, deceasedd, recoveredd;
                final String lastUpdatedAtApifyd;


                infectedd = bilgiList.get(position).getInfected() - bilgiList.get(position - 1).getInfected();
                testedd = bilgiList.get(position).getTested() - bilgiList.get(position - 1).getTested();
                deceasedd = bilgiList.get(position).getDeceased() - bilgiList.get(position - 1).getDeceased();
                recoveredd = bilgiList.get(position).getRecovered() - bilgiList.get(position - 1).getRecovered();
                lastUpdatedAtApifyd = bilgiList.get(position).getLastUpdatedAtApify();

                final String infecteddd = String.valueOf(infectedd);
                final String testeddd = String.valueOf(testedd);
                final String deceaseddd = String.valueOf(deceasedd);
                final String recovereddd = String.valueOf(recoveredd);

                layoutList.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(activity, Main2Activity.class);
                        intent.putExtra("Infected", infecteddd);
                        intent.putExtra("Tested", testeddd);
                        intent.putExtra("deceased", deceaseddd);
                        intent.putExtra("recovered", recovereddd);
                        intent.putExtra("lastUpdatedAtApify", lastUpdatedAtApifyd);

                        activity.startActivity(intent);
                    }
                });
            }catch (NullPointerException ignored){

            }
        }

        return convertView;
    }
}

