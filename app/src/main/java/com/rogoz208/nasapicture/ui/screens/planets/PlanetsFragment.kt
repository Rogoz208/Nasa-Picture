package com.rogoz208.nasapicture.ui.screens.planets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.nasapicture.R
import com.rogoz208.nasapicture.databinding.FragmentPlanetsBinding

class PlanetsFragment : Fragment(R.layout.fragment_planets) {

    private val binding by viewBinding(FragmentPlanetsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}