package com.gmail.ahqksu45.android.profilemanagerm;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainListWrapper {

    public ImageView profileImageView;
    public TextView nameView;
    public ImageView contactView;

    public MainListWrapper(View root){
        profileImageView=(ImageView)root.findViewById(R.id.main_item_profile_image);
        nameView= (TextView)root.findViewById(R.id.main_item_name);
        contactView= (ImageView)root.findViewById(R.id.main_item_contact);



    }

}
