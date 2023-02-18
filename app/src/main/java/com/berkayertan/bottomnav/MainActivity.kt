package com.berkayertan.bottomnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.berkayertan.bottomnav.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        fun setCurrentFragment(fragment: Fragment) =
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, fragment)
                commit()
            }

        val fFragment = FirstFragment()
        val sFragment = SecondFragment()
        val tFragment = ThirdFragment()

        setCurrentFragment(fFragment)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.mile -> setCurrentFragment(fFragment)
                R.id.kg -> setCurrentFragment(sFragment)
                R.id.inch -> setCurrentFragment(tFragment)
            }
            true
        }

    }
}