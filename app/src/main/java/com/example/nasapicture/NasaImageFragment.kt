package com.example.nasapicture

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.nasapicture.databinding.FragmentNasaImageBinding

class NasaImageFragment : Fragment(R.layout.fragment_nasa_image) {

    private val binding by viewBinding(FragmentNasaImageBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}