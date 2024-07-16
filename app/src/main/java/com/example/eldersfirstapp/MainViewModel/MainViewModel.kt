package com.example.eldersfirstapp.MainViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.eldersfirstapp.Repositories.MainRepository
import com.example.eldersfirstapp.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {

    private var _data: MutableStateFlow<List<User>> = MutableStateFlow(emptyList())
    val data: MutableStateFlow<List<User>> = _data

    fun getData(): List<String> {
        return repository.getData()
    }
    fun getSearchResults(query: String) {
        viewModelScope.launch{
            try {
                //val results = repository.getItems(query)
                //_data.emit(results)
                val results = repository.getItems(query)
                _data.emit(results)
            } catch (e:Throwable){
                //TODO: error handling
            }

        }
    }
}

