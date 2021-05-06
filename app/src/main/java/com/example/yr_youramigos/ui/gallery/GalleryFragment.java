package com.example.yr_youramigos.ui.gallery;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.yr_youramigos.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_gallery,null,false);
        ArrayList<Model> arrayList=new ArrayList<>();
        recyclerView=view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MainCustomAdapter mainCustomAdapter=new MainCustomAdapter(arrayList);
        recyclerView.setAdapter(mainCustomAdapter);
        FirebaseDatabase.getInstance().getReference().child("User").child(User.getPh()).child("Sensor").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                int battery=Integer.parseInt(snapshot.child("Battery").getValue().toString());
                int speed=Integer.parseInt(snapshot.child("Speedometer").getValue().toString());
                int engine=Integer.parseInt(snapshot.child("Engine").getValue().toString());
                int wheel=Integer.parseInt(snapshot.child("Wheel").getValue().toString());
                int gear=Integer.parseInt(snapshot.child("Gear").getValue().toString());
                int gas=Integer.parseInt(snapshot.child("Gas").getValue().toString());
                arrayList.clear();
                arrayList.add(new Model("Battery",R.drawable.battery,battery));
                arrayList.add(new Model("SpeedoMeter",R.drawable.dashboard,speed));
                arrayList.add(new Model("Engine",R.drawable.engine,engine));
                arrayList.add(new Model("Wheel",R.drawable.wheel,wheel));
                arrayList.add(new Model("Gear",R.drawable.gear,gear));
                arrayList.add(new Model("Gas",R.drawable.gas,gas));
                mainCustomAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        return view;
    }
}