package com.kafloid.taller3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kafloid.taller3.data.User
import kotlinx.android.synthetic.main.row.view.*

class MyUserRecyclerViewAdapter(
    private val mValues: List<User>) : RecyclerView.Adapter<MyUserRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = mValues.size

    override fun onBindViewHolder(holder: MyUserRecyclerViewAdapter.ViewHolder, position: Int) {
        val item = mValues[position]
        holder.textView.text = item.nombre
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView){
        val button : Button = mView.buttonDeleteUser
        val textView : TextView = mView.textViewUserName
    }

}