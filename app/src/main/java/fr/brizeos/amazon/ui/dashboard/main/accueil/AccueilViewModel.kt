package fr.brizeos.amazon.ui.dashboard.main.accueil

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import fr.brizeos.amazon.App
import fr.brizeos.amazon.databinding.FragmentAccueilBinding
import fr.brizeos.amazon.model.Article
import fr.brizeos.amazon.repostories.ArticleRepo
import fr.brizeos.amazon.ui.dashboard.main.ArticleAdapter
import org.koin.android.ext.android.get
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "AccueilViewModel"
class AccueilViewModel(val articleService: ArticleRepo, val fab :FragmentAccueilBinding) : ViewModel() {

    val articles: MutableLiveData<MutableList<Article>> = MutableLiveData<MutableList<Article>>(
        mutableListOf()
    )

    val adapter : MutableLiveData<ArticleAdapter> = MutableLiveData<ArticleAdapter>(ArticleAdapter(articles.value!!))

    val search :MutableLiveData<String> = MutableLiveData("")



    fun getArticles(){

        articleService.getListLimited(25).enqueue(object : Callback<List<Article>> {
            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
                articles.value!!.addAll(response.body()!!)
                fab.rvArticles.adapter = adapter.value
                fab.progressBarSpinner.visibility = View.INVISIBLE
            }

            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                Log.i(TAG, "onResponse: Error")
            }

        })
    }

}