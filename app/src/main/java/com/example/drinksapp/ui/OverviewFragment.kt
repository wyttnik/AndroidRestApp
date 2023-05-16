package com.example.drinksapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.drinksapp.DrinkApplication
import com.example.drinksapp.adapter.DrinkGridAdapter
import com.example.drinksapp.databinding.FragmentOverviewBinding
import com.example.drinksapp.viewmodels.CocktailViewModel
import com.example.drinksapp.viewmodels.CocktailViewModelFactory

class OverviewFragment : Fragment() {
    private val viewModel: CocktailViewModel by viewModels {
        CocktailViewModelFactory((activity?.application as DrinkApplication).repository)
    }
    private var binding: FragmentOverviewBinding? = null
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("testCycleOverview", "onCreateView")
        binding = FragmentOverviewBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("testCycleOverview", "onViewCreated")
        recyclerView = binding!!.drinksGrid

        val adapter = DrinkGridAdapter { clickOnActionHandler(it) }
        recyclerView.adapter = adapter

        viewModel.drinks.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        Log.d("testCycleOverview", "onViewStateRestored")
        super.onViewStateRestored(savedInstanceState)

        viewModel.updateDrinks()
    }

    private fun clickOnActionHandler(id:String) {
        val action = OverviewFragmentDirections.actionOverviewFragmentToDetailsFragment(id)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        Log.d("testCycleOverview", "onDestroyView")
        super.onDestroyView()
        binding = null
    }
}