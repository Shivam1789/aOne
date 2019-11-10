package com.school.kotlin.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.kotlin.R
import com.school.kotlin.adapter.SubjetsAdapter
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    private var mAdapter: SubjetsAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAdapter()
    }

    private fun setAdapter() {
        mAdapter = activity?.let { SubjetsAdapter(it) }
        val layoutManger = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recycler_subjects.layoutManager = GridLayoutManager(activity, 2)
        recycler_subjects.adapter = mAdapter
        mAdapter?.setRecyclerView(layoutManger, recycler_subjects)
    }

}
