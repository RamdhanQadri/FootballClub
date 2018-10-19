package com.example.user.footballclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.user.footballclub.R.array.*
import com.example.user.footballclub.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    private var items: MutableList<Item> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)
        initData()

        club_list.layoutManager = LinearLayoutManager(this)
        club_list.adapter = RecyclerViewAdapter(this, items){
            startActivity<DetailActivity>("club" to it)
        }
    }

    private fun initData(){
        val name = resources.getStringArray(club_name)
        val detail = resources.getStringArray(club_detail)
        val image = resources.obtainTypedArray(club_image)
        items.clear()
        for (i in name.indices) {
            items.add(Item(name[i],detail[i],
                image.getResourceId(i, 0)))
        }

        //Recycle the typed array
        image.recycle()
    }
}



