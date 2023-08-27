package com.shoykat.learning.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.shoykat.learning.R
import com.shoykat.learning.ViewModel.MyViewModel
import com.shoykat.learning.databinding.ItemLayoutBinding
import com.shoykat.learning.models.MyItem

/*
class MyAdapter(private val viewModel: MyViewModel,private val navController: NavController) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyItem, position: Int) {
            binding.apply {
                titleTextView.text = item.title
                switchButton.isChecked = item.isEnabled
                */
/*if (item.isEnabled) {
                    // If the switch button is enabled, hide data views
                    titleTextView.visibility = View.GONE
                } else {
                    // If the switch button is disabled, show data views
                    titleTextView.visibility = View.VISIBLE
                }*//*

                switchButton.setOnCheckedChangeListener { _, isChecked ->
                    viewModel.updateItemState(position, isChecked)
                    if (isChecked) {
                        binding.switchButton.setOnClickListener {
                            navController.navigate(R.id.action_listFragment_to_dataFragment)
                        }
                        //titleTextView.visibility = View.GONE
                    } else {
                        titleTextView.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
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
}*/
class MyAdapter(private val viewModel: MyViewModel) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MyItem, position: Int) {
            binding.apply {
                titleTextView.text = item.title
                switchButton.isChecked = item.isEnabled
                switchButton.setOnCheckedChangeListener { _, isChecked ->
                    val item = viewModel.items.value?.get(position)
                    if (isChecked) {
                        viewModel.setSelectedItem(item)
                    } else {
                        viewModel.clearSelectedItem()
                    }
                    //viewModel.updateItemState(position, isChecked)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
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
