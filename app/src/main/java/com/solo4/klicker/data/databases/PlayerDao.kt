package com.solo4.klicker.data.databases

import androidx.room.*
import com.solo4.klicker.data.Player

@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addPlayer(player: Player)

    @Query("SELECT * from Player")
    fun getPlayer(): Player

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateAllPlayer(player: Player)

    // обновление имени игрока
    @Query("UPDATE Player SET name =:playerName")
    fun changePlayerName(playerName: String)

    // обновление ХП игрока
    @Query("UPDATE Player SET hp =:hp")
    fun changePlayerHp(hp: Double)

    // обновление армора игрока
    @Query("UPDATE Player SET armor =:armor")
    fun changePlayerArmor(armor: Double)

    // обновление дамаг игрока
    @Query("UPDATE Player SET damage =:damage")
    fun changePlayerDamage(damage: Double)

    // обновление крит игрока
    @Query("UPDATE Player SET criticalRate =:criticalRate")
    fun changePlayerCritRate(criticalRate: Double)

}
