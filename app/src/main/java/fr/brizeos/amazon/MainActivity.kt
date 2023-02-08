package fr.brizeos.amazon

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import fr.brizeos.amazon.databinding.ActivityMainBinding
import fr.brizeos.amazon.ui.dashboard.main.ActivityMainVm


private const val TAG = "MainActivity"
class MainActivity() : AppCompatActivity() {

    private val vm :ActivityMainVm by viewModels()

    lateinit var amb :ActivityMainBinding

    val navHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment }
    val navController get() = navHostFragment.navController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = DataBindingUtil.setContentView(this, R.layout.activity_main)
        amb.lifecycleOwner = this

        amb.vm = vm

        val navView = supportFragmentManager
            .findFragmentById(R.id.fragmentContainerView) as NavHostFragment?
        val navController = navView!!.navController

        amb.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId){
                R.id.accueilFragment -> {
                    navController.navigate(R.id.accueilFragment)
                    true
                }
                R.id.profilFragment -> {
                    navController.navigate(R.id.profilFragment)
                    true
                }


                else -> {false}
            }
        }
    }


}
