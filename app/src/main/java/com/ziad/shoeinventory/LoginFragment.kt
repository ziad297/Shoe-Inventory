package com.ziad.shoeinventory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.ziad.shoeinventory.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var bind: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = FragmentLoginBinding.inflate(inflater)
        bind.loginButton.setOnClickListener {
            if(bind.welcomeBackTextView.text.equals(""))
                Toast.makeText(context, "Please enter a password", Toast.LENGTH_SHORT).show()
            else{
                findNavController().navigate(
                    LoginFragmentDirections.actionLoginFragmentToWelcomeFragment()
                )
            }
        }
        // Inflate the layout for this fragment
        return bind.root
    }
}