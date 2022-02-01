package com.kamolovproducts.photoapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kamolovproducts.photoapp.R
import com.kamolovproducts.photoapp.data.ModelPhoto
import com.kamolovproducts.photoapp.databinding.ResItemLiveBinding

class MainAdapter(private val onItemClicked: (ModelPhoto) -> Unit) : RecyclerView.Adapter<MainViewHolder>() {

    private var lives = mutableListOf<ModelPhoto>()

    fun setLiveList(lives: List<ModelPhoto>) {

        this.lives = lives.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ResItemLiveBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val live = lives[position]
        holder.bind(live, onItemClicked)
    }

    override fun getItemCount(): Int {
        return lives.size
    }
}

class MainViewHolder(val binding: ResItemLiveBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(live: ModelPhoto, onItemClicked: (ModelPhoto) -> Unit) {

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)

        Glide.with(itemView.context)
            .applyDefaultRequestOptions(requestOptions)
            .load(live.photoUrl)
            .into(binding.thumbnail)

        itemView.setOnClickListener {
            onItemClicked(live)
        }

    }

}

