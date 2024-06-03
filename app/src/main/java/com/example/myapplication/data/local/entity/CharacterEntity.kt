package com.example.myapplication.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.myapplication.domain.Data
import com.example.myapplication.domain.model.Character
import com.example.myapplication.domain.model.Location
import com.example.myapplication.domain.model.Origin

@Entity
data class CharacterEntity(
    @PrimaryKey
    val id: Long,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: String,
): Data {
    override fun asDomain(): Character = Character(
        id,
        name,
        status,
        species,
        type,
        gender,
        origin,
        location,
        image,
        episode,
        url,
        created
    )

}