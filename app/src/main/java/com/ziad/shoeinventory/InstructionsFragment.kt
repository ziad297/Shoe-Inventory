package com.ziad.shoeinventory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.ziad.shoeinventory.databinding.FragmentInstructionsBinding


class InstructionsFragment : Fragment() {
   lateinit var bind : FragmentInstructionsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind = FragmentInstructionsBinding.inflate(inflater)
        bind.btNext.setOnClickListener{
            findNavController().navigate(
               InstructionsFragmentDirections.actionInstructionsFragmentToShoeListFragment()
            )
    }

   return bind.root
}
}