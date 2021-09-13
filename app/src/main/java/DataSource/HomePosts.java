package DataSource;

import android.provider.ContactsContract;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Date;
public class HomePosts {
    String userName;
    int loveCount;
    int angerCount;
    int happyCount;
    String contentText;
    String contentPhoto;
    String userPhoto;
    Date c;

    public HomePosts(String userName, String userPhoto)
    {
        this.userName=userName;
        this.userPhoto=userPhoto;

    }


    public String getUserName() {
        return userName;
    }

   public String getUserPhoto()
   {
       return userPhoto;
   }
}
