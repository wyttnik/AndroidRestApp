package com.example.drinksapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import coil.load
import com.example.drinksapp.DrinkApplication
import com.example.drinksapp.databinding.DrinkDetailsBinding
import com.example.drinksapp.viewmodels.DetailsViewModel
import com.example.drinksapp.viewmodels.DetailsViewModelFactory

class DetailsFragment: Fragment() {
    private val viewModel: DetailsViewModel by viewModels {
        DetailsViewModelFactory((activity?.application as DrinkApplication).repository, id)
    }

    private var _binding: DrinkDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var id:String

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("testCycleDetails", "onCreate")
        super.onCreate(savedInstanceState)

        arguments?.let {
            id = it.getString("drink_id").toString()
        }
        //viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("testCycleDetails", "onCreateView")
        _binding = DrinkDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("testCycleDetails", "onViewCreated")
        viewModel.drinkDetails.observe(viewLifecycleOwner){
            if (it.isNotEmpty()){
                val drinkDetails = it[0]
                binding.detailDrinkImage.load(drinkDetails.img.toUri().buildUpon().scheme("https").build())
                binding.detailDrinkName.text = drinkDetails.name
                binding.detailDrinkInstruction.text = drinkDetails.instruction
                var ingredientList = ""
                ingredientList += if (drinkDetails.strIngredient1 != null) drinkDetails.strIngredient1 + '\n' else ""
                ingredientList += if (drinkDetails.strIngredient2 != null) drinkDetails.strIngredient2 + '\n' else ""
                ingredientList += if (drinkDetails.strIngredient3 != null) drinkDetails.strIngredient3 + '\n' else ""
                ingredientList += if (drinkDetails.strIngredient4 != null) drinkDetails.strIngredient4 + '\n' else ""
                ingredientList += if (drinkDetails.strIngredient5 != null) drinkDetails.strIngredient5 + '\n' else ""
                ingredientList += if (drinkDetails.strIngredient6 != null) drinkDetails.strIngredient6 + '\n' else ""
                ingredientList += if (drinkDetails.strIngredient7 != null) drinkDetails.strIngredient7 + '\n' else ""
                ingredientList += if (drinkDetails.strIngredient8 != null) drinkDetails.strIngredient8 + '\n' else ""
                ingredientList += if (drinkDetails.strIngredient9 != null) drinkDetails.strIngredient9 + '\n' else ""
                ingredientList += if (drinkDetails.strIngredient10 != null) drinkDetails.strIngredient10 + '\n' else ""
                ingredientList += if (drinkDetails.strIngredient11 != null) drinkDetails.strIngredient11 + '\n' else ""
                ingredientList += if (drinkDetails.strIngredient12 != null) drinkDetails.strIngredient12 + '\n' else ""
                ingredientList += if (drinkDetails.strIngredient13 != null) drinkDetails.strIngredient13 + '\n' else ""
                ingredientList += if (drinkDetails.strIngredient14 != null) drinkDetails.strIngredient14 + '\n' else ""
                ingredientList += if (drinkDetails.strIngredient15 != null) drinkDetails.strIngredient15 + '\n' else ""
                binding.detailDrinkIngredients.text = ingredientList
            }
        }
    }

    override fun onDestroyView() {
        Log.d("testCycleDetails", "onDestroyView")
        super.onDestroyView()
        _binding = null
    }

}