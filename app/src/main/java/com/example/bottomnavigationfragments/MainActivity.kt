package com.example.bottomnavigationfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    companion object {
        private val fragment1 = HomeFragment()
        private val fragment2 = DashboardFragment()
        private val fragment3 = NotificationFragment()
        private var active: Fragment = fragment1

    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId) {

            R.id.navigation_home -> {
                supportFragmentManager.beginTransaction()
                    .hide(active)
                    .show(fragment1)
                    .commit()
                active = fragment1
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_dashboard -> {
                supportFragmentManager.beginTransaction()
                    .hide(active)
                    .show(fragment2)
                    .commit()
                active = fragment2
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_notifications -> {
                supportFragmentManager.beginTransaction()
                    .hide(active)
                    .show(fragment3)
                    .commit()
                active = fragment3
                return@OnNavigationItemSelectedListener true
            }

        }
        return@OnNavigationItemSelectedListener false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        setSupportActionBar(toolbar)


        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)


        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, fragment3, "3")
            .hide(fragment3)
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, fragment2, "2")
            .hide(fragment2)
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, fragment1, "1")
            .commit()
    }

    override fun onResume() {
        super.onResume()
    }



}
