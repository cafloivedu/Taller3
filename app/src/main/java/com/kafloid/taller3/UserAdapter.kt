package com.kafloid.taller3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kafloid.taller3.data.User
import com.kafloid.taller3.databinding.RowBinding
import kotlinx.android.synthetic.main.row.view.*

class UserAdapter(
    private val mValues: List<User>,
    private val mListener: onListInteraction
 ) : RecyclerView.Adapter<UserAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        //val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        //return ViewHolder(view)
        var binder : RowBinding
        binder = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.row, parent, false)
        return ViewHolder(binder)
    }

    override fun getItemCount(): Int = mValues.size

    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        val item = mValues[position]
        holder.mView.user = item
        holder.mView.executePendingBindings()

        /*holder.mView.setOnClickListener {
            mListener?.onListItemInteraction(item)
        }

        holder.button.setOnClickListener{
            mListener?.onListButtonInteraction(item)
        }*/
    }

    public fun updateData(){
        notifyDataSetChanged()
    }

    inner class ViewHolder(val mView: RowBinding) : RecyclerView.ViewHolder(mView.root){

    }

    interface onListInteraction {
        fun onListItemInteraction(item : User?)
        fun onListButtonInteraction(item : User?)
    }

}