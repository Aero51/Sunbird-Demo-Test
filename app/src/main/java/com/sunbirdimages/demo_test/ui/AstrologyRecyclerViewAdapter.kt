package com.sunbirdimages.demo_test.ui

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.sunbirdimages.demo_test.data.AstrologyData

import com.sunbirdimages.demo_test.databinding.AstrologyPictureItemBinding


class AstrologyRecyclerViewAdapter(private val listener: OnItemClickListener):
    ListAdapter<AstrologyData, AstrologyRecyclerViewAdapter.AstrologyViewHolder>(AstrologyComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AstrologyViewHolder {
        val binding =
            AstrologyPictureItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AstrologyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AstrologyViewHolder, position: Int) {
        val currentItem = getItem(position)
        if (currentItem != null) {
            holder.bind(currentItem)
        }
    }

   inner class AstrologyViewHolder(private val binding: AstrologyPictureItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.apply {
                root.setOnClickListener {
                    val position = bindingAdapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        val astrologyData = getItem(position)
                        listener.onItemClick(astrologyData)
                    }
                }

            }
        }


        fun bind(data: AstrologyData) {
            binding.apply {
                Glide.with(itemView)
                    .load(data.url)
                    .into(imageView)

                textViewTitle.text = data.title
                textViewDate.text = data.date

            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(astrologyDataItem: AstrologyData)
    }

    class AstrologyComparator : DiffUtil.ItemCallback<AstrologyData>() {
        override fun areItemsTheSame(oldItem: AstrologyData, newItem: AstrologyData) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: AstrologyData, newItem: AstrologyData) =
            oldItem == newItem
    }
}