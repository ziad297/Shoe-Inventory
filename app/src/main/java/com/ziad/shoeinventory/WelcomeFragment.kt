package com.ziad.shoeinventory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ziad.shoeinventory.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    private lateinit var bind: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentWelcomeBinding.inflate(inflater)
        bind.conToInstructButton.setOnClickListener{
            findNavController().navigate(
                WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment()
            )
        }
        // Inflate the layout for this fragment
        return bind.root
    }

}