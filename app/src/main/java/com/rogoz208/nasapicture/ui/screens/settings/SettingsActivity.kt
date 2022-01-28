package com.rogoz208.nasapicture.ui.screens.settings

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.*
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.nasapicture.R
import com.rogoz208.nasapicture.databinding.ActivitySettingsBinding

const val SHARED_PREFERENCES_KEY = "SHARED_PREFERENCES_KEY"
const val NIGHT_MODE_STATE_KEY = "NIGHT_MODE_STATE_KEY"

class SettingsActivity : AppCompatActivity(R.layout.activity_settings) {

    private val binding by viewBinding(ActivitySettingsBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupActionBar()
        checkCurrentThemeState()
        setupListeners()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupActionBar() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = getString(R.string.settings)
        }
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
        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_KEY, MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(NIGHT_MODE_STATE_KEY, nightMode)
        editor.apply()
    }
}