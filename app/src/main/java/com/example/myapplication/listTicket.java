package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.Image;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import DataSource.HomePosts;
import DataSource.HomePostsAdapter;
import butterknife.ButterKnife;

public class listTicket extends AppCompatActivity {



    ArrayList<HomePosts> posts;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_ticket);
        ButterKnife.bind(this);

        RecyclerView rvPosts=(RecyclerView) findViewById(R.id.rvContacts);

        posts= this.createContactsList(4);

        HomePostsAdapter adapter =new HomePostsAdapter(posts);

        rvPosts.setAdapter(adapter);

        rvPosts.setLayoutManager(new LinearLayoutManager(this));


    }

    public static ArrayList<HomePosts> createContactsList(int numContacts) {

        ArrayList<String>images=new ArrayList<>();
        images.add("https://img.freepik.com/free-vector/cute-baby-deer_159446-437.jpg?size=338&ext=jpg");
        images.add("https://images.all-free-download.com/images/graphiclarge/baby_looney_tunes_vector_287304.jpg");

        int lastPostId = 0;
        ArrayList<HomePosts> homePosts = new ArrayList<HomePosts>();

        for (int i = 1; i <= numContacts; i++) {
            for(int j=0;j<images.size();j++)
            {
                homePosts.add(new HomePosts("Person " + ++lastPostId,images.get(j)));
                i++;
            }

        }

        return homePosts;
    }
}