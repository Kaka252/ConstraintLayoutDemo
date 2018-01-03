package com.zhouyou.cllayout.practice.adapter;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zhouyou.cllayout.R;
import com.zhouyou.cllayout.utils.Avatars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author: ZhouYou
 * Date: 2018/1/3.
 */
public class ItemListAdapter extends BaseAdapter {

    private Activity activity;
    private List<String> users;

    public ItemListAdapter(Activity activity) {
        this.activity = activity;
        users = new ArrayList<>();
        users.addAll(Arrays.asList(Avatars.AVATARS));
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public String getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_practise_layout_1, null);
            holder = new ViewHolder();
            holder.init(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        String url = getItem(position);
        Uri uri = Uri.parse(url);
        holder.ivAvatar.setImageURI(uri);
        return convertView;
    }

    static class ViewHolder {
        SimpleDraweeView ivAvatar;

        void init(View itemView) {
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
        }
    }
}
