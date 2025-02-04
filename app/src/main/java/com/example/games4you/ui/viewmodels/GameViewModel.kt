package com.example.games4you.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.games4you.data.model.Game
import com.example.games4you.data.api.GameClient
import com.example.games4you.data.repository.GameRepositoryImpl
import com.example.games4you.domain.repository.GameRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {

    private val gameApiService = GameClient.create()
    private val gameRepository: GameRepository = GameRepositoryImpl(gameApiService)

    private val _games = MutableStateFlow<List<Game>>(emptyList())
    val games: StateFlow<List<Game>> = _games

    private val _selectedGame = MutableStateFlow<Game?>(null)
    val selectedGame: StateFlow<Game?> = _selectedGame

    private var _order = true

    private val _searchQuery = MutableStateFlow("")
    val searchQuery: StateFlow<String> = _searchQuery

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun clearSearchQuery() {
        _searchQuery.value = ""
    }

    init {
        viewModelScope.launch {
            gameRepository.getAllGames().collect { gameList ->
                _games.value = gameList
            }
        }
    }

    fun selectGame(gameId: Int) {
        if (_selectedGame.value == null || _selectedGame.value!!.id != gameId) {
            _selectedGame.value = null
            viewModelScope.launch {
                gameRepository.getGameById(gameId).collect { game ->
                    _selectedGame.value = game
                }
            }
        }
    }

    fun sortData(sortMode: SortMode) {
        _games.value = when (sortMode) {
            SortMode.ID -> _games.value.sortedBy { it.id }
            SortMode.TITLE -> _games.value.sortedBy { it.title }
            SortMode.DATE -> _games.value.sortedBy { it.releaseDate }
        }
        if (!_order) {
            _games.value = _games.value.reversed()
        }
        _order = !_order
    }

    enum class SortMode(val display: String) {
        ID("ID"),
        TITLE("Titre"),
        DATE("Date"),
    }
}
