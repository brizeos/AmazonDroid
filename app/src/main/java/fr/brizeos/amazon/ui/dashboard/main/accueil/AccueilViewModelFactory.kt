package fr.brizeos.amazon.ui.dashboard.main.accueil

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import fr.brizeos.amazon.databinding.FragmentAccueilBinding
import fr.brizeos.amazon.repostories.ArticleRepo
import org.koin.java.KoinJavaComponent.inject

class AccueilViewModelFactory(val articleService: ArticleRepo, val fab :FragmentAccueilBinding) :ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {

        return AccueilViewModel(articleService, fab) as T;
    }
}