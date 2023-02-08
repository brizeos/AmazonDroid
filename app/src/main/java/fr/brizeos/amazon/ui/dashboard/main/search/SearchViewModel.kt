package fr.brizeos.amazon.ui.dashboard.main.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel :ViewModel() {


    val search :MutableLiveData<String> = MutableLiveData("")


}