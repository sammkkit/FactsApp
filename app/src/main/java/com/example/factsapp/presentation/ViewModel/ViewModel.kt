package com.example.factsapp.presentation.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.factsapp.domain.Repository.Repository
import com.example.factsapp.domain.model.Fact
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(
    private val repository: Repository
):ViewModel() {

    private val _facts = MutableLiveData<Fact?>()
    val facts: MutableLiveData<Fact?> = _facts
    init {
        getfacts()
    }
    fun getfacts(){
        viewModelScope.launch {
            val data = repository.getfacts()
            _facts.postValue(data)
        }
    }
}