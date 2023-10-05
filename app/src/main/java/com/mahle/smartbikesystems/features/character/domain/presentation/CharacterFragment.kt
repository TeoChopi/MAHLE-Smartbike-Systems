package com.mahle.smartbikesystems.features.character.domain.presentation

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.mahle.smartbikesystems.R
import com.mahle.smartbikesystems.core.presentation.Base
import com.mahle.smartbikesystems.databinding.FragmentCharacterBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharacterFragment : Base.BaseFragment<FragmentCharacterBinding>(R.layout.fragment_character) {

    private val viewModel: CharacterViewModel by viewModels()
    private val navArgs by navArgs<CharacterFragmentArgs>()

    override fun init() {
        navArgs.id?.let { viewModel.getCharacters(it) }
        initStatusCollect()
    }

    private fun initStatusCollect() = binding.run {
        lifecycleScope.launch {
            viewModel.state.collect { state ->
                progressBar.isVisible = state.loading

                state.characterDomainModel?.let { result ->
                    txtName.text = result.name
                    txtDescription.text = result.description
                    val url = result.thumbnailPath.plus(".").plus(result.thumbnailExtension)
                    Glide.with(requireContext()).load(url)
                        .circleCrop()
                        .placeholder(R.drawable.ic_launcher_foreground)
                        .into(image)

                }

                state.error?.also {
                    txtError.text = it.message
                }
            }
        }
    }

    override fun getViewBinding() = FragmentCharacterBinding.inflate(layoutInflater)
}
