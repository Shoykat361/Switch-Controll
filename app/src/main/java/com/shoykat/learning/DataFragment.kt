package com.shoykat.learning

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.shoykat.learning.Adapter.MyAdapter

import com.shoykat.learning.ViewModel.MyViewModel
import com.shoykat.learning.databinding.FragmentDataBinding


class DataFragment : Fragment() {
    private val viewModel: MyViewModel by activityViewModels()
    private lateinit var binding: FragmentDataBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        /*val adapter = Myadapter(viewModel)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter*/
        // Observe the isChecked LiveData to toggle the visibility of the data fragment
        /*viewModel.isChecked.observe(viewLifecycleOwner, Observer { isChecked ->

        })*/
        viewModel.selectedItem.observe(viewLifecycleOwner, Observer { selectedItem ->
            Log.d("DataFragment","This data title ${selectedItem?.title}")
            Log.d("DataFragment","${selectedItem?.isEnabled}")

        })

        viewModel.items.observe(viewLifecycleOwner, Observer {
            //adapter.notifyDataSetChanged()

        })
    }

}