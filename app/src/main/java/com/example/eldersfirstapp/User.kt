package com.example.eldersfirstapp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("name") val name: String,
    @SerialName("avatar_url") val img: String
)


