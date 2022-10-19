package com.ziad.shoeinventory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ziad.shoeinventory.databinding.CardItemBinding
import com.ziad.shoeinventory.databinding.FragmentShoeListBinding

class ShoeListFragment : Fragment() {

    lateinit var cardBind: CardItemBinding
    lateinit var bind: FragmentShoeListBinding
    lateinit var viewModel: ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bind = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        viewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]

        viewModel.shoes.observe(viewLifecycleOwner){s ->
            s.forEach{
              addCard(it)
            }

        }

        bind.floatingActionButton.setOnClickListener{
            findNavController().navigate(
                ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment()
            )
        }
        // Inflate the layout for this fragment
        return bind.root
    }

    private fun addCard(shoe: Shoe?){
        val view: View = View.inflate(context, R.layout.card_item, null)
        cardBind = CardItemBinding.bind(view)
        cardBind.shoe = shoe
        bind.mainLayout.addView(cardBind.root)
    }

}