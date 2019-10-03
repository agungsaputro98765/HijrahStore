package com.example.hijrahstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvUniv: RecyclerView
    private var list: ArrayList<Database> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionbar = supportActionBar
        actionbar!!.title= "Home"

        rvUniv = findViewById(R.id.rv_univ)
        rvUniv.setHasFixedSize(true)

        list.addAll(BookData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvUniv.layoutManager = LinearLayoutManager(this)
        val ListBookAdapter = ListBookAdapter(list)
        rvUniv.adapter = ListBookAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionmenu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.miCompose -> {
                val iAbout = Intent(this@MainActivity, About::class.java)
                startActivity(iAbout)
            }
        }
    }
}

