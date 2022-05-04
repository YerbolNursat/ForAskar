package com.example.myapplication.ui.afterCategory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.FragmentAfterCategoryBinding
import androidx.navigation.fragment.navArgs

class AfterCategoryFragment : Fragment() {

    private val afterCategoryViewModel by lazy { ViewModelProvider(this)[AfterCategoryViewModel::class.java] }

    // внутри твоя айдишка
    private val navArgs: AfterCategoryFragmentArgs by navArgs()

    private var _binding: FragmentAfterCategoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAfterCategoryBinding.inflate(inflater, container, false)
        println(navArgs.id)
        return binding.root
    }

}