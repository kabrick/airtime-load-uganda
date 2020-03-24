package com.kabricks.loadairtimeuganda.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kabricks.loadairtimeuganda.R;
import com.kabricks.loadairtimeuganda.activities.ScanAirtime;
import com.kabricks.loadairtimeuganda.model.Networks;

import java.util.List;

public class NetworksAdapter extends RecyclerView.Adapter<NetworksAdapter.ViewHolder> {

    private String[] networkname = {
            "Airtel Uganda","MTN Uganda","Vodafone","Africell","Uganda Telecom","Smart Telecom"
    };

    private String[] slogan = {
            "The smartphone network","Everywhere you go","Live life on 4G","Afrisoul Afriheart Afribeat","Its all about you","Let's talk"
    };

    private String[] intentextraname = {
            "airtel", "mtn", "vodafone", "africell", "utl", "smart"
    };

    private int[] logo = {
            R.drawable.airtel, R.drawable.mtn, R.drawable.vodafone, R.drawable.africell, R.drawable.utl, R.drawable.smart_tel
    };

    Context context;

    public NetworksAdapter(Context context){
        super();
        this.context = context;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView itemImage;
        public TextView itemName;
        public TextView itemSlogan;
        public ViewHolder(View itemView) {
            super(itemView);
            itemImage =
                    (ImageView)itemView.findViewById(R.id.imageView2);
            itemName =
                    (TextView)itemView.findViewById(R.id.networkname);
            itemSlogan =
                    (TextView)itemView.findViewById(R.id.slogan);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.networks_list_layout, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int i) {
        holder.itemSlogan.setText(slogan[i]);
        holder.itemName.setText(networkname[i]);
        holder.itemImage.setImageResource(logo[i]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ScanAirtime.class);
                intent.putExtra("network_name", intentextraname[i]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return networkname.length;
    }
}
