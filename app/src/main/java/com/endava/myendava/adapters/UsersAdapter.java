package com.endava.myendava.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.endava.myendava.R;
import com.endava.myendava.models.User;
import com.endava.myendava.rest.RetrofitClient;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    private final Context mContext;
    private List<User> mUsersList;
    private final OnUserClickListener mListener;

    public UsersAdapter(Context context, List<User> users, OnUserClickListener listener) {
        this.mContext = context;
        this.mUsersList = users;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.bind(mUsersList.get(position), mListener);
    }

    @Override
    public int getItemCount() {
        return mUsersList.size();
    }

    public void setData(List<User> users) {
        mUsersList = users;
        notifyDataSetChanged();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.user_photo_image_view)
        CircleImageView userCircleImageView;
        @BindView(R.id.user_name_text_view)
        TextView userNameTextView;
        @BindView(R.id.user_grade_text_view)
        TextView userGradeTextView;

        UserViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bind(User user, OnUserClickListener listener) {
            Glide.with(mContext).load(RetrofitClient.TEST_URL + user.getImageUrl()).into(userCircleImageView);
            userNameTextView.setText(String.format("%s %s", user.getFirstName(), user.getLastName()));
            userGradeTextView.setText(user.getGrade());
            itemView.setOnClickListener(view -> listener.onUserClicked(user));
        }
    }

    public interface OnUserClickListener {

        void onUserClicked(User user);
    }
}