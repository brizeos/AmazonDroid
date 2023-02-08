package fr.brizeos.amazon.ui.dashboard.main.accueil

import android.text.Editable
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.brizeos.amazon.databinding.FragmentAccueilBinding
import fr.brizeos.amazon.model.Article
import fr.brizeos.amazon.repostories.ArticleRepo
import fr.brizeos.amazon.ui.dashboard.main.ArticleAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "AccueilViewModel"

class AccueilViewModel(val articleService: ArticleRepo, val fab: FragmentAccueilBinding) :
    ViewModel() {

    val articles_shown: MutableLiveData<MutableList<Article>> =
        MutableLiveData<MutableList<Article>>(
            mutableListOf()
        )

    val articles: MutableLiveData<MutableList<Article>> = MutableLiveData<MutableList<Article>>(
        mutableListOf()
    )

    val adapter: MutableLiveData<ArticleAdapter> =
        MutableLiveData<ArticleAdapter>(ArticleAdapter(articles_shown.value!!))

    val search: MutableLiveData<String> = MutableLiveData("")

    fun getArticles() {

        articleService.getAll().enqueue(object : Callback<List<Article>> {
            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {

                articles.value!!.addAll(response.body()!!)
                articles_shown.value!!.addAll(response.body()!!)

                fab.rvArticles.adapter = adapter.value

                fab.progressBarSpinner.visibility = View.INVISIBLE

                Log.i(TAG, "onResponse: END")
            }

            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                Log.i(TAG, "onResponse: Error")
            }

        })
    }

    fun search() {

        fab.progressBarSpinner.visibility = View.VISIBLE

        articles_shown.value =
            articles.value!!.filter {
            it.description.contains(search.value.toString(), true) ||
                    it.title.contains(search.value.toString(), true)
        }.toMutableList()
        Log.i(TAG, "search: ${articles_shown.value}")

//        fab.rvArticles.adapter = adapter.value

        fab.progressBarSpinner.visibility = View.INVISIBLE

    }

}