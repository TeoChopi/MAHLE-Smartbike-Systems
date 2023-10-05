package com.mahle.smartbikesystems.features.character.domain.usecase

import com.mahle.smartbikesystems.core.api.Resource
import com.mahle.smartbikesystems.features.character.data.model.ResponseCharacterDataModel
import com.mahle.smartbikesystems.features.character.data.model.toCharter
import com.mahle.smartbikesystems.features.character.data.repository.CharacterRepository
import com.mahle.smartbikesystems.features.character.domain.model.CharacterDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository
) {

    operator fun invoke(id: String): Flow<Resource<CharacterDomainModel>> = flow {
        try {
            emit(Resource.Loading())
            val result: ResponseCharacterDataModel = repository.getCharacter(id)
            emit(Resource.Success(result.toCharter()))
        } catch (e: HttpException) {
            emit(Resource.Failure(e))
        } catch (e: IOException) {
            emit(Resource.Failure(e))
        }
    }
}