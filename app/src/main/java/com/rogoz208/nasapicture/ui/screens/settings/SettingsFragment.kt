package com.rogoz208.nasapicture.ui.screens.settings

import android.animation.*
import android.content.Context.MODE_PRIVATE
import android.graphics.Color
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

    private var defaultTextColor: Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        checkCurrentThemeState()
        defaultTextColor = binding.labelTextView.currentTextColor
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
            changeTheme(checkedId)
        }

        binding.animateButton.setOnClickListener {
            createAnimatorSet()
        }
    }

    private fun changeTheme(checkedId: Int) {
        when (checkedId) {
            binding.darkThemeRadioButton.id -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            binding.lightThemeRadioButton.id -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            binding.systemThemeRadioButton.id -> AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        }
        saveThemeState()
    }

    private fun createAnimatorSet() {
        val animatorSet = AnimatorSet()

        val animators = listOf(createArgbAnimator(), createObjectAnimator())

        animatorSet.playSequentially(animators)

        animatorSet.start()
    }

    private fun createArgbAnimator(): Animator {
        val currentColor = binding.labelTextView.currentTextColor

        val animator = if (currentColor == defaultTextColor) {
            ValueAnimator.ofArgb(currentColor, Color.GREEN)
        } else {
            ValueAnimator.ofArgb(Color.GREEN, defaultTextColor!!)
        }

        animator.duration = 1_000
        animator.startDelay = 500

        animator.addUpdateListener { valueAnimator ->
            val value = valueAnimator.animatedValue as Int
            binding.labelTextView.setTextColor(value)
        }
        return animator
    }

    private fun createObjectAnimator(): Animator {
        val animator = ObjectAnimator.ofFloat(binding.labelTextView, View.TRANSLATION_Y, 0f, 1500f)

        animator.duration = 1500
        animator.repeatMode = ValueAnimator.REVERSE
        animator.repeatCount = 1
        return animator
    }

    private fun saveThemeState() {
        val nightMode = AppCompatDelegate.getDefaultNightMode()
        val sharedPreferences = requireActivity().getSharedPreferences(SHARED_PREFERENCES_KEY, MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(NIGHT_MODE_STATE_KEY, nightMode)
        editor.apply()
    }
}