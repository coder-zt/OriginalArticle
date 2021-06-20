package com.coder.zt.originalarticle

import android.content.Context
import android.graphics.Point
import android.graphics.pdf.PdfDocument
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.view.WindowManager
import com.coder.zt.originalarticle.test.JsoupTest
import com.coder.zt.originalarticle.view.PageView
import com.coder.zt.originalarticle.view.PageView.OnTouchEventListener
import com.coder.zt.originalarticle.view.factory.CircularBitmapQueue
import com.coder.zt.originalarticle.view.factory.PageDrawer
import com.coder.zt.originalarticle.view.parser.HtmlParser

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    private val pageDrawer:PageDrawer by lazy {
        PageDrawer.getInstance(this, HtmlArticleData.htmlData1)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set no title bar 需要在setContentView之前调用
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        //如果上面的不起作用，可以换成下面的。
        if (getSupportActionBar()!=null) getSupportActionBar()?.hide()
        if (getActionBar()!=null) getActionBar()?.hide()
        //no status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
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
        pageDrawer.init()

    }
}