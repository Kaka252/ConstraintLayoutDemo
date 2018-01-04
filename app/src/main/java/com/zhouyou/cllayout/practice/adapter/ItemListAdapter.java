package com.zhouyou.cllayout.practice.adapter;

import android.app.Activity;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.zhouyou.cllayout.R;
import com.zhouyou.cllayout.base.App;
import com.zhouyou.cllayout.entity.User;
import com.zhouyou.cllayout.utils.Scale;
import com.zhouyou.cllayout.view.BalanceTextLayout;

import java.util.List;

/**
 * Author: ZhouYou
 * Date: 2018/1/3.
 */
public class ItemListAdapter extends BaseAdapter {

    private Activity activity;
    private List<User> users;

    public ItemListAdapter(Activity activity, List<User> users) {
        this.activity = activity;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public User getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(activity).inflate(R.layout.item_practise_layout_1, null);
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
            holder.tvUserName.setText(user.name);

            int screenWidth = App.get().getDisplayWidth();
            int layoutWidth = screenWidth - Scale.dip2px(activity, 48) - Scale.dip2px(activity, 50 + 15) - Scale.dip2px(activity, 20);
            holder.balanceTextLayout.calculate(layoutWidth);
        }

        return convertView;
    }

    static class ViewHolder {
        TextView tvUserName;
        SimpleDraweeView ivAvatar;
        BalanceTextLayout balanceTextLayout;

        void init(View itemView) {
            tvUserName = itemView.findViewById(R.id.tv_user_name);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            balanceTextLayout = itemView.findViewById(R.id.balance_layout);
        }
    }
}
