package com.coder.zt.originalarticle.view.animation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Point
import android.graphics.Rect
import android.util.Log
import com.coder.zt.originalarticle.view.factory.CircularBitmapQueue

class VerticalSlideAnimation(private val context: Context):IPageAnimation{

    private val TAG = "VerticalSlideAnimation"
    override fun drawCurrentState(canvas: Canvas,drawPoint:Point, curPoint: Point, next: Boolean) {
        Log.d(TAG, "drawCurrentState: $drawPoint next: $next")
        val currentBitmap = CircularBitmapQueue.getInstance(context).getCurrentBitmap()
        val nextBitmap = CircularBitmapQueue.getInstance(context).getNextBitmap()
        val preBitmap = CircularBitmapQueue.getInstance(context).getPerBitmap()

        if(drawPoint.y >= 0){//上滑，翻下一页
            val distanceSlide = drawPoint.y
            //canvas分为上下两个部分
            val upCanvas = Rect(0, 0, nextBitmap.width, nextBitmap.height - distanceSlide)
            val downCanvas = Rect(0, nextBitmap.height - distanceSlide, nextBitmap.width, nextBitmap.height)
            Log.d(TAG, "drawCurrentState:upCanvas --->  $upCanvas")
            Log.d(TAG, "drawCurrentState:downCanvas --->  $downCanvas")
            //取当前页的下部分，取后一页的上部分
            val currentDownRect = Rect(0, distanceSlide, nextBitmap.width, nextBitmap.height)
            val nextUpRect = Rect(0, 0, nextBitmap.width,  distanceSlide)
            Log.d(TAG, "drawCurrentState:currentRightRect --->  $currentDownRect")
            Log.d(TAG, "drawCurrentState:nextLeftRect --->  $nextUpRect")
            canvas.drawBitmap(currentBitmap,currentDownRect, upCanvas, Paint())
            canvas.drawBitmap(nextBitmap,nextUpRect, downCanvas, Paint())
        }else{
            val distanceSlide = -drawPoint.y
            //canvas分为上下两个部分
            val upCanvas = Rect(0, 0, nextBitmap.width, distanceSlide)
            val downCanvas = Rect(0, distanceSlide, nextBitmap.width, nextBitmap.height)
            Log.d(TAG, "drawCurrentState:upCanvas --->  $upCanvas")
            Log.d(TAG, "drawCurrentState:downCanvas --->  $downCanvas")
            //取前一页的后部分，取当前页的前部分
            val perDownRect = Rect(0, nextBitmap.height - distanceSlide, nextBitmap.width, nextBitmap.height)
            val currentUpRect = Rect(0, 0, nextBitmap.width, nextBitmap.height - distanceSlide)
            Log.d(TAG, "drawCurrentState:perDownRect --->  $perDownRect")
            Log.d(TAG, "drawCurrentState:currentUpRect --->  $currentUpRect")
            canvas.drawBitmap( preBitmap,perDownRect, upCanvas, Paint())
            canvas.drawBitmap(currentBitmap,currentUpRect, downCanvas, Paint())
        }
    }

}