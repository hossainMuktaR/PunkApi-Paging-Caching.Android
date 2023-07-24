package com.example.composepagingwithcaching.data.remote

import com.example.composepagingwithcaching.data.local.BeerEntity
import com.example.composepagingwithcaching.domain.model.Beer

data class BeerDto(
    val id: Int,
    val name: String,
    val tagline: String,
    val description: String,
    val first_brewed: String,
    val image_url: String?
)
