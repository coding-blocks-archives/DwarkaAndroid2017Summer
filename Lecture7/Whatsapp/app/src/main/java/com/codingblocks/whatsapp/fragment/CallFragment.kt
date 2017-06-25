package com.codingblocks.whatsapp.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.codingblocks.whatsapp.R
import com.codingblocks.whatsapp.adapter.ChatAdapter
import com.codingblocks.whatsapp.model.Call
import com.codingblocks.whatsapp.model.Chat

import java.util.ArrayList

/**
 * Created by the-dagger on 24/06/17.
 */

class CallFragment : Fragment() {

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_call, container, false)
        val recyclerView = v.findViewById(R.id.rvCall) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = ChatAdapter(arguments.getSerializable("CALL") as ArrayList<Chat>)
        return v
    }

    companion object {

        fun newInstance(callArrayList: ArrayList<Call>): CallFragment {
            val args = Bundle()
            args.putSerializable("CALL", callArrayList)
            val fragment = CallFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
