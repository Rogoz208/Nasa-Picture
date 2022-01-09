package com.rogoz208.nasapicture.ui.screens.picture

import android.content.res.Configuration
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.rogoz208.nasapicture.R
import com.rogoz208.nasapicture.data.app
import com.rogoz208.nasapicture.databinding.FragmentNasaPodBinding
import com.rogoz208.nasapicture.domain.entities.NasaPodEntity
import com.rogoz208.nasapicture.ui.MainActivity

class NasaPodFragment : Fragment(R.layout.fragment_nasa_pod) {

    private val binding by viewBinding(FragmentNasaPodBinding::bind)

    private val viewModel: NasaPodContract.ViewModel by viewModels {
        NasaPodViewModelFactory(requireContext().app.nasaPodRepo)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
    }

    private fun initViewModel() {
        viewModel.nasaPodLiveData.observe(this) {
            displayData(it)
        }

        viewModel.isPodLoadedLiveData.observe(this) {
            showHideProgressBar(it)
        }

        viewModel.getData()
    }

    private fun displayData(nasaPodEntity: NasaPodEntity) {
        Glide.with(this).load(nasaPodEntity.url).into(binding.nasaPodImageView)
        binding.podDescriptionBottomSheet.podHeaderTextView.text = nasaPodEntity.title
        binding.podDescriptionBottomSheet.podDescriptionTextView.text = nasaPodEntity.description
        binding.podDescriptionBottomSheet.podDateTextView.text = nasaPodEntity.date
        val copyrightString = "Copyright: ${nasaPodEntity.copyright}"
        binding.podDescriptionBottomSheet.podCopyrightTextView.text = copyrightString
    }

    private fun showHideProgressBar(isPodLoaded: Boolean) {
        binding.podLoadingProgressBar.isVisible = !isPodLoaded
        binding.podDescriptionBottomSheet.podDescriptionLoadingProgressBar.isVisible = !isPodLoaded
    }
}