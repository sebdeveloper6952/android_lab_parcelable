package com.sebdeveloper6952.lab2_listview_parcelable;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ActivityA extends AppCompatActivity
{
    public static final String USERS_LIST_KEY = "users_list_key";
    protected ListView lvUsers;
    protected Button btnAddUser;
    protected Button btnActivityB;
    protected EditText eTxtName;
    protected EditText eTxtAge;
    protected EditText eTxtAddress;
    protected EditText eTxtCity;
    protected List<ParcelableUser> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_a);
        usersList = new ArrayList<>();
        prepareViews();
    }

    private void prepareViews()
    {
        lvUsers = findViewById(R.id.lView_UsersActA);
        btnAddUser = findViewById(R.id.btn_AddUser);
        btnActivityB = findViewById(R.id.btn_ActivityB);
        eTxtName = findViewById(R.id.eTxt_Name);
        eTxtAge = findViewById(R.id.eTxt_Age);
        eTxtAddress = findViewById(R.id.eTxt_Address);
        eTxtCity = findViewById(R.id.eTxt_City);
        ArrayAdapter<ParcelableUser> adapter = new ArrayAdapter<>(
                ActivityA.this,
                android.R.layout.simple_list_item_1,
                usersList
        );
        lvUsers.setAdapter(adapter);

        btnAddUser.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String name = String.valueOf(eTxtName.getText());
                int age = Integer.parseInt(String.valueOf(eTxtAge.getText()));
                String address = String.valueOf(eTxtAddress.getText());
                String city = String.valueOf(eTxtCity.getText());
                ParcelableUser newUser = new ParcelableUser(name, age, address, city);
                usersList.add(newUser);
            }
        });

        btnActivityB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(ActivityA.this, ActivityB.class);
                intent.putParcelableArrayListExtra(USERS_LIST_KEY,
                        (ArrayList<ParcelableUser>)usersList);
                startActivity(intent);
            }
        });
    }
}
