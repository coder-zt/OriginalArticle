package com.coder.zt.originalarticle.view.factory

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.coder.zt.originalarticle.view.utils.ScreenUtils

/**
 * 存放bitmap的循环队列
 */
class CircularBitmapQueue(private val context: Context):ICircularBitmapQueue {

    private val TAG = "CircularBitmapQueue"

    private val firstPageBitmap: Bitmap by lazy {
        val screenSize = ScreenUtils.getScreenSize(context)
        val bitmap = Bitmap.createBitmap(screenSize.x, screenSize.y, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.RED)
        bitmap
    }

    private val secondPageBitmap: Bitmap by lazy {
        val screenSize = ScreenUtils.getScreenSize(context)
        val bitmap = Bitmap.createBitmap(screenSize.x, screenSize.y, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.GREEN)
        bitmap
    }

    private val thirdPageBitmap: Bitmap by lazy {
        val screenSize = ScreenUtils.getScreenSize(context)
        val bitmap = Bitmap.createBitmap(screenSize.x, screenSize.y, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.BLUE)
        bitmap
    }



    val bitmapQueue = listOf(firstPageBitmap, secondPageBitmap, thirdPageBitmap)

    private var currentIndex:Int = 1

    override fun getPerBitmap(): Bitmap {
        val index = (currentIndex+2)%3
        return bitmapQueue[index]
    }



    override fun getCurrentBitmap(): Bitmap {
        return bitmapQueue[currentIndex]
    }



    override fun getNextBitmap(): Bitmap {
        val index = (currentIndex+1)%3
        return bitmapQueue[index]
    }

    fun nextPage() {
        currentIndex = (currentIndex + 1)%3
        Log.d(TAG, "nextPage:  currentIndex = $currentIndex")
    }

    fun perPage() {
        currentIndex = (currentIndex + 2)%3
        Log.d(TAG, "perPage: currentIndex = $currentIndex")
    }

    companion object{

        private var instance:CircularBitmapQueue? = null
        fun getInstance(context: Context):CircularBitmapQueue{
            val i = instance
            if(i != null){
                return i
            }
            return synchronized(this){
                val i2 = instance
                if(i2 != null){
                    i2
                }else{
                    val created = CircularBitmapQueue(context)
                    instance = created
                    created
                }
            }
        }
    }

}