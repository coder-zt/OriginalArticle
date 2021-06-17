package com.coder.zt.originalarticle.view

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.view.View
import com.coder.zt.originalarticle.R

class PageView(context: Context, attrs:AttributeSet): View(context, attrs) {


//    private val bitmap:Bitmap by lazy {
//        val bitmapDrawable =
//        val value = bitmapDrawable as BitmapDrawable
//        null
//    }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val rect = Rect(0, 0, 36, 36)
        val rectF = RectF(0f, 0f, 720f, 720f)
    val drawable = resources.getDrawable(R.drawable.ic_launcher)
    canvas?.drawBitmap((drawable as BitmapDrawable).bitmap, rect,rectF, Paint())
    }
}