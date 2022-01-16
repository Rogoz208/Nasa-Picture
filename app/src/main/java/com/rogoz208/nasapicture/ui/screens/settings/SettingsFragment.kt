package com.rogoz208.nasapicture.ui.screens.settings

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.nasapicture.R
import com.rogoz208.nasapicture.databinding.FragmentSettingsBinding

const val SHARED_PREFERENCES_KEY = "SHARED_PREFERENCES_KEY"
const val NIGHT_MODE_STATE_KEY = "NIGHT_MODE_STATE_KEY"

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private val binding by viewBinding(FragmentSettingsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkCurrentThemeState()
        setupListeners()
    }

    private fun checkCurrentThemeState() {
        val currentTheme = AppCompatDelegate.getDefaultNightMode()
        when (currentTheme) {
            AppCompatDelegate.MODE_NIGHT_YES -> binding.darkThemeRadioButton.isChecked = true
            AppCompatDelegate.MODE_NIGHT_NO -> binding.lightThemeRadioButton.isChecked = true
            else -> binding.systemThemeRadioButton.isChecked = true
        }
    }

    private fun setupListeners() {
        binding.selectThemeRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                binding.darkThemeRadioButton.id -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.lightThemeRadioButton.id -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.systemThemeRadioButton.id -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
            }
            saveThemeState()
        }
    }

    private fun saveThemeState() {
        val nightMode = AppCompatDelegate.getDefaultNightMode()
        val sharedPreferences = requireActivity().getSharedPreferences(SHARED_PREFERENCES_KEY, MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(NIGHT_MODE_STATE_KEY, nightMode)
        editor.apply()
    }
}