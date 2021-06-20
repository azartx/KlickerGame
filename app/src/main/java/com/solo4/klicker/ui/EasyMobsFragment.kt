package com.solo4.klicker.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.solo4.klicker.data.EnemySwipeAdapter
import com.solo4.klicker.R
import com.solo4.klicker.databinding.EasyMobsFragmentBinding

class EasyMobsFragment : Fragment(R.layout.easy_mobs_fragment) {

    private lateinit var viewModel: EasyMobsViewModel
    private lateinit var binding: EasyMobsFragmentBinding
    private lateinit var adapter: EnemySwipeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = EasyMobsFragmentBinding.bind(view)
        adapter = EnemySwipeAdapter()
        binding.enemiesEasy.adapter = adapter




    }

}