package com.solo4.klicker.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.solo4.klicker.R
import com.solo4.klicker.data.databases.EnemiesDbRepository
import kotlinx.coroutines.*

class EnemySwipeAdapter(private var enemyPreviewClickListener: OnEnemyPreviewClickListener) :
    RecyclerView.Adapter<EnemySwipeAdapter.PagerViewHolder>() {

    private var enemies = mutableListOf<Enemy>()

    fun enemiesFromDb(level: Int, context: Context) {
        MainScope().launch {
            val repository = EnemiesDbRepository(context)
            enemies = repository.getEnemiesListByLevel(level) as MutableList<Enemy>
            notifyDataSetChanged()
        }
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