package com.rogoz208.nasapicture.ui.screens.planets

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.nasapicture.R
import com.rogoz208.nasapicture.databinding.FragmentPlanetsBinding
import com.rogoz208.nasapicture.ui.screens.planets.adapter.*

class PlanetsFragment : Fragment(R.layout.fragment_planets) {

    private val binding by viewBinding(FragmentPlanetsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViewPager()
    }

    private fun initViewPager() {
        val adapter = PlanetsStatePagerAdapter(this)
        adapter.items = PlanetPageType.values().toList()
        binding.planetsViewPager.adapter = adapter
        binding.planetsViewPager.isSaveEnabled = false
    }
}