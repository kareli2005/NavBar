package com.example.navbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.fragment.app.FragmentTransaction
import com.example.navbar.view.HomeFragment
import com.example.navbar.view.friendsFragment

class MainActivity : AppCompatActivity() {
    private val fragmentManager = supportFragmentManager
    private val homeFrag = HomeFragment()
    private val friendsFrag = friendsFragment()
    private val menuFrag = HomeFragment()
    private lateinit var manager : FragmentTransaction
    private lateinit var btnh : ImageButton
    private lateinit var btnf : ImageButton
    private lateinit var btnm : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnh = findViewById(R.id.home)
        btnf = findViewById(R.id.friends)
        btnm = findViewById(R.id.menu)

        manager = fragmentManager.beginTransaction()
            .replace(R.id.myView,homeFrag)
        manager.commit()
        btnh.setImageResource(R.drawable.homeuf)
    }

    fun addFragOnClick(view: View) {
        manager = fragmentManager.beginTransaction()
        when(view){
            btnh -> {
                manager.replace(R.id.myView, homeFrag)
                    .commit()
                btnh.setImageResource(R.drawable.homeuf)
                btnf.setImageResource(R.drawable.peoplef)
                btnm.setImageResource(R.drawable.menuf)
            }
            btnf -> {
                manager.replace(R.id.myView, friendsFrag)
                    .commit()
                btnh.setImageResource(R.drawable.homef)
                btnf.setImageResource(R.drawable.friendsuf)
                btnm.setImageResource(R.drawable.menuf)
            }
            btnm -> {
                manager.replace(R.id.myView, menuFrag)
                    .commit()
                btnh.setImageResource(R.drawable.homef)
                btnf.setImageResource(R.drawable.peoplef)
                btnm.setImageResource(R.drawable.menuuf)
            }
        }
    }
}