package com.rogoz208.nasapicture.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.*
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.nasapicture.R
import com.rogoz208.nasapicture.databinding.ActivityMainBinding
import com.rogoz208.nasapicture.ui.screens.planets.PlanetsFragment
import com.rogoz208.nasapicture.ui.screens.pod.NasaPodFragment
import com.rogoz208.nasapicture.ui.screens.settings.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)

    private val fragmentsMap = mapOf(
        R.id.bottom_pod to NasaPodFragment(),
        R.id.bottom_planets to PlanetsFragment(),
        R.id.bottom_settings to SettingsFragment()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBottomNavigation()
        openDefaultScreen(savedInstanceState)
        loadThemeState()

        supportActionBar?.hide()
    }

    private fun initBottomNavigation() {
        binding.bottomNavigationView.setOnItemSelectedListener { item: MenuItem ->
            supportFragmentManager.beginTransaction()
                .replace(
                    binding.fragmentContainer.id,
                    fragmentsMap[item.itemId] ?: throw IllegalStateException("fragment is null")
                )
                .commit()
            true
        }
    }

    private fun openDefaultScreen(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            binding.bottomNavigationView.selectedItemId = R.id.bottom_pod
        }
    }

    private fun loadThemeState() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_KEY, MODE_PRIVATE)
        val nightMode = sharedPreferences.getInt(NIGHT_MODE_STATE_KEY, 0)
        AppCompatDelegate.setDefaultNightMode(nightMode)
    }
}
