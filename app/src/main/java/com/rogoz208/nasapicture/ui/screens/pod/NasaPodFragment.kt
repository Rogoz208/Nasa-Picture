package com.rogoz208.nasapicture.ui.screens.pod

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.*
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.rogoz208.nasapicture.R
import com.rogoz208.nasapicture.data.app
import com.rogoz208.nasapicture.databinding.FragmentNasaPodBinding
import com.rogoz208.nasapicture.domain.entities.NasaPodEntity

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

        viewModel.spannableTextLiveData.observe(this) { text ->
            binding.podDescriptionBottomSheet.podCopyrightTextView.text = text
            binding.podDescriptionBottomSheet.podCopyrightTextView.movementMethod =
                LinkMovementMethod.getInstance()
        }

        viewModel.messageTextLiveData.observe(this) { message ->
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
        }

        viewModel.getData()
    }

    private fun displayData(nasaPodEntity: NasaPodEntity) {
        Glide.with(this).load(nasaPodEntity.url).into(binding.nasaPodImageView)
        binding.podDescriptionBottomSheet.podHeaderTextView.text = nasaPodEntity.title
        binding.podDescriptionBottomSheet.podDescriptionTextView.text = nasaPodEntity.description
        binding.podDescriptionBottomSheet.podDateTextView.text = nasaPodEntity.date
    }

    private fun showHideProgressBar(isPodLoaded: Boolean) {
        binding.podLoadingProgressBar.isVisible = !isPodLoaded
        binding.podDescriptionBottomSheet.podDescriptionLoadingProgressBar.isVisible = !isPodLoaded
    }
}