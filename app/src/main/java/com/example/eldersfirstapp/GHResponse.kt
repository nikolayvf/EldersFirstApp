package com.example.eldersfirstapp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GHResponse (
    @SerialName("total_count") val count: Int,
    val items: List<User>,
)