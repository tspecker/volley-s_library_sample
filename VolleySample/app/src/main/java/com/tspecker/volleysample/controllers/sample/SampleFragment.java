package com.tspecker.volleysample.controllers.sample;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tspecker.volleysample.R;
import com.tspecker.volleysample.models.Users;
import com.tspecker.volleysample.models.interfaces.IUser;

/**
 * Created by tspecker on 15/12/14.
 */
public class SampleFragment extends Fragment implements View.OnClickListener {

    public static final String TAG = SampleFragment.class.getSimpleName();

    private View rootView;
    private EditText etAlias;
    private EditText etEmail;
    private EditText etPwd;
    private Button btCreateUser;
    private Button btGetUsers;
    private EditText etGetId;
    private Button btGetId;
    private EditText etDeleteId;
    private Button btDeleteId;
    private Users.User user;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.sample_fragment, container, false);

        // init. user variable
        user = new Users().new User();

        findViews();
        setUpView();

        return rootView;
    }

    private void findViews() {
        etAlias = (EditText) rootView.findViewById(R.id.etCreateAlias);
        etEmail = (EditText) rootView.findViewById(R.id.etCreateEmail);
        etPwd = (EditText) rootView.findViewById(R.id.etCreatePwd);
        btCreateUser = (Button) rootView.findViewById(R.id.btCreateUser);
        btGetUsers = (Button) rootView.findViewById(R.id.btGetAllUsers);
        etGetId = (EditText) rootView.findViewById(R.id.etGetUser);
        btGetId = (Button) rootView.findViewById(R.id.btGetUser);
        etDeleteId = (EditText) rootView.findViewById(R.id.etDeleteUser);
        btDeleteId = (Button) rootView.findViewById(R.id.btDeleteUser);
    }

    private void setUpView() {
        etAlias.setText("test");
        etEmail.setText("test@yopmail.com");
        etPwd.setText("test");

        btCreateUser.setOnClickListener(this);
        btGetUsers.setOnClickListener(this);
        btGetId.setOnClickListener(this);
        btDeleteId.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btCreateUser) {
            createUser();
        }
        if (v == btGetUsers) {
            Toast.makeText(this.getActivity(), "TODO", Toast.LENGTH_SHORT).show();
        }
        if (v == btGetId) {
            Toast.makeText(this.getActivity(), "TODO", Toast.LENGTH_SHORT).show();
        }
        if (v == btDeleteId) {
            Toast.makeText(this.getActivity(), "TODO", Toast.LENGTH_SHORT).show();
        }
    }

    private void createUser() {
        String alias = etAlias.getText().toString();
        String email = etEmail.getText().toString();
        String pwd = etPwd.getText().toString();

        user.create(alias, email, pwd, new IUser() {
            // TODO add treatment after receive response
        });

    }
}
