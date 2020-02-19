package com.kafloid.taller3


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.kafloid.taller3.data.User
import kotlinx.android.synthetic.main.fragment_main.view.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    val users = mutableListOf<User>()
    private var adapter : MyUserRecyclerViewAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        users.add(User("User 1"))
        users.add(User("User 2"))

        adapter = MyUserRecyclerViewAdapter(users)

        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter

        return view
    }


}
