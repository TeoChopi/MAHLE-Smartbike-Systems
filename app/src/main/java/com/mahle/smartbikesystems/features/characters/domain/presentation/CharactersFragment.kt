package com.mahle.smartbikesystems.features.characters.domain.presentation

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.mahle.smartbikesystems.R
import com.mahle.smartbikesystems.core.presentation.Base
import com.mahle.smartbikesystems.databinding.FragmentCharactersBinding
import com.mahle.smartbikesystems.features.characters.domain.model.CharactersDomainModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CharactersFragment : Base.BaseFragment<FragmentCharactersBinding>(R.layout.fragment_characters) {

    private val viewModel: CharactersViewModel by viewModels()
    private var adapter: CharactersAdapter? = null

    override fun init() {
        viewModel.getCharacters()
        setupRecycler()
        initStatusCollect()
    }

    private fun setupRecycler() = binding.run {
        adapter = CharactersAdapter(listOf()) { characterId ->
            /*findNavController().navigate(
                    PromotionalCodeListFragmentDirections.actionPromotionalCodeListFragmentToConditionsInviteFriendFragment(
                        mgmCode
                    )
                )*/

        }
        rvCharacters.layoutManager = LinearLayoutManager(requireContext())
        rvCharacters.adapter = adapter
    }

    private fun initStatusCollect() = binding.run {
        lifecycleScope.launch {
            viewModel.state.collect { state ->
                progressBar.isVisible = state.loading

                state.charactersDomainModel?.let { result ->
                    result.results?.let { adapter?.setData(it) }
                }

                state.error?.also {
                    txtError.text = it.message
                }
            }
        }
    }

    override fun getViewBinding() = FragmentCharactersBinding.inflate(layoutInflater)
}
