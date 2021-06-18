package com.coder.zt.originalarticle

import android.content.Context
import android.graphics.Point
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.coder.zt.originalarticle.test.JsoupTest
import com.coder.zt.originalarticle.view.PageView
import com.coder.zt.originalarticle.view.PageView.OnTouchEventListener
import com.coder.zt.originalarticle.view.factory.CircularBitmapQueue

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()

    }

    class Listener(val context:Context): OnTouchEventListener {
        private  val TAG = "Listener"
        override fun onClick(point: Point) {
            Log.d(TAG, "onClick: ")
        }

        override fun onLongClick(point: Point) {
            Log.d(TAG, "onLongClick: ")
        }

        override fun nextPage() {
            CircularBitmapQueue.getInstance(context).nextPage()
        }

        override fun perPage() {
            CircularBitmapQueue.getInstance(context).perPage()
        }

    }

    private fun initView() {
        val pageView = findViewById<PageView>(R.id.page_view)
        pageView.set(Listener(this))
    }

    override fun onResume() {
        super.onResume()
        JsoupTest().parseHtml(HtmlArticleData.htmlData)
    }
}