package com.ductran.image;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private Context context;
    private ArrayList<ImageData> imageData;

    public ImageAdapter(Context context, ArrayList<ImageData> imageData) {
        this.context = context;
        this.imageData = imageData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageData item = imageData.get(position);
        holder.tvContent.setText(item.getImageContent());

        Glide.with(context)
                .asBitmap()
                .load(item.getImageUrl())
                .apply(new RequestOptions().override(120, 60).diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return imageData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvContent;
        ImageView img;

        ViewHolder(View itemView) {
            super(itemView);

            tvContent = itemView.findViewById(R.id.tvImageContent);
            img = itemView.findViewById(R.id.imgAvatar);
        }
    }
}
