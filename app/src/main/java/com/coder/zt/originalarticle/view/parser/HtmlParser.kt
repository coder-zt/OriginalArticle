package com.coder.zt.originalarticle.view.parser

import android.util.Log
import com.coder.zt.originalarticle.test.JsoupTest
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import java.lang.StringBuilder

class HtmlParser {

    private val TAG = "HtmlParser"

    val contentList = mutableListOf<Map<String, String>>()

    fun parseHtml(html:String):List<Map<String, String>>{
        val parse: Document = Jsoup.parse(html)
        val body = parse.body()
        traverseNodes(body, 0)
        return contentList
    }

    private fun traverseNodes(body: Element, grade:Int){
        if(body.id() == "article-content"){
            contentList.clear()
            parseArticleContent(body, 0)
            return
        }else{
            for (child in body.children()) {
               traverseNodes(child, grade+1)
            }
        }
    }

    private fun parseArticleContent(content: Element, i:Int) {
        if(content.tagName().contains("h")){
            contentList.add(mapOf(content.tagName() to content.text()))
        }
        if(content.tagName() == "p" && content.hasText()){

            contentList.add(mapOf(content.tagName() to content.text()))
        }
        if(content.tagName() == "img"){
            contentList.add(mapOf(content.tagName() to content.attr("src")))
        }
        if(content.tagName() == "code"){
            contentList.add(mapOf(content.tagName() to content.text()))
        }
        for (child in content.children()) {
            parseArticleContent(child, i + 1)
        }
    }

}