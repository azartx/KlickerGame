package com.solo4.klicker.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.solo4.klicker.data.EnemySwipeAdapter
import com.solo4.klicker.R
import com.solo4.klicker.data.Enemy
import com.solo4.klicker.databinding.EasyMobsFragmentBinding
import com.solo4.klicker.utils.Constants.ARENA_ACTIVITY
import com.solo4.klicker.utils.Constants.ARENA_ENEMY_LINK

class EasyMobsFragment : Fragment(R.layout.easy_mobs_fragment) {

    private lateinit var viewModel: EasyMobsViewModel
    private lateinit var binding: EasyMobsFragmentBinding
    private lateinit var easyEnemyPreviewAdapter: EnemySwipeAdapter
    private lateinit var onEnemyPreviewClickListener: EnemySwipeAdapter.OnEnemyPreviewClickListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = EasyMobsFragmentBinding.bind(view)

        /**
         * тут будет открываться новое окно с боем с мобом
         */
        onEnemyPreviewClickListener = object : EnemySwipeAdapter.OnEnemyPreviewClickListener {
            override fun onEnemyPreviewClick(enemy: Enemy) {
                val arenaIntent = Intent(requireContext(), ArenaActivity::class.java).apply {
                    putExtra(ARENA_ENEMY_LINK, enemy)
                }

                requireActivity().startActivityFromFragment(
                    this@EasyMobsFragment,
                    arenaIntent,
                    ARENA_ACTIVITY
                )
            }
        }
        easyEnemyPreviewAdapter = EnemySwipeAdapter(onEnemyPreviewClickListener)
        easyEnemyPreviewAdapter.enemiesFromDb(1, view.context)
        binding.enemiesEasy.adapter = easyEnemyPreviewAdapter

    }

}