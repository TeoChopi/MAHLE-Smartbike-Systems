package com.mahle.smartbikesystems.features.characters.domain.usecase

import com.mahle.smartbikesystems.core.api.Resource
import com.mahle.smartbikesystems.features.characters.data.model.ResponseCharactersDataModel
import com.mahle.smartbikesystems.features.characters.data.model.toCharters
import com.mahle.smartbikesystems.features.characters.data.repository.CharactersRepository
import com.mahle.smartbikesystems.features.characters.domain.model.CharactersDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val repository: CharactersRepository
) {

    operator fun invoke(): Flow<Resource<CharactersDomainModel>> = flow {
        try {
            emit(Resource.Loading())
            val result: ResponseCharactersDataModel = repository.getCharacters()
            emit(Resource.Success(result.toCharters()))
        } catch (e: HttpException) {
            emit(Resource.Failure(e))
        } catch (e: IOException) {
            emit(Resource.Failure(e))
        }
    }
}