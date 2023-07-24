package com.example.composepagingwithcaching.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.composepagingwithcaching.domain.model.Beer

@Entity("Beers")
data class BeerEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val tagline: String,
    val firstBrewed: String,
    val description: String,
    val imageUrl: String?
)
