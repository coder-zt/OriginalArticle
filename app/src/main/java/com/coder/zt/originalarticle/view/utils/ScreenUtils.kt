package com.coder.zt.originalarticle.view.utils

import android.content.Context
import android.content.res.Resources
import android.graphics.Point


class ScreenUtils {
    companion object{
        fun getScreenSize(context:Context):Point{
            val resources: Resources = context.resources
            val dm = resources.displayMetrics
            val density = dm.density
            val width = dm.widthPixels
            val height = dm.heightPixels
            return Point(width,height)
        }
    }
}