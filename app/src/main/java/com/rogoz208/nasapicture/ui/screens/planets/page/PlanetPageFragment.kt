package com.rogoz208.nasapicture.ui.screens.planets.page

import android.os.Bundle
import android.view.View
import androidx.fragment.app.*
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.rogoz208.nasapicture.R
import com.rogoz208.nasapicture.data.app
import com.rogoz208.nasapicture.databinding.FragmentPlanetPageBinding
import com.rogoz208.nasapicture.domain.entities.*
import com.rogoz208.nasapicture.ui.screens.planets.adapter.PlanetPageType

private const val PAGE_TYPE_KEY = "PAGE_TYPE_KEY"

class PlanetPageFragment : Fragment(R.layout.fragment_planet_page) {

    private val binding by viewBinding(FragmentPlanetPageBinding::bind)

    private val viewModel: PlanetPageContract.ViewModel by viewModels {
        PlanetPageViewModelFactory(requireContext().app.nasaPodRepo)
    }

    private val planetPageType by lazy {
        requireArguments().getSerializable(PAGE_TYPE_KEY) as PlanetPageType
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewModel()
    }

    private fun initViewModel() {
        viewModel.planetPictureUrlLiveData.observe(this) { imgSrc ->
            Glide.with(this).load(imgSrc).into(binding.planetImageView)
        }
        viewModel.descriptionLiveData.observe(this) {
            binding.planetTextView.text = "$planetPageType\n$it"
        }
        viewModel.getData(planetPageType)
    }

    companion object {

        fun newInstance(planetPageType: PlanetPageType): PlanetPageFragment {
            val bundle = Bundle()
            bundle.putSerializable(PAGE_TYPE_KEY, planetPageType)

            val fragment = PlanetPageFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}