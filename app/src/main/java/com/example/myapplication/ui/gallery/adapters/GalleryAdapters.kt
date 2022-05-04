package com.example.myapplication.ui.gallery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemCategoryBinding
import com.example.myapplication.ui.gallery.items.CategoryUi

class GalleryAdapters(private val mList: List<CategoryUi>) :
    RecyclerView.Adapter<GalleryAdapters.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(mList[position])

    override fun getItemCount() = mList.size

    class ViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: CategoryUi) {
            binding.mainImageIv.setImageResource(data.url)
            binding.titleTv.text = data.name
            binding.subtitleTv.text = data.categoryName
            binding.mainCl.setOnClickListener {
                data.actionOnClick.invoke(data.id)
            }
        }
    }
}
