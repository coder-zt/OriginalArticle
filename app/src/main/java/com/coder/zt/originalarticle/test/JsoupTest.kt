package com.coder.zt.originalarticle.test

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

open class JsoupTest {

    fun parseHtml(html:String){
        val parse:Document = Jsoup.parse(html)
        val childrenSize = parse.body().children().size
        Log.d(TAG, "parseHtml: $childrenSize")
    }

    companion object {
        private const val TAG = "JsoupTest"
    }
}