package com.k.howtobeagoodkid.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.k.howtobeagoodkid.R;
import com.k.howtobeagoodkid.views.login.LoginActivity;

public class HomeFragment extends Fragment implements View.OnClickListener {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        this.initializeComponent(view);
        return view;
    }

    public void initializeComponent(View view) {
        Button connectionBtn = view.findViewById(R.id.btn_connection);
        Button createAccountBtn = view.findViewById(R.id.btn_create_account);
        connectionBtn.setOnClickListener(this);
        createAccountBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if (v.getId() == R.id.btn_connection) {
            intent = new Intent(this.getContext(), LoginActivity.class);
            this.startActivity(intent);
            System.out.println("toto");
        } else if (v.getId() == R.id.btn_create_account) {
//            intent = new Intent(this.getContext(), CreateAccountActivity.class);
//            this.startActivity(intent);
        }
    }
}
