package com.shoykat.learning.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shoykat.learning.ViewModel.MyViewModel
import com.shoykat.learning.databinding.ItemLayoutBinding
import com.shoykat.learning.models.MyItem

/*
class Myadapter2(private val viewModel: MyViewModel) : RecyclerView.Adapter<Myadapter2.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyItem, position: Int) {
            binding.apply {
                titleTextView.text = item.title
                switchButton.isChecked = item.isEnabled
                switchButton.setOnCheckedChangeListener { _, isChecked ->
                    val item = viewModel.setSelectedItem(item)
                    */
/*if (isChecked) {
                        viewModel.setSelectedItem(item)
                    } else {
                        viewModel.clearSelectedItem()
                    }*//*

                    viewModel.updateItemState(position, isChecked)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myadapter2.ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = viewModel.items.value?.get(position) ?: return
        holder.bind(item, position)
    }

    override fun getItemCount(): Int {
        return viewModel.items.value?.size ?: 0
    }
}
*/
