package com.shoykat.learning.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shoykat.learning.models.MyItem

/*
class MyViewModel : ViewModel() {
    private val _items = MutableLiveData<List<MyItem>>()
    val items: LiveData<List<MyItem>> = _items

    //shoykat
    private val _isChecked = MutableLiveData<Boolean>()
    val isChecked: LiveData<Boolean> = _isChecked

    private val _dataToShow = MutableLiveData<String>()
    val dataToShow: LiveData<String> = _dataToShow

    init {
        // Initialize your list of items here
        val itemList = listOf(
            MyItem(1,"Item 1", true),
            MyItem(2,"Item 2", false),
            // Add more items as needed
        )
        _items.value = itemList

        // Initialize checked state and data
        _isChecked.value = false
        _dataToShow.value = ""
    }

    fun updateItemState(position: Int, isEnabled: Boolean) {
        val updatedItems = items.value.orEmpty().toMutableList()
        updatedItems[position] = updatedItems[position].copy(isEnabled = isEnabled)
        _items.value = updatedItems


        // Update checked state
        _isChecked.value = isEnabled

        // Update data to show in another fragment based on checked state
        if (isEnabled) {
            _dataToShow.value = "Data to show when the switch is checked"
        } else {
            _dataToShow.value = ""
        }
    }
}*/
class MyViewModel : ViewModel() {
    private val _items = MutableLiveData<List<MyItem>>()
    val items: LiveData<List<MyItem>> = _items

    private val _selectedItem = MutableLiveData<MyItem?>()
    val selectedItem: LiveData<MyItem?> = _selectedItem

    init {
        // Initialize your list of items here
        val itemList = listOf(
            MyItem("Item 1", true),
            MyItem("Item 2", false),
            // Add more items as needed
        )
        _items.value = itemList

        for ((index, item) in itemList.withIndex()) {
            Log.d("MyViewModel", "Item $index: ${item.title}, isEnabled: ${item.isEnabled}")
        }
    }

    fun updateItemState(position: Int, isEnabled: Boolean) {
        val updatedItems = items.value.orEmpty().toMutableList()
        updatedItems[position] = updatedItems[position].copy(isEnabled = isEnabled)
        _items.value = updatedItems
        val updatedItem = updatedItems[position]

        Log.d("MyViewModel", "Item $position: ${updatedItem.title}, isEnabled: ${updatedItem.isEnabled}")
    }

    fun setSelectedItem(item: MyItem?) {
        _selectedItem.value = item
        if (item != null) {
            Log.d("MyViewModel", "this _is ${_selectedItem.value}")
            Log.d("MyViewModel", "this is ${selectedItem.value}")
            Log.d("MyViewModel", "Selected Item: ${item.title}, isEnabled: ${item.isEnabled}")
        } else {
            Log.d("MyViewModel", "No selected item")
        }
    }

    fun clearSelectedItem() {
        _selectedItem.value = null
        Log.d("MyViewModel", "Cleared selected item")
    }

}