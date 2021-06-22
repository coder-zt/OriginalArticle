package com.coder.zt.originalarticle.view

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.VelocityTracker
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Scroller
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun
import com.coder.zt.originalarticle.view.animation.CommonSlideAnimation
import com.coder.zt.originalarticle.view.animation.IPageAnimation
import com.coder.zt.originalarticle.view.animation.VerticalSlideAnimation
import com.coder.zt.originalarticle.view.utils.ScreenUtils
import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

class PageView(context: Context, attrs:AttributeSet): View(context, attrs) {

    private  val TAG = "PageView"
    private val clickTime:Long = 150
    private val disten:Long = 20
    private var nextDirection:Boolean = true
    private val currentDrawPoint:Point = Point(0, 0)
    private val currentTouchPoint:Point = Point(0, 0)
    private var downTouchPoint:Point = Point(0, 0)
    private var downTouchTime:Long = -1
    private var upTouchTime:Long = -1
    private var canSlidePage = false
    private val pageStyle:Int = 1
    private var mOnceSlideDistance = 0
    private var perCurrentPointY = 0
    private val mScroller:Scroller by lazy {
        val interpolator = AccelerateDecelerateInterpolator()
        Scroller(context, interpolator)
    }
    private val mFlyScroller:Scroller by lazy {
        val interpolator = AccelerateDecelerateInterpolator()
        Scroller(context, interpolator)
    }
    private val pageAnimation:IPageAnimation by lazy {
        when(pageStyle){
            0-> CommonSlideAnimation(context)
            1-> VerticalSlideAnimation(context)
            else -> CommonSlideAnimation(context)
        }

    }
    private var mListener:OnTouchEventListener? = null
        fun set(listener: OnTouchEventListener) {
             mListener = listener
        }
    private val mVelocityTracker: VelocityTracker by lazy {
        VelocityTracker.obtain()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas != null) {
            pageAnimation.drawCurrentState(canvas, currentDrawPoint,currentTouchPoint, nextDirection)
        }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            mVelocityTracker.addMovement(event)
            perCurrentPointY = currentTouchPoint.y
            currentTouchPoint.x = event.x.toInt()
            currentTouchPoint.y = event.y.toInt()
            when (event.action) {
                MotionEvent.ACTION_DOWN-> {
                    mFlyScroller.abortAnimation()
                    downTouchPoint.x = currentTouchPoint.x
                    downTouchPoint.y = currentTouchPoint.y
                    downTouchTime = System.currentTimeMillis()
                }
                MotionEvent.ACTION_MOVE-> {
                    updateDrawPoint(false)
                    if(isLongCLick()){
                        mListener?.onLongClick(Point(currentTouchPoint.x, currentTouchPoint.y))
                    }
                }
                MotionEvent.ACTION_UP-> {
                    updateDrawPoint(true)
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
        if(pageStyle == 1){
            return
        }
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

    private fun updateDrawPoint(isUp:Boolean) {
        //纵向滑动的时候
        nextDirection = if(pageStyle == 1){
            val xDiff =downTouchPoint.x - currentTouchPoint.x
            var yDiff =downTouchPoint.y - currentTouchPoint.y
            val yyDiff = yDiff
            yDiff += mOnceSlideDistance

            if(yDiff > ScreenUtils.getScreenSize(context).y){
                mListener?.apply {
                    nextPage()
                }
                yDiff -= ScreenUtils.getScreenSize(context).y
                downTouchPoint.y = currentTouchPoint.y
                downTouchPoint.x = currentTouchPoint.x
                mOnceSlideDistance = yDiff
            }else if(yDiff < (-ScreenUtils.getScreenSize(context).y)){
                mListener?.apply {
                    perPage()
                }
                yDiff += ScreenUtils.getScreenSize(context).y
                downTouchPoint.y = currentTouchPoint.y
                downTouchPoint.x = currentTouchPoint.x
                mOnceSlideDistance = yDiff
            } else if(isUp){
                mOnceSlideDistance = yDiff
                mVelocityTracker.computeCurrentVelocity(1000)
                mVelocityTracker.yVelocity
                Log.d(TAG, "updateDrawPoint: YVerlocity: ${mVelocityTracker.yVelocity}")
                mFlyScroller.startScroll(0,mVelocityTracker.yVelocity.toInt(),0, -mVelocityTracker.yVelocity.toInt(),1000)
            }
            currentDrawPoint.x = xDiff
            currentDrawPoint.y = yDiff
            Log.d(TAG, "updateDrawPoint: mOnceSlideDistance: $mOnceSlideDistance  yDiff: $yDiff $yyDiff ")
            var dir = currentTouchPoint.y < perCurrentPointY
            if(currentTouchPoint.y == perCurrentPointY ){
                dir = nextDirection
            }
            dir
        //横向滑动的时候
        }else{
            val xDiff = kotlin.math.abs(downTouchPoint.x - currentTouchPoint.x)
            val yDiff = kotlin.math.abs(downTouchPoint.y - currentTouchPoint.y)
            currentDrawPoint.x = xDiff
            currentDrawPoint.y = yDiff
            currentTouchPoint.y < perCurrentPointY
        }
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
            if (pageStyle != 1) {
                nextDirection = true
            }
            canSlidePage = false
            invalidate()
        }
        if(mFlyScroller.computeScrollOffset()){
            Log.d(TAG, "computeScroll: mFlyScroller.currY: ${mFlyScroller.currY}")
            updateFlyDrawPoint(mFlyScroller.currY)
            invalidate()
        }
    }

    private fun updateFlyDrawPoint(currY: Int) {
        val xDiff =0
        var yDiff = mOnceSlideDistance - currY/80
        mOnceSlideDistance = yDiff
        if(yDiff > ScreenUtils.getScreenSize(context).y){
            mListener?.apply {
                nextPage()
            }
            yDiff -= ScreenUtils.getScreenSize(context).y
            mOnceSlideDistance = yDiff
        }else if(yDiff < (-ScreenUtils.getScreenSize(context).y)){
            mListener?.apply {
                perPage()
            }
            yDiff += ScreenUtils.getScreenSize(context).y
            mOnceSlideDistance = yDiff
        }
        currentDrawPoint.x = xDiff
        currentDrawPoint.y = yDiff
    }


    interface OnTouchEventListener{

        fun onClick(point:Point)

        fun onLongClick(point:Point)

        fun nextPage()

        fun perPage()
    }
}