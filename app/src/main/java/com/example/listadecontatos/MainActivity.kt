package com.example.listadecontatos

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listadecontatos.ContactDetail.Companion.EXTRA_CONTACT


class MainActivity : AppCompatActivity(), ClickItem {

        private val rvList: RecyclerView by lazy {
           val findViewById = findViewById<RecyclerView>(R.id.rv_list)
            findViewById
        }
        private val adapter = ContactAdapter(this)

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)


            bindView()
            updateList()

        }

    
        private fun bindView() {
            rvList.adapter = adapter
            rvList.layoutManager = LinearLayoutManager(this)

        }

        private fun updateList() {
            adapter.updatelist(
                    arrayListOf(
                        Contact(
                            "Davi Fidelis",
                            "(81) 99353-3692",
                            "img.pg"
                        ), Contact(
                            "B",
                        "(81) 98495-1681",
                            "img.pg"
                        )

                    )

            )
        }

        private fun showToast(message: String) {
            Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
        }


        override fun onCreateOptionsMenu(menu: Menu?): Boolean {
            val inflater: MenuInflater = menuInflater
            inflater.inflate(R.menu.menu, menu)
            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            return when (item.itemId) {
                R.id.item_menu_1 -> {
                   showToast("Exibindo item de meu 1")
                    true
                }
                R.id.item_menu_2 -> {
                    showToast("Exibindo item de meu 2")
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
        }

    override fun clickItemContact(contact: Contact) {
        val intent = Intent(this, ContactDetail::class.java)
        intent.putExtra(EXTRA_CONTACT, contact)
        startActivity(intent)
    }

}
