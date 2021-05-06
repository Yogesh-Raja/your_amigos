package com.example.yr_youramigos.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.yr_youramigos.R;
import com.example.yr_youramigos.ui.gallery.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {
    private TextView name,email,ph;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);
        name=root.findViewById(R.id.name);
        email=root.findViewById(R.id.email);
        ph=root.findViewById(R.id.phone);
        FirebaseDatabase.getInstance().getReference().child("User").child(User.getPh()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                name.setText("Name  - "+snapshot.child("name").getValue().toString());
                email.setText("Email  - "+snapshot.child("email").getValue().toString());
                ph.setText("Phone  - "+snapshot.child("phoneNo").getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return root;
    }
}