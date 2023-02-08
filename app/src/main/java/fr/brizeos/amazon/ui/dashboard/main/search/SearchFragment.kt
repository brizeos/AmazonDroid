package fr.brizeos.amazon.ui.dashboard.main.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import fr.brizeos.amazon.R
import fr.brizeos.amazon.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    lateinit var fsb: FragmentSearchBinding
    val svm :SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fsb = DataBindingUtil.inflate(inflater, R.layout.fragment_accueil, container, false)
        return fsb.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        fsb.svm = svm




    }

}