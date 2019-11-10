package com.school.kotlin.ui.select_class

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.school.kotlin.R
import com.school.kotlin.ui.other.BaseFragment
import com.school.kotlin.ui.signUp.FragmentSignUp
import com.school.kotlin.ui.tutorial.FragmentTutorial
import kotlinx.android.synthetic.main.fragment_select_class.*


class FragmentSelectClass : BaseFragment() {
    private val items: MutableList<ListItem> = ArrayList()
    private val adapter: DataAdapter? = null
    private var GRID_COUNT = 3

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_select_class, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_rv_classes.setHasFixedSize(true)

        val adapter = DataAdapter(items, object : class_selector_callback {
            override fun selectedItem(item: String) {
                addFragment(FragmentSignUp(), true)
            }

        })

        fragment_rv_classes.adapter = adapter

        val gd = GridLayoutManager(activity, GRID_COUNT)

        gd.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                return if (adapter.getItemViewType(position) == ListItem.TYPE_HEADER) GRID_COUNT else 1
            }

        }

        fragment_rv_classes.layoutManager = gd

        items.add(Header("Classes 4-12"))
        items.add(Person("4th"))
        items.add(Person("5th"))
        items.add(Person("6th"))
        items.add(Person("7th"))
        items.add(Person("8th"))
        items.add(Person("9th"))
        items.add(Person("10th"))
        items.add(Person("11th"))
        items.add(Person("12th"))
        items.add(Header("Classes 1-3"))
        items.add(Person("1st"))
        items.add(Person("2nd"))
        items.add(Person("3rd"))
        items.add(Header("Exams preparation"))
        items.add(Person("CAT"))
        items.add(Person("IAS"))
        items.add(Person("GMAT"))
        items.add(Person("GRE"))
        adapter.notifyDataSetChanged()

    }
}