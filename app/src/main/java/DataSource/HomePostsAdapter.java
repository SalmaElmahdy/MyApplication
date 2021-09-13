package DataSource;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;

import java.util.List;

public class HomePostsAdapter extends RecyclerView.Adapter<HomePostsAdapter.ViewHolder>{
    Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context= parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);

        View postesView= inflater.inflate(R.layout.ticket,parent,false);
        return new ViewHolder(postesView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        HomePosts post=mposts.get(position);
        TextView userName=holder.userName;
        userName.setText(post.getUserName());

        ImageView userImage= holder.userPhoto;
        Glide.with(this.context).load(post.getUserPhoto()).into(userImage);

        ImageView post_image=holder.postPhoto;
        post_image.setVisibility(View.GONE);



    }

    @Override
    public int getItemCount() {
        return mposts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView userName;
        public TextView postDate;
        public TextView postCommentsCount;
        public TextView postDiscription;
        public ImageView userPhoto;
        public ImageView postPhoto;
        public ImageView angerPhoto;
        public ImageView happyPhoto;
        public ImageView lovePhoto;
        public ImageButton postEdit;

        public ViewHolder(View itemView){
            super(itemView);
            userName=(TextView) itemView.findViewById(R.id.useName_txt);
            postDate=(TextView) itemView.findViewById(R.id.datePost_txt);
            postCommentsCount=(TextView) itemView.findViewById(R.id.commentPost_txt);
            postDiscription=(TextView) itemView.findViewById(R.id.postNote_txt);
            userPhoto=(ImageView) itemView.findViewById(R.id.user_imageView);
            postPhoto=(ImageView) itemView.findViewById(R.id.post_image);
            angerPhoto=(ImageView) itemView.findViewById(R.id.anger_image);
            happyPhoto=(ImageView) itemView.findViewById(R.id.happy_image);
            lovePhoto=(ImageView) itemView.findViewById(R.id.love_image);
            postEdit=(ImageButton) itemView.findViewById(R.id.edit_btn);
        }


    }

    private List<HomePosts> mposts;

    public HomePostsAdapter(List<HomePosts> posts) {
        this.mposts = posts;
    }

}
