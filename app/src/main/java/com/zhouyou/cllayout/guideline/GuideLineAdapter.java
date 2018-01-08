package com.zhouyou.cllayout.guideline;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zhouyou.cllayout.R;
import com.zhouyou.cllayout.entity.User;

import java.util.List;

/**
 * Author: ZhouYou
 * Date: 2018/1/8.
 */
public class GuideLineAdapter extends BaseAdapter {

    private Activity activity;
    private List<User> data;

    public GuideLineAdapter(Activity activity, List<User> data) {
        this.activity = activity;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public User getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_practise_layout_2, null);
            holder = new ViewHolder();
            holder.init(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        User user = getItem(position);
        if (user != null) {
            Uri uri = Uri.parse(user.avatar);
            holder.ivAvatar.setImageURI(uri);
            holder.tvTitle.setText(user.name);
            holder.tvDesc.setText(user.desc);
        }

        return convertView;
    }

    static class ViewHolder {
        SimpleDraweeView ivAvatar;
        TextView tvTitle;
        TextView tvDesc;

        void init(View itemView) {
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDesc = itemView.findViewById(R.id.tv_desc);
        }
    }
}
