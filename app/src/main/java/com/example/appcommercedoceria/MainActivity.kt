package com.example.appcommercedoceria

import android.content.Intent
import android.icu.text.CaseMap
import android.net.wifi.hotspot2.pps.HomeSp
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

   lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var textTitle: TextView
    lateinit var textLogin: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        textTitle = findViewById(R.id.toolbar_title)
        textTitle.text = getString(R.string.app_name)


        drawerLayout = findViewById(R.id.nav_drawer_layout)

        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout,toolbar,(R.string.toggle_open),(R.string.toggle_close))
        drawerLayout.addDrawerListener(toggle)

        toggle.syncState()

        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener (this)


        val productItem: LinearLayout = findViewById (R.id.ll_product_item)
        productItem.setOnClickListener{
            val intent: Intent = Intent(this,ProductDetalActivity::class.java)
            startActivity(intent)
        }

        textLogin = navigationView.getHeaderView(0).findViewById(R.id.header_profile_name)
        textLogin.setOnClickListener {
              val intent = Intent(this,UserLoginActivity::class.java)
            startActivity(intent)

        }



    }

    override fun onBackPressed() {

        if (drawerLayout.isDrawerOpen(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START)
        else
        super.onBackPressed()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.nav_home -> {
                val  intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_account -> {
                val intent = Intent(this,UserRegistrerActivity::class.java)
                startActivity(intent)
            }
            R.id.nav_category -> Toast.makeText(this,"Categorias", Toast.LENGTH_LONG).show()
            R.id.orders -> Toast.makeText(this,"Compras", Toast.LENGTH_LONG).show()
            R.id.cart -> Toast.makeText(this,"Carrinho", Toast.LENGTH_LONG).show()
            R.id.nav_logout -> Toast.makeText(this,"Sair", Toast.LENGTH_LONG).show()

        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}