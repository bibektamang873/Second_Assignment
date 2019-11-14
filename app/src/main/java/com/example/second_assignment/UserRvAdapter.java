package com.example.second_assignment;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.second_assignment.models.User;


import java.util.List;

public class UserRvAdapter extends RecyclerView.Adapter<UserRvAdapter.MyHolder> {

    List<User> users ;
    Context context;

    public UserRvAdapter(Context mContext, List<User> userList) {
        this.context = mContext;
        this.users = userList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_rv_design,parent,false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, final int position) {
        final User user = users.get(position);
        holder.name.setText(user.getFullName());
        holder.rvUserPic.setImageResource(user.getImage());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context, UserProfile.class);
                User user = users.get(position);
                intent.putExtra("name",user.getFullName());
                intent.putExtra("image",user.getImage());
                intent.putExtra("phone",user.getContact());
                intent.putExtra("email",user.getEmail());
                intent.putExtra("country",user.getCountry());
                intent.putExtra("dob",user.getDob());
                intent.putExtra("gender",user.getGender());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        ImageView rvUserPic;
        TextView name;
        RelativeLayout layout;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            rvUserPic = itemView.findViewById(R.id.rvUserPic);
            name = itemView.findViewById(R.id.name);
            layout = itemView.findViewById(R.id.layout);

        }
    }
}
