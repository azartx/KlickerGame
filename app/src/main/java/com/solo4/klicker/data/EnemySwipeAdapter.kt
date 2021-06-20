package com.solo4.klicker.data

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.solo4.klicker.R

class EnemySwipeAdapter : RecyclerView.Adapter<PagerViewHolder>() {

    val enemies = mutableListOf<Enemy>().apply {
        add(Enemy("asd", "asd", R.drawable.enemy_easy_rabbit, 1.1, 1.1, 1.1))
        add(Enemy("sdf", "asd", R.drawable.enemy_easy_bear, 1.1, 1.1, 1.1))
        add(Enemy("sdf", "asd", R.drawable.enemy_easy_boss, 1.1, 1.1, 1.1))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PagerViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_enemy_pager, parent, false)
    )

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(enemies[position])
    }

    override fun getItemCount() = enemies.size
}

class PagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(enemy: Enemy) {
        itemView.findViewById<ImageView>(R.id.ImageEnemyContainer).setImageResource(enemy.image)
    }

}
