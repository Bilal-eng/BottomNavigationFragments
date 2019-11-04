package com.example.bottomnavigationfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment() {


    private var score = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddOne.setOnClickListener {
            incrementCounter()
        }
    }

    private fun incrementCounter() {
        score += 1
        tvCounterValue.text = getString(R.string.counterValue, score)
    }

    override fun onResume() {
        super.onResume()
    }

}