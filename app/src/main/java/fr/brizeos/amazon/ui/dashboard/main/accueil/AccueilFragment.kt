package fr.brizeos.amazon.ui.dashboard.main.accueil

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.TextWatcherAdapter
import fr.brizeos.amazon.R
import fr.brizeos.amazon.databinding.FragmentAccueilBinding
import fr.brizeos.amazon.model.Article
import fr.brizeos.amazon.repostories.ArticleRepo
import org.koin.android.ext.android.inject

private const val TAG = "AccueilFragment"
class AccueilFragment : Fragment() {

    val articleRepo :ArticleRepo by inject()

    companion object {
        fun newInstance() = AccueilFragment()
    }

    lateinit var fab :FragmentAccueilBinding
    val vm : AccueilViewModel by viewModels{ AccueilViewModelFactory(articleRepo, fab) }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        fab = DataBindingUtil.inflate(inflater, R.layout.fragment_accueil, container, false)
        fab.lifecycleOwner = this
        return fab.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fab.rvArticles.layoutManager = LinearLayoutManager(context)

        vm.getArticles()

        fab.editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) = vm.search()
        })




    }

}