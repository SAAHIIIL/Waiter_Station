package com.example.waiterstation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;


public class LoginTabFragment extends Fragment {

    EditText email, password;
    Button login;
    float v = 0;
    private FirebaseAuth mAuth;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.login_tab_fragment, container, false);
        mAuth = FirebaseAuth.getInstance();

        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            Intent intent = new Intent(getActivity(), DashboardActivity.class);
            startActivity(intent);
        } else {
            email = root.findViewById(R.id.email);
            password = root.findViewById(R.id.pass);
            login = root.findViewById(R.id.login_button);

            email.setTranslationX(800);
            password.setTranslationX(800);
            login.setTranslationX(800);

            email.setAlpha(v);
            password.setAlpha(v);
            login.setAlpha(v);

            email.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
            password.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();
            login.animate().translationX(0).alpha(1).setDuration(800).setStartDelay(300).start();

            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), DashboardActivity.class);
                    startActivity(intent);
                }
            });

        }






        return root;




    }
}
