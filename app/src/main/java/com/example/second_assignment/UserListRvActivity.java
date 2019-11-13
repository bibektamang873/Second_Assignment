package com.example.second_assignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.second_assignment.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserListRvActivity extends AppCompatActivity {
    RecyclerView userRvList;
    List<User> users = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list_rv);

        userRvList = findViewById(R.id.rvUsers);
        Intent i = getIntent();
        users = (List<User>) i.getSerializableExtra("allusers");
        UserRvAdapter adapter = new UserRvAdapter(this,users);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        userRvList.setLayoutManager(layoutManager);
        userRvList.setAdapter(adapter);
    }
}
