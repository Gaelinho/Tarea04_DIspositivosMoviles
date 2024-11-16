package com.example.tarea03

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout

class PendientesActivity : ComponentActivity() {

    private lateinit var mMenuSections: Array<String>
    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var mDrawerList: ListView
    private lateinit var mDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task_list_layout)

        mMenuSections = resources.getStringArray(R.array.menu_items)
        mDrawerLayout = (findViewById(R.id.drawer_layout) as DrawerLayout)
        mDrawerList = (findViewById(R.id.left_drawer) as ListView)

        mDrawerList.adapter = ArrayAdapter(
            this,
            R.layout.left_drawer,
            mMenuSections
        )

        mDrawerToggle = object : ActionBarDrawerToggle(
            this,
            mDrawerLayout,
            R.string.DrawerOpened,
            R.string.DrawerClosed
        ) {
            override fun onDrawerOpened(drawerView: View) {
                Log.d("PendientesActivity", "Drawer Opened")
            }
            override fun onDrawerClosed(drawerView: View) {
                Log.d("PendientesActivity", "Drawer Closed")
            }
        }

        mDrawerList.onItemClickListener = DrawerItemClickListener()


        mDrawerLayout.addDrawerListener(mDrawerToggle)

        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setHomeButtonEnabled(true)
    }

    private class DrawerItemClickListener : OnItemClickListener {
        override fun onItemClick(
            parent: AdapterView<*>,
            view: View, position: Int, id: Long
        ) {
            Log.d(
                "PendientesActivity",
                (parent.adapter.getItem(position) as String)
            )
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        val id = item.itemId
        when (id) {
            R.id.ord_fecha -> {
                Log.d("PendientesActivity", "Ordenar por Fecha")
                return true
            }
            R.id.ord_materia -> {
                Log.d("PendientesActivity", "Ordenar por Materia")
                return true
            }
            R.id.prior_menu -> {
                Log.d("PendientesActivity", "Mostrar Prioritarios")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        mDrawerToggle.syncState()
    }
}
