package com.example.eldersfirstapp.ui.theme

import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class User(val name: String, val age: Int, val email: String)

fun main() {
    val user = User("John Doe", 30, "john.doe@example.com")

    // Serialize to JSON
    val jsonString = Json.encodeToString(user)
    println(jsonString)  // {"name":"John Doe","age":30,"email":"john.doe@example.com"}

    // Deserialize from JSON
    val deserializedUser = Json.decodeFromString<User>(jsonString)
    println(deserializedUser)  // User(name=John Doe, age=30, email=john.doe@example.com)
}