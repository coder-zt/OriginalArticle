package com.coder.zt.originalarticle.view.animation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Point
import android.graphics.Rect
import android.util.Log
import com.coder.zt.originalarticle.view.factory.CircularBitmapQueue

class CommonSlideAnimation(private val context: Context):IPageAnimation{

    private val TAG = "CommonSlideAnimation"
    override fun drawCurrentState(canvas: Canvas,drawPoint:Point, curPoint: Point, next: Boolean) {
        Log.d(TAG, "drawCurrentState: $drawPoint next: $next")
        val currentBitmap = CircularBitmapQueue.getInstance(context).getCurrentBitmap()
        val nextBitmap = CircularBitmapQueue.getInstance(context).getNextBitmap()
        val preBitmap = CircularBitmapQueue.getInstance(context).getPerBitmap()

        if(next){
            //canvas分为左右两个部分
            val leftCanvas = Rect(0, 0, nextBitmap.width - drawPoint.x, nextBitmap.height)
            val rightCanvas = Rect(nextBitmap.width - drawPoint.x, 0, nextBitmap.width, nextBitmap.height)
            Log.d(TAG, "drawCurrentState:leftCanvas --->  $leftCanvas")
            Log.d(TAG, "drawCurrentState:rightCanvas --->  $rightCanvas")
            //取当前页的后部分，取后一页的前部分
            val currentRightRect = Rect(drawPoint.x, 0, nextBitmap.width, nextBitmap.height)
            val nextLeftRect = Rect(0, 0, drawPoint.x, nextBitmap.height)
            canvas.drawBitmap(currentBitmap,currentRightRect, leftCanvas, Paint())
            canvas.drawBitmap(nextBitmap,nextLeftRect, rightCanvas, Paint())
        }else{
            //canvas分为左右两个部分
            val leftCanvas = Rect(0, 0, drawPoint.x, nextBitmap.height)
            val rightCanvas = Rect(drawPoint.x, 0, nextBitmap.width, nextBitmap.height)
            Log.d(TAG, "drawCurrentState:leftCanvas --->  $leftCanvas")
            Log.d(TAG, "drawCurrentState:rightCanvas --->  $rightCanvas")
            //取前一页的后部分，取当前页的前部分
            val perRightRect = Rect(drawPoint.x, 0, nextBitmap.width, nextBitmap.height)
            val currentLeftRect = Rect(0, 0, drawPoint.x, nextBitmap.height)
            canvas.drawBitmap(preBitmap,perRightRect, leftCanvas, Paint())
            canvas.drawBitmap(currentBitmap,currentLeftRect, rightCanvas, Paint())
        }
    }

}