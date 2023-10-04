package com.mahle.smartbikesystems.features.characters.domain.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahle.smartbikesystems.core.api.Resource
import com.mahle.smartbikesystems.features.characters.domain.model.CharactersDomainModel
import com.mahle.smartbikesystems.features.characters.domain.usecase.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(CharactersState())
    val state = _state.asStateFlow()

    fun getCharacters() {
        getCharactersUseCase().onEach { result ->
            when(result) {
                is Resource.Loading -> _state.value = CharactersState(loading = true)
                is Resource.Success -> _state.value = CharactersState(charactersDomainModel = result.data)
                is Resource.Failure -> _state.value = CharactersState(error = result.e)
            }
        }.launchIn(viewModelScope)
    }

    data class CharactersState(
        val loading: Boolean = false,
        val charactersDomainModel: CharactersDomainModel? = null,
        val error: Exception? = null
    )
}
