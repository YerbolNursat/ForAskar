package com.example.myapplication.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentGalleryBinding
import com.example.myapplication.ui.afterCategory.AfterCategoryFragment
import com.example.myapplication.ui.afterCategory.AfterCategoryFragmentArgs
import com.example.myapplication.ui.gallery.adapters.GalleryAdapters
import com.example.myapplication.ui.gallery.items.CategoryUi

class GalleryFragment : Fragment() {

    private val galleryViewModel by lazy { ViewModelProvider(this)[GalleryViewModel::class.java] }

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        initObservers()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        galleryViewModel.getCategoryUi()
    }

    private fun initObservers() {
        galleryViewModel.data.observe(viewLifecycleOwner, Observer(::onDataChanged))
        galleryViewModel.toNextPage.observe(viewLifecycleOwner, Observer(::toNextPage))
    }

    private fun onDataChanged(data: List<CategoryUi>) {
        val galleryAdapters = GalleryAdapters(data)
        binding.mainRv.adapter = galleryAdapters
    }

    private fun toNextPage(id: Int) {
        findNavController().navigate(R.id.action_nav_gallery_to_afterCategoryFragment,AfterCategoryFragmentArgs(id).toBundle())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}