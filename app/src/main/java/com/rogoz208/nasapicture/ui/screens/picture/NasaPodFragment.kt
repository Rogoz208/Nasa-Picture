package com.rogoz208.nasapicture.ui.screens.picture

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.rogoz208.nasapicture.R
import com.rogoz208.nasapicture.data.app
import com.rogoz208.nasapicture.databinding.FragmentNasaPodBinding

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
        viewModel.nasaPodLiveData.observe(this) { nasaPictureEntity ->
            Glide.with(this).load(nasaPictureEntity.url).into(binding.nasaPictureImageView)
            binding.podDescriptionBottomSheet.podHeaderTextView.text = nasaPictureEntity.title
            binding.podDescriptionBottomSheet.podDescriptionTextView.text =
                nasaPictureEntity.description
            binding.podDescriptionBottomSheet.podDateTextView.text = nasaPictureEntity.date
            binding.podDescriptionBottomSheet.podCopyrightTextView.text =
                "Copyright: ${nasaPictureEntity.copyright}"
        }

        viewModel.getData()
    }
}