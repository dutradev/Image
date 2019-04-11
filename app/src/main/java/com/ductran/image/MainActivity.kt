package com.ductran.image

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ImageAdapter(this, getData())
        rvData.adapter = adapter
    }

    private fun getData(): List<ImageModel> {
        val result = ArrayList<ImageModel>()

        val urlList = API().getImageUrlList()
        val contentList = API().getImageContent()

        for (index in 0 until urlList.size) {
            val item = ImageModel()
            item.imageUrl = urlList.get(index)
            item.imageContent = contentList.get(index)
            result.add(item)
        }
        return result
    }

}