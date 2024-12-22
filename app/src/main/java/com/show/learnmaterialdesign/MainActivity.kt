package com.show.learnmaterialdesign

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.show.learnmaterialdesign.databinding.ActivityMainBinding
import com.show.learnmaterialdesign.util.ToastUtil

class MainActivity : AppCompatActivity() {
    private val mBinding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(mBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setSupportActionBar(mBinding.toolbar)

        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        mBinding.navView.setCheckedItem(R.id.navCall)
        mBinding.navView.setNavigationItemSelectedListener {
            mBinding.drawerLayout.closeDrawers()
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                ToastUtil.show(
                    this, "You clicked Home"
                )
                mBinding.drawerLayout.openDrawer(GravityCompat.START)
            }

            R.id.backup -> ToastUtil.show(
                this, "You clicked Backup"
            )

            R.id.delete -> ToastUtil.show(
                this, "You clicked Delete"
            )

            R.id.settings -> ToastUtil.show(
                this, "You clicked Settings"
            )
        }
        return true
    }

}