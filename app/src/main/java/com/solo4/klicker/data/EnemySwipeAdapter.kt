package com.solo4.klicker.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.solo4.klicker.R

class EnemySwipeAdapter(private var enemyPreviewClickListener: OnEnemyPreviewClickListener) :
    RecyclerView.Adapter<EnemySwipeAdapter.PagerViewHolder>() {

    private val enemies = mutableListOf<Enemy>().apply {
        add(Enemy("Заяц", "Заяц", R.drawable.enemy_easy_rabbit, 1.1, 1.1, 1.1, false))
        add(Enemy("шото ам", "шото ам", R.drawable.enemy_easy_bear, 1.1, 1.1, 1.1, false))
        add(Enemy("мишаня босс", "мишаня босс", R.drawable.enemy_easy_boss, 1.1, 1.1, 1.1, false))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_enemy_pager, parent, false)
    )

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(enemies[position], enemyPreviewClickListener)
    }

    override fun getItemCount() = enemies.size

    class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageRes: ImageView = itemView.findViewById(R.id.ImageEnemyContainer)
        fun bind(enemy: Enemy, enemyPreviewClickListener: OnEnemyPreviewClickListener) {
            imageRes.apply {
                setImageResource(enemy.image)
                setOnClickListener {
                    enemyPreviewClickListener.onEnemyPreviewClick(enemy)
                }
            }
        }
    }

    interface OnEnemyPreviewClickListener {
        fun onEnemyPreviewClick(enemy: Enemy)
    }
}