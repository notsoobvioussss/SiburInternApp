package com.example.myapplication.domain.repository

import com.example.myapplication.domain.model.Character

interface CharacterRepository {
    suspend fun getAllCharacters(page: Int = 1): List<Character>
}