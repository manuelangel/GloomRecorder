package com.example.gloomrecorder.characters.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class CharactersViewModel : ViewModel() {

    val list = listOf<String>("1","2","3")
}