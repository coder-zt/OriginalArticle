package com.coder.zt.originalarticle.view.utils

import android.content.Context
import android.content.res.Resources
import android.graphics.Point


class ScreenUtils {
    companion object{
        fun getScreenDensity(context:Context):Float{
            val resources: Resources = context.resources
            val dm = resources.displayMetrics
            return dm.density
        }

        fun getScreenSize(context:Context):Point{
            val resources: Resources = context.resources
            val dm = resources.displayMetrics
            val width = dm.widthPixels
            val height = dm.heightPixels
            return Point(width,height)
        }

        /**
         * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
         */
        fun dip2px(dpValue: Float,context:Context): Float {
            return (0.5f + dpValue * getScreenDensity(context))
        }
    }
}