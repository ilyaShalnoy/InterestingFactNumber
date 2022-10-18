package com.example.notes.numbertesttask.main.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.notes.numbertesttask.R
import com.example.notes.numbertesttask.numbers.presentation.NumbersFragment

class MainActivity : AppCompatActivity(), ShowFragment {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null)
            show(NumbersFragment(), false)
    }

    override fun show(fragment: Fragment) {
        show(fragment, true)
    }

    private fun show(fragment: Fragment, add: Boolean) {
        //todo make OOP
        val transaction = supportFragmentManager.beginTransaction()
        if (add) {
            transaction.add(R.id.container, fragment)
                .addToBackStack(fragment.javaClass.simpleName)
        } else
            transaction.replace(R.id.container, NumbersFragment())
        transaction.commit()
    }
}

interface ShowFragment {
    fun show(fragment: Fragment)

    class Empty : ShowFragment {
        override fun show(fragment: Fragment) = Unit
    }
}