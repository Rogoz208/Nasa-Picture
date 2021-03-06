package com.rogoz208.nasapicture.ui

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.*
import by.kirich1409.viewbindingdelegate.viewBinding
import com.rogoz208.nasapicture.R
import com.rogoz208.nasapicture.databinding.ActivityMainBinding
import com.rogoz208.nasapicture.databinding.ActivityMainBinding.inflate
import com.rogoz208.nasapicture.databinding.ActivitySettingsBinding.inflate
import com.rogoz208.nasapicture.databinding.BottomSheetPodDescriptionBinding.inflate
import com.rogoz208.nasapicture.ui.screens.picture.NasaPodFragment
import com.rogoz208.nasapicture.ui.screens.settings.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainer.id, NasaPodFragment())
                .commit()
        }
        loadThemeState()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_dots_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.settings_menu_item) {
            val intent = Intent(this@MainActivity, SettingsActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun loadThemeState() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_KEY, MODE_PRIVATE)
        val nightMode = sharedPreferences.getInt(NIGHT_MODE_STATE_KEY, 0)
        AppCompatDelegate.setDefaultNightMode(nightMode)
    }
}
