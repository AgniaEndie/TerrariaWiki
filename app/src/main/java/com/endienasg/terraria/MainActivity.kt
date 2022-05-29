package com.endienasg.terraria

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_content.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener{

    var adapter: MyAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setNavigationItemSelectedListener (this)

        var list = ArrayList<ListItem>()

        list.addAll(fillArras(resources.getStringArray(R.array.melee),
            resources.getStringArray(R.array.melee_content),getImageId(R.array.melee_image_array)))


        rcView.hasFixedSize()
        rcView.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(list,this)
        rcView.adapter = adapter


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId){

            R.id.id_melee ->
            {
                Toast.makeText(this,"Id melee",Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.melee),
                    resources.getStringArray(R.array.melee_content),getImageId(R.array.melee_image_array)))

            }
            R.id.id_distant ->
            {
                Toast.makeText(this,"Id distant",Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.distant),
                    resources.getStringArray(R.array.distant_content),getImageId(R.array.distant_image_array)))

            }
            //R.id.id_sna -> Toast.makeText(this,"Id sna",Toast.LENGTH_SHORT).show()
            R.id.id_mob ->
            {
                Toast.makeText(this,"Id mob",Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.mob),
                    resources.getStringArray(R.array.mob_content),getImageId(R.array.mob_image_array)))

            }
            R.id.id_boss ->
            {
                Toast.makeText(this,"Id boss", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.boss),
                    resources.getStringArray(R.array.boss_content),getImageId(R.array.boss_image_array)))
            }
            R.id.id_biome -> {
                Toast.makeText(this,"Id biome", Toast.LENGTH_SHORT).show()
                adapter?.updateAdapter(fillArras(resources.getStringArray(R.array.biome),
                    resources.getStringArray(R.array.biome_content),getImageId(R.array.biome_image_array)))
            }
        }
        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }
    fun fillArras(titleArray:Array<String>,contentArray:Array<String>,imageArray:IntArray):List<ListItem>
    {
        var listItemArray = ArrayList<ListItem>()
        for(n in 0..titleArray.size - 1)
        {
            var listItem = ListItem(imageArray[n],titleArray[n],contentArray[n])
            listItemArray.add(listItem)
        }
        return listItemArray
    }

    fun getImageId(imageArrayId:Int):IntArray
    {
        var tArray:TypedArray = resources.obtainTypedArray(imageArrayId)
        val count = tArray.length()
        val ids = IntArray(count)
        for(i in ids.indices)
        {
            ids[i] = tArray.getResourceId(i,0)
        }
        tArray.recycle()
        return ids
    }

}