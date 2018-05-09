package com.sebdeveloper6952.lab2_listview_parcelable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ActivityB extends AppCompatActivity
{
    protected ListView lvUsers;
    protected List<ParcelableUser> usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_b);
        // get users from bundle
        usersList = getIntent().getParcelableArrayListExtra(ActivityA.USERS_LIST_KEY);
        prepareViews();
    }

    private void prepareViews()
    {
        lvUsers = findViewById(R.id.lView_UsersActB);
        ArrayAdapter<ParcelableUser> adapter = new ArrayAdapter<>(
                ActivityB.this,
                android.R.layout.simple_list_item_1,
                usersList
        );
        lvUsers.setAdapter(adapter);
    }
}
