package com.example.eldersfirstapp.Repositories
import com.example.eldersfirstapp.GHResponse
import com.example.eldersfirstapp.User
import com.example.eldersfirstapp.utils.jsonInstance
import kotlinx.coroutines.suspendCancellableCoroutine
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.inject.Inject
import kotlin.coroutines.resume


class MainRepository @Inject constructor(private val httpClient: OkHttpClient) {

    fun getData(): List<String> {
        return listOf("1", "2", "3")
    }

    suspend fun getItems(query: String): List<User> {

        return suspendCancellableCoroutine { continuation ->

            val request = Request.Builder()
                .url("api.github.com/search/users?q=$query")
                .get()
                .build()

            val response = httpClient.newCall(request).execute()

            val ghResponse: GHResponse = jsonInstance.decodeFromString(response.body.toString())

            continuation.resume(ghResponse.items)
        }
    }
}


fun searchGitHubUsers(){
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("api.github.com/search/users?q=test")
            .build()
        val response = client.newCall(request).execute()

}

