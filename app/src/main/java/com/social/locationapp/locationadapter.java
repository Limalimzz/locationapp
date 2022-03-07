package com.social.locationapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class locationadapter extends RecyclerView.Adapter<locationadapter.ViewHolder>  implements Filterable   {
    Context c;
    List<locationmodel> datamodelList;
    private List<locationmodel> exampleListFull;
    String distance,  name, addess_1,  address_2,  pincode,  mobile,telephone_1,telephone_2,comm_email,alt_email,website,reservation_link,place,image;
    public locationadapter(Context c, List<locationmodel> datamodelList) {
        this.c = c;
        this.datamodelList = datamodelList;
        exampleListFull = new ArrayList<>(datamodelList);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(c);
        View view = inflater.inflate(R.layout.locationlist, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final locationmodel data = datamodelList.get(position);

        holder.name.setText(data.getName());
        holder.website.setText(data.getWebsite());
        distance=data.getDistance();
        name=data.getName();
        addess_1=data.getAddess_1();
        address_2=data.getAddress_2();
        pincode=data.getPincode();
        mobile=data.getMobile();
        telephone_1=data.getTelephone_1();
        telephone_2=data.getTelephone_2();
        comm_email=data.getComm_email();
        alt_email=data.getAlt_email();
        website=data.getWebsite();
        reservation_link=data.getReservation_link();
        place=data.getPlace();
        image=data.getImage();

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(c,locationfulldetails.class);
                in.putExtra("distance",distance);
                in.putExtra("name",name);
                in.putExtra("address1",addess_1);
                in.putExtra("address2",address_2);
                in.putExtra("pincode",pincode);
                in.putExtra("mobile",mobile);
                in.putExtra("telephone1",telephone_1);
                in.putExtra("telephone2",telephone_2);
                in.putExtra("commemail",comm_email);
                in.putExtra("altemail",alt_email);
                in.putExtra("website",website);
                in.putExtra("relink",reservation_link);
                in.putExtra("place",place);
                in.putExtra("image",image);
                c.startActivity(in);
            }
        });


    }
    @Override
    public Filter getFilter() {
        return exampleFilter;
    }
    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<locationmodel> filteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(exampleListFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (locationmodel item : exampleListFull) {
                    if (item.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            datamodelList.clear();
            datamodelList.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
    @Override
    public int getItemCount() {
        return datamodelList.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,website;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name=(itemView).findViewById(R.id.name);
            cardView=(itemView).findViewById(R.id.main_container);
            website=(itemView).findViewById(R.id.website);
        }
    }
}
