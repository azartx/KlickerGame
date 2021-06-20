package com.solo4.klicker.data

data class User(
    val name: String, var hp: Double, var armor: Double, var damage: Double,  var criticalRate: Double
) {
    var equipment: Equipment? = null
}
