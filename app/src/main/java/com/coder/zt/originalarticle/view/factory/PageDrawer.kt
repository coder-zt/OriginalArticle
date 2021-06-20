package com.coder.zt.originalarticle.view.factory

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import com.coder.zt.originalarticle.view.parser.HtmlParser
import com.coder.zt.originalarticle.view.utils.ScreenUtils

/**
 * 页面绘制器
 */
class PageDrawer(val context: Context,val content:String) {
    private var currentIndex:Int = 1
    private var currentPage:Int = 1
    private val TAG = "PageDrawer"
    private val whitePaint: Paint by lazy {
        val paint = Paint()
        paint.color = Color.WHITE
        paint.textSize = ScreenUtils.dip2px(22.0f, context)
        paint
    }

    private val circularBitmapQueue:CircularBitmapQueue by lazy {
        CircularBitmapQueue.getInstance(context)
    }

    private val contextList:List<Map<String,String>> by lazy {
        HtmlParser().parseHtml(content)
    }

    fun init() {
        val currentBitmap = circularBitmapQueue.getCurrentBitmap()
        val canvas = Canvas(currentBitmap)
        canvas.drawColor(currentBitmap.getPixel(0, 0))
        val nextBitmap = circularBitmapQueue.getNextBitmap()
        val nextCanvas = Canvas(nextBitmap)
        nextCanvas.drawColor(nextBitmap.getPixel(0, 0))
        var lineIndex = 0
        for (item in contextList){
            Log.d(TAG, "init:${item.keys}" )
            for (key in item.keys) {
                Log.d(TAG, "init: key:$key")
                val text: String? = item[key]
                Log.d(TAG, "init: $text")
                if (text != null) {
                    canvas.drawText(text, 20.0f, 100.0f * (lineIndex + 1), whitePaint)
                    lineIndex ++
                }

            }
        }
        nextCanvas.drawText("第${currentPage + 1}页", 20.0f, 100.0f, whitePaint)
    }


    companion object{
        private var instance:PageDrawer? = null
        fun getInstance(context: Context,content:String):PageDrawer{
            val i = instance
            if(i != null){
                return i
            }
            return synchronized(this){
                val i2 = instance
                if(i2 != null){
                    i2
                }else{
                    val created = PageDrawer(context, content)
                    instance = created
                    created
                }
            }
        }
    }
}