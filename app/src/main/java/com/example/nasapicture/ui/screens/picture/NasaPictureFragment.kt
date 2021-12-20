package com.example.nasapicture.ui.screens.picture

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.nasapicture.R
import com.example.nasapicture.databinding.FragmentNasaPictureBinding

class NasaPictureFragment : Fragment(R.layout.fragment_nasa_picture) {

    private val binding by viewBinding(FragmentNasaPictureBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}