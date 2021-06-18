package com.coder.zt.originalarticle.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Scroller
import com.coder.zt.originalarticle.view.animation.CommonSlideAnimation
import com.coder.zt.originalarticle.view.animation.IPageAnimation
import com.coder.zt.originalarticle.view.utils.ScreenUtils
import kotlin.math.pow
import kotlin.math.sqrt

class PageView(context: Context, attrs:AttributeSet): View(context, attrs) {

    private  val TAG = "PageView"
    private val clickTime:Long = 150
    private val disten:Long = 20
    private var nextDirection:Boolean = true
    private var currentDrawPoint:Point = Point(0, 0)
    private var currentTouchPoint:Point = Point(0, 0)
    private var downTouchPoint:Point = Point(0, 0)
    private var downTouchTime:Long = -1
    private var upTouchTime:Long = -1
    private var canSlidePage = false
    private val mScroller:Scroller by lazy {
        val interpolator = AccelerateDecelerateInterpolator()
        Scroller(context, interpolator)
    }
    private val pageAnimation:IPageAnimation by lazy {
        CommonSlideAnimation(context)
    }
    private var mListener:OnTouchEventListener? = null
        fun set(listener: OnTouchEventListener) {
             mListener = listener
        }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas != null) {
            pageAnimation.drawCurrentState(canvas, currentDrawPoint,currentTouchPoint, nextDirection)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            currentTouchPoint = Point(event.x.toInt(), event.y.toInt())
            when (event.action) {
                MotionEvent.ACTION_DOWN-> {
                    downTouchPoint = currentTouchPoint
                    downTouchTime = System.currentTimeMillis()
                }
                MotionEvent.ACTION_MOVE-> {
                    updateDrawPoint()
                    if(isLongCLick()){
                        mListener?.onLongClick(Point(currentTouchPoint.x, currentTouchPoint.y))
                    }
                }
                MotionEvent.ACTION_UP-> {
                    updateDrawPoint()
                    upTouchTime = System.currentTimeMillis()
                    if(isClickEvent()){
                        mListener?.onClick(Point(currentTouchPoint.x, currentTouchPoint.y))
                    }else if(isLongCLick()){
                        mListener?.onLongClick(Point(currentTouchPoint.x, currentTouchPoint.y))
                    }else{
                        startPageSlide()
                    }
                }
            }
            invalidate()
        }

        return true
    }

    private fun startPageSlide() {
        Log.d(TAG, "startPageSlide: ")
        val dx = ScreenUtils.getScreenSize(context).x
        mScroller.startScroll(currentDrawPoint.x,0,dx-currentDrawPoint.x, 0)
        canSlidePage = true
    }

    private fun isLongCLick(): Boolean {
        val touchTime = upTouchTime - downTouchTime
        val moveDistance = getTwoPointDistance(currentTouchPoint, downTouchPoint)
        return touchTime > 1000 && moveDistance < disten
    }

    private fun updateDrawPoint() {
        //横向滑动的时候
        nextDirection = currentTouchPoint.x <= downTouchPoint.x
        val xDiff = kotlin.math.abs(downTouchPoint.x - currentTouchPoint.x)
        val yDiff = kotlin.math.abs(downTouchPoint.y - currentTouchPoint.y)
        currentDrawPoint = Point(xDiff, yDiff)
    }

    private fun isClickEvent():Boolean{
        val touchTime = upTouchTime - downTouchTime
        val moveDistance = getTwoPointDistance(currentTouchPoint, downTouchPoint)
        return touchTime < clickTime && moveDistance < disten
    }

    private fun getTwoPointDistance(currentTouchPoint: Point, downTouchPoint: Point): Float {
        val xPow = (currentTouchPoint.x - downTouchPoint.x).toDouble().pow(2.0)
        val yPow = (currentTouchPoint.y - downTouchPoint.y).toDouble().pow(2.0)
        return sqrt(xPow + yPow).toFloat()
    }

    override fun computeScroll() {
        if (mScroller.computeScrollOffset()) {
            Log.d(TAG, "computeScroll: ${mScroller.currX}")
            currentDrawPoint.x = mScroller.currX
            invalidate()
        }else if(canSlidePage){
            mListener?.apply {
                if(nextDirection){
                    nextPage()
                }else {
                    perPage()
                }
            }
            currentDrawPoint.x = 0
            nextDirection = true
            canSlidePage = false
            invalidate()
        }
    }

    interface OnTouchEventListener{

        fun onClick(point:Point)

        fun onLongClick(point:Point)

        fun nextPage()

        fun perPage()
    }
}