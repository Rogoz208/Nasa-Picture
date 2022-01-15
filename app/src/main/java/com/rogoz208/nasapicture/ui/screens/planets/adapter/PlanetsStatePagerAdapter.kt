package com.rogoz208.nasapicture.ui.screens.planets.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.rogoz208.nasapicture.ui.screens.planets.page.PlanetPageFragment

class PlanetsStatePagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    var items = listOf<PlanetPageType>()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun createFragment(position: Int): Fragment {
        val type = items[position]
        return  PlanetPageFragment.newInstance(type)
    }

}