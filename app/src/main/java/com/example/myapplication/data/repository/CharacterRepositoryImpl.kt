package com.example.myapplication.data.repository

import com.example.myapplication.data.local.dao.CharacterDao
import com.example.myapplication.data.remote.ApiService
import com.example.myapplication.domain.model.Character
import com.example.myapplication.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val apiService: ApiService,
    private val characterDao: CharacterDao
) : CharacterRepository {
    override suspend fun getAllCharacters(page: Int): List<Character> {
        val data = characterDao.getCharacters((page - 1) * 20)
            .map { it.asDomain() }
            .ifEmpty {
                val apiData = apiService.getAllCharacters(page).results
                characterDao.setCharacters(apiData.map { it.asData() })
                apiData
            }
        return data
    }
}