package com.ziad.shoeinventory

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ziad.shoeinventory.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment : Fragment() {
    lateinit var viewModel: ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentShoeDetailBinding.inflate(inflater)
        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        binding.lifecycleOwner = this
        binding.shoe = viewModel.shoe
        binding.addNewShoeBTn.setOnClickListener{
            if (binding.shoeSizeEDT.text.equals(""))
            {
                Toast.makeText(context, "Please provide size", Toast.LENGTH_SHORT).show()
            }
            else{
                viewModel.addNewShoe()
                findNavController().navigate(
                    ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment()
                )
            }
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}