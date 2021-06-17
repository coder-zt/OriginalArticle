package com.coder.zt.originalarticle.view.factory

import android.graphics.Bitmap

interface ICircularBitmapQueue {

    fun getCurrentBitmap():Bitmap

    fun getPerBitmap():Bitmap

    fun getNextBitmap():Bitmap

}