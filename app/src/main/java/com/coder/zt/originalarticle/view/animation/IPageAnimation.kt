package com.coder.zt.originalarticle.view.animation

import android.content.Context
import android.graphics.Canvas
import android.graphics.Point

interface IPageAnimation {

    fun drawCurrentState(canvas: Canvas,drawPoint: Point, curPoint: Point, next:Boolean)
}