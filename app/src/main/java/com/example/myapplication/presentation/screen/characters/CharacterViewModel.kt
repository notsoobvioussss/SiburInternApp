package com.example.myapplication.presentation.screen.characters

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.model.Character
import com.example.myapplication.domain.repository.CharacterRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CharacterViewModel(private val repository: CharacterRepository) : ViewModel() {
    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _error: MutableState<String> = mutableStateOf("")
    val error by _error

    private val _characters = MutableStateFlow<List<Character>>(emptyList())
    val characters: StateFlow<List<Character>> = _characters

    private val _currentCharacter: MutableState<Character?> = mutableStateOf(null)
    val currentCharacter by _currentCharacter

    private var page: Int = 1

    fun loadCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = true
            val data = repository.getAllCharacters()
            _characters.value = data
            _isLoading.value = false
        }
    }

    fun getNextPage() {
        page++
        viewModelScope.launch(Dispatchers.IO) {
            _isLoading.value = true
            val data = repository.getAllCharacters(page)
            _characters.value += data
            _isLoading.value = false
        }
    }

    fun updateCharacter(character: Character? = null) {
        _currentCharacter.value = character
    }


}