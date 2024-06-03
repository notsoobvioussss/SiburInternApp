package com.example.myapplication.domain.model

import com.google.gson.annotations.SerializedName

enum class CharacterStatus(val statusName: String) {
    @SerializedName("Dead")
    DEAD("Dead"),

    @SerializedName("Alive")
    ALIVE("Alive"),

    @SerializedName("unknown")
    UNKNOWN("Unknown"),
}