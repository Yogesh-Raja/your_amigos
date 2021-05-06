package com.example.yr_youramigos.ui.gallery;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yr_youramigos.R;
import com.example.yr_youramigos.ui.gallery.Level.Data;
import com.example.yr_youramigos.ui.gallery.Level.LevelIndicator;
import com.google.android.material.card.MaterialCardView;

import java.util.ArrayList;

public class MainCustomAdapter extends RecyclerView.Adapter<MainCustomAdapter.Holderclass> {
    private ArrayList<Model> arrayList;
    public MainCustomAdapter(ArrayList<Model> arrayList)
    {
        this.arrayList=arrayList;
    }
    @NonNull
    @Override
    public Holderclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.custom_list_main,parent,false);
        Holderclass holderclass=new Holderclass(view);
        return holderclass;
    }

    @Override
    public void onBindViewHolder(@NonNull Holderclass holder, int position) {
        Model model=arrayList.get(position);
        holder.textView.setText(model.getTitle());
        holder.imageView.setImageResource(model.getId());
        holder.materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), LevelIndicator.class);
                Data.setTitle(model.getTitle());
                Data.setProgress(model.getProgress());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public class Holderclass extends RecyclerView.ViewHolder
    {
        public TextView textView;
        public ImageView imageView;
        public MaterialCardView materialCardView;
        public Holderclass(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.title);
            imageView=itemView.findViewById(R.id.image);
            materialCardView=itemView.findViewById(R.id.card);
        }
    }
}
