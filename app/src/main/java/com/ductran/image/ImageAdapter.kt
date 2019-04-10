package com.ductran.image

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_image.view.*

class ImageAdapter(private val context: Activity, private val data: List<ImageModel>) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(context, LayoutInflater.from(context).inflate(R.layout.item_image, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class ImageViewHolder(private val context: Activity, private val containerView: View) : RecyclerView.ViewHolder(containerView) {
        fun bind(item: ImageModel) {
            containerView.tvImageContent.text = item.content
            Glide.with(context)
                    .asBitmap()
                    .load(item.url)
                    .apply(RequestOptions().override(100, 80).diskCacheStrategy(DiskCacheStrategy.ALL))
                    .into(containerView.imgAvatar)
        }
    }

}