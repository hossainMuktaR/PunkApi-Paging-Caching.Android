package com.example.composepagingwithcaching.data.mappers

import com.example.composepagingwithcaching.data.local.BeerEntity
import com.example.composepagingwithcaching.data.remote.BeerDto
import com.example.composepagingwithcaching.domain.model.Beer

fun BeerEntity.toBeer(): Beer {
    return Beer(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = firstBrewed,
        imageUrl = imageUrl
    )
}

fun BeerDto.toBeerEntity(): BeerEntity {
    return BeerEntity(
        id = id,
        name = name,
        tagline = tagline,
        description = description,
        firstBrewed = first_brewed,
        imageUrl = image_url
    )
}