package com.example.listadecontatos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(var listener: ClickItem): RecyclerView.Adapter<ContactAdapter.ContactAdapterHolView>() {

private val list:MutableList<Contact> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterHolView {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterHolView(view, list, listener)
    }

    override fun onBindViewHolder(holder: ContactAdapterHolView, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updatelist(list: List<Contact>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()

    }

    class ContactAdapterHolView(itemView: View, var list: List<Contact>, var listener: ClickItem): RecyclerView.ViewHolder(itemView){
           private val tvName: TextView = itemView.findViewById(R.id.tv_name)
           private val tvFone: TextView = itemView.findViewById(R.id.tv_fone)
           private val ivFoto: ImageView = itemView.findViewById(R.id.iv_foto)

        init {
            itemView.setOnClickListener {
                listener.clickItemContact(list[adapterPosition])
            }
        }

         fun bind(contact: Contact) {

             tvName.text = contact.name
             tvFone.text = contact.phone


         }
    }

}
