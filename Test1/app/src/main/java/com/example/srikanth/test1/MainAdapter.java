package com.example.srikanth.test1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Srikanth on 16/08/2017.
 */

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private ArrayList<String> dataSet;
    private Context context;
    TextView resultTextView;

    public MainAdapter(ArrayList<String> dataSet,Context context,TextView tv) {
        this.dataSet = dataSet;
        this.context=context;
        resultTextView=tv;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_textview,parent,false);
        ViewHolder vh =new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mTextView.setText(dataSet.get(position));
        holder.setOnClickListener(new itemClickListner() {
            @Override
            public void  onClick(View view, int position) {
               //Toast.makeText(context, ""+dataSet.get(position), Toast.LENGTH_SHORT).show();
                resultTextView.setText(dataSet.get(position));

            }
        });

    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {
        private String mItem;
        private TextView mTextView;
        private itemClickListner itemClickListnerObj;



        public ViewHolder(View view) {
            super(view);
            mTextView=(TextView)itemView.findViewById(R.id.title);
            view.setOnClickListener(this);
        }
        public void setOnClickListener(itemClickListner itemClickListnerObj)
        {
           this.itemClickListnerObj= itemClickListnerObj;

        }

        public void setItem(String item) {
            mItem = item;
            mTextView.setText(item);
        }

        @Override
        public void onClick(View view) {

            itemClickListnerObj.onClick(view,getAdapterPosition());
        }
    }


}
