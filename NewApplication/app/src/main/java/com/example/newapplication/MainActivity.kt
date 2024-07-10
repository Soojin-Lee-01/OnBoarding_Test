package com.example.newapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val register_viewpager = findViewById<ViewPager>(R.id.register_viewpager)
        val dots_indicator = findViewById<DotsIndicator>(R.id.dots_indicator)

        register_viewpager.adapter = RegisterPagerAdapter(supportFragmentManager)
        register_viewpager.offscreenPageLimit = 2
        dots_indicator.setViewPager(register_viewpager)
    }
}