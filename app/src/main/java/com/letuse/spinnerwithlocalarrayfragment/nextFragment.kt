package com.letuse.spinnerwithlocalarrayfragment

import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.letuse.pos.room.Category.Category
import com.letuse.spinnerwithlocalarrayfragment.Category.ItemAdapter
import com.letuse.spinnerwithlocalarrayfragment.Category.viewmodel
import kotlinx.android.synthetic.main.fragment_next.*

class nextFragment : Fragment() {

    lateinit var vm: viewmodel
    private var category_ID: Int = 0
    lateinit var category: Category

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Display Data
        val itemAdapter = ItemAdapter()
        vm = ViewModelProvider(this).get(viewmodel::class.java)

        recyclerview_category.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = itemAdapter
        }

        vm.allItem.observe(
            viewLifecycleOwner, Observer {
                it.let {
                    itemAdapter.addCategoryList(it)
                }
            }
        )

        btn_send.setOnClickListener {

            var text = etd_category.text.toString()

            var category = Category(category_ID, text)
            vm.insert(category)
            etd_category.setText("")
        }

        btn_deleteAll.setOnClickListener {
            vm.delete()
        }

        //Spinner
//        val data = arrayOf("No Category", "Create New Category",category.category_name) => lateinit property category has not been initialized
        val data = arrayOf("No Category", "Create New Category")
        var adapter = context?.let { ArrayAdapter(it, R.layout.list_item, data) }
        mySpinner.adapter = adapter

        mySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                if (position.equals(0)) {
                } else if (position.equals(1)) {
                    findNavController().navigate(nextFragmentDirections.actionNextFragmentToCategoryFragment())
                    mySpinner.setSelection(0);
                }
            }
        }

    }
}
