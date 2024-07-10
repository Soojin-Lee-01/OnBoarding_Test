package com.example.new_application

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.ramotion.paperonboarding.PaperOnboardingFragment
import com.ramotion.paperonboarding.PaperOnboardingPage
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // PaperOnboardingPage 객체 생성
        val scr1 = PaperOnboardingPage(
            "Hotels",
            "All hotels and hostels are sorted by hos",
            Color.parseColor("#678FB4"), R.drawable.hotel, R.drawable.key
        )
        val scr2 = PaperOnboardingPage(
            "Flights",
            "All flights sorted by price",
            Color.parseColor("#65B0B4"), R.drawable.hotel, R.drawable.key
        )
        val scr3 = PaperOnboardingPage(
            "Rental",
            "All car rentals sorted by price",
            Color.parseColor("#9B90BC"), R.drawable.hotel, R.drawable.key
        )

        // PaperOnboardingPage 객체 리스트 생성 및 추가
        val elements = arrayListOf(scr1, scr2, scr3)

        // PaperOnboardingFragment 인스턴스 생성
        val onBoardingFragment = PaperOnboardingFragment.newInstance(elements)

        // FragmentTransaction 시작 및 프래그먼트 추가
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.containers, onBoardingFragment)
        fragmentTransaction.commit()

        // 온보딩 완료시 보여줄 프래그먼트 설정
        onBoardingFragment.setOnRightOutListener(object : PaperOnboardingOnRightOutListener {
            override fun onRightOut() {
                val fragmentTransaction = supportFragmentManager.beginTransaction()
                val fm = MainFragment()
                fragmentTransaction.replace(R.id.containers, fm)
                fragmentTransaction.commit()
            }
        })




    }
}