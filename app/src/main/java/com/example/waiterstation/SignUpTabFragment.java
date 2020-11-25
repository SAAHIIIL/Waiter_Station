package com.example.waiterstation;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class SignUpTabFragment extends Fragment {

    EditText email, password, mobile, username ;
    Button si;
    float v = 0;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.signup_tab_fragment, container, false);

        email = root.findViewById(R.id.email_s);
        password = root.findViewById(R.id.password_S);
        mobile = root.findViewById(R.id.mobile);
        username = root.findViewById(R.id.username);
        si = root.findViewById(R.id.sign_up);

        email.setTranslationX(800);
        password.setTranslationX(800);
        mobile.setTranslationX(800);
        username.setTranslationX(800);
        si.setTranslationX(800);

        email.setAlpha(v);
        password.setAlpha(v);
        mobile.setAlpha(v);
        username.setAlpha(v);

        si.setAlpha(v);

        email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        mobile.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        username.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
        si.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();

        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DashboardActivity.class);
                startActivity(intent);
            }
        });

        return root;

    }


}
