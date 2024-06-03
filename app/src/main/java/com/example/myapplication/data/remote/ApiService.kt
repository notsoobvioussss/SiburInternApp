package com.example.myapplication.data.remote

import com.example.myapplication.domain.model.CharactersResponseFull
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") page: Int
    ) : CharactersResponseFull
}