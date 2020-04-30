package com.gmail.ahqksu45.android.profilemanagerm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class MainListAdapter extends ArrayAdapter<ProfileVO> {

    Context context;
    ArrayAdapter<ProfileVO> datas;
    int resId;

    public MainListAdapter(Context context, int resId, ArrayAdapter<ProfileVO> datas) {
        super(context, resId);
        this.context = context;
        this.resId = resId;
        this.datas = datas;


    }

    @Override
    public int getCount() {
        return super.getCount(); //size?
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=inflater.inflate(resId,null);

            MainListWrapper wrapper = new MainListWrapper(convertView);
            convertView.setTag(wrapper);
        }

        MainListWrapper wrapper = (MainListWrapper)convertView.getTag();
        ImageView profileImageView = wrapper.profileImageView;
        TextView nameView = wrapper.nameView;
        final ImageView contactView= wrapper.contactView;

        final ProfileVO vo = datas.get(position);
        nameView.setText(vo.name);



        return convertView;
    }
}











