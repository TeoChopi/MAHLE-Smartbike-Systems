package com.mahle.smartbikesystems.features.character.domain.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mahle.smartbikesystems.core.api.Resource
import com.mahle.smartbikesystems.features.character.domain.model.CharacterDomainModel
import com.mahle.smartbikesystems.features.character.domain.usecase.GetCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val getCharacterUseCase: GetCharacterUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(CharacterState())
    val state = _state.asStateFlow()

    fun getCharacters(id: String) {
        getCharacterUseCase(id).onEach { result ->
            when(result) {
                is Resource.Loading -> _state.value = CharacterState(loading = true)
                is Resource.Success -> _state.value = CharacterState(characterDomainModel = result.data)
                is Resource.Failure -> _state.value = CharacterState(error = result.e)
            }
        }.launchIn(viewModelScope)
    }

    data class CharacterState(
        val loading: Boolean = false,
        val characterDomainModel: CharacterDomainModel? = null,
        val error: Exception? = null
    )
}
