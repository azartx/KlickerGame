package com.solo4.klicker.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.solo4.klicker.data.EnemySwipeAdapter
import com.solo4.klicker.R
import com.solo4.klicker.data.Enemy
import com.solo4.klicker.databinding.EasyMobsFragmentBinding
import com.solo4.klicker.ui.viewModels.EasyMobsViewModel
import com.solo4.klicker.utils.Constants.ARENA_ACTIVITY
import com.solo4.klicker.utils.Constants.ARENA_ENEMY_LINK
import com.solo4.klicker.utils.Constants.ENEMY_EASY
import com.solo4.klicker.utils.Constants.ENEMY_EASY_STR
import com.solo4.klicker.utils.Constants.ENEMY_HARD
import com.solo4.klicker.utils.Constants.ENEMY_HARD_STR
import com.solo4.klicker.utils.Constants.ENEMY_MEDIUM
import com.solo4.klicker.utils.Constants.ENEMY_MEDIUM_STR

class EasyMobsFragment : Fragment(R.layout.easy_mobs_fragment) {

    private lateinit var viewModel: EasyMobsViewModel
    private lateinit var binding: EasyMobsFragmentBinding
    private lateinit var easyEnemyPreviewAdapter: EnemySwipeAdapter
    private lateinit var onEnemyPreviewClickListener: EnemySwipeAdapter.OnEnemyPreviewClickListener

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = EasyMobsFragmentBinding.bind(view)

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
        easyEnemyPreviewAdapter.enemiesFromDb(getSelectedEnemyLevel(), view.context)
        binding.enemiesEasy.adapter = easyEnemyPreviewAdapter

    }

    private fun getSelectedEnemyLevel(): Int {
        return when {
            arguments?.containsKey(ENEMY_EASY_STR) == true -> ENEMY_EASY
            arguments?.containsKey(ENEMY_MEDIUM_STR) == true -> ENEMY_MEDIUM
            arguments?.containsKey(ENEMY_HARD_STR) == true -> ENEMY_HARD
            else -> 1
        }
    }

    override fun onPause() {
        super.onPause()
        Log.i("FFQQ", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("FFQQ", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("FFQQ", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.i("FFQQ", "onDetach")
    }

}