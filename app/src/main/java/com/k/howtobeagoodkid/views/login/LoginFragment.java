package com.k.howtobeagoodkid.views.login;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.k.howtobeagoodkid.R;

public class LoginFragment extends Fragment implements View.OnClickListener {

    private EditText editPassword;
    private EditText editEmail;
    private TextView errorEmail;
    private ImageView checkEmailIcon;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        this.initializeComponents(view);
        return view;
    }

    public void initializeComponents(View view) {
        this.editPassword = view.findViewById(R.id.input_password);
        this.editEmail = view.findViewById(R.id.input_email);
        this.errorEmail = view.findViewById(R.id.email_error);
        this.errorPassword = view.findViewById(R.id.password_error);
        this.checkEmailIcon = view.findViewById(R.id.check_email_icon);
        this.editEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(s).matches()) {
                    checkEmailIcon.setVisibility(View.VISIBLE);
                    errorEmail.setVisibility(View.INVISIBLE);
                } else {
                    checkEmailIcon.setVisibility(View.INVISIBLE);
                    errorEmail.setVisibility(View.VISIBLE);
                }
            }
        });
        ImageButton seePassword = view.findViewById(R.id.see_password);
        seePassword.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.see_password) {
            if (editPassword.getTransformationMethod() == HideReturnsTransformationMethod.getInstance()) {
                editPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
            } else {
                editPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
        }
    }
}
