package com.coder.zt.originalarticle

open class HtmlArticleData {
    companion object{


     open val htmlData: String = """<div class="article-content-part border-radius-default"><div class="article-header"><div class="article-title-part"><span>阳光沙滩API文档</span></div> <div class="article-cover"><img src="https://images.sunofbeaches.com/content/2021_06_09/852231982405386240.png"></div> <div class="article-publish-time clear-fix"><div class="publish-info-left-part float-left"><a href="/u/1153952789488054272"><span class="el-avatar el-avatar--small el-avatar--circle"><img src="https://imgs.sunofbeaches.com/group1/M00/00/07/rBsADV22ZymAV8BwAABVL9XtNSU926.png" style="object-fit:cover;"></span> <span title="" class="article-detail-user-name">拉大锯</span></a> <span> 发表于 </span> <span class="iconfont iconriqi2"></span> <span>2021-06-11 16:08</span> <span class="el-icon-view"></span> <span>14</span></div> <div class="publish-info-left-right float-right"><!----> <!----> <!----> <button type="button" class="el-button el-button--success el-button--mini is-plain" id="follow-btn"><!----><!----><span>相互关注
        </span></button></div></div> <div class="article-label-part"><span><a href="/search?keyword=阳光沙滩" target="_blank">
        阳光沙滩
        </a></span><span><a href="/search?keyword=API" target="_blank">
        API
        </a></span><span><a href="/search?keyword=文档" target="_blank">
        文档
        </a></span><span><a href="/search?keyword=接口" target="_blank">
        接口
        </a></span><span><a href="/search?keyword=后台" target="_blank">
        后台
        </a></span></div></div> <!----> <div class="article-content-container" style=""><div id="article-content" class="article-content"><h1 id="heading-0">阳光沙滩API文档</h1>
        <p>api逐步开方，也会逐步完善，同学们可以通过API学习相关的知识。</p>
        <p><code>password</code>字段要进行md5转换，不可以提交明文。</p>
        <h1 id="heading-1">用户相关的接口：</h1>
        <ul>
        <li>图灵验证码</li>
        <li>登录</li>
        <li>退出登录</li>
        <li>检查token是否有效</li>
        <li>获取手机验证码（注册）</li>
        <li>注册</li>
        <li>获取手机验证码（找回密码）</li>
        <li>找回密码（凭借手机验证码进行更新）</li>
        <li>检查手机验证码是否正确</li>
        <li>更新密码（凭借旧密码进行更新）</li>
        </ul>
        <h2 id="heading-2">API访问路径</h2>
        <pre style="display: block;"><code class="language-shell hljs">https://api.sunofbeach.net
        </code></pre>
        <h2 id="heading-3">图灵验证码</h2>
        <pre style="display: block;"><code class="language-shell hljs">/uc/ut/captcha?code=随机数
        </code></pre>
        <p><img src="https://api.sunofbeach.net/uc/ut/captcha?code=随机数" alt="验证码"></p>
        <h2 id="heading-4">登录</h2>
        <pre style="display: block;"><code class="language-shell hljs">/uc/user/login/{captcha}
        </code></pre>
        <ul>
        <li>query参数：captcha 前面图片验证码内容</li>
        <li>请求方式：Post</li>
        <li>body 参数user</li>
        </ul>
        <pre style="display: block;"><code class="language-json hljs">user: {
            phoneNum: '',
            password: ''
        }
        </code></pre>
        <p><code>phoneNum</code>为手机号码，<code>password</code>为密码，不可以是明文，需要MD5算法计算摘要。</p>
        <p>我把断点坑了[捂脸]</p>
        <h2 id="heading-5">退出登录</h2>
        <pre style="display: block;"><code class="language-shell hljs">/uc/user/logout
        </code></pre>
        <ul>
        <li>请求方式：Get</li>
        </ul>
        <h2 id="heading-6">Token解析</h2>
        <pre style="display: block;"><code class="language-shell hljs">/uc/user/checkToken
        </code></pre>
        <ul>
        <li>要cookie支持，token在cookie里。</li>
        <li>请求方式：get</li>
        </ul>
        <h2 id="heading-7">获取注册的手机验证码（注册）</h2>
        <pre style="display: block;"><code class="language-shell hljs">/uc/ut/join/send-sms
        </code></pre>
        <ul>
        <li>请求方式：POST</li>
        <li>body参数：<code>sendSmsVo</code></li>
        </ul>
        <pre style="display: block;"><code class="language-json hljs">sendSmsVo: {
            phoneNumber: '',
            verifyCode: ''
        }
        </code></pre>
        <p><code>verifyCode</code>为图灵验证码</p>
        <h2 id="heading-8">获取找回密码的手机验证码（找回密码）</h2>
        <pre style="display: block;"><code class="language-shell hljs">/uc/ut/forget/send-sms
        </code></pre>
        <ul>
        <li>请求方式：POST</li>
        <li>body参数：</li>
        </ul>
        <pre style="display: block;"><code class="language-json hljs">sendSmsVo: {
            phoneNumber: '',
            verifyCode: ''
        }
        </code></pre>
        <p><code>verifyCode</code>为图灵验证码</p>
        <h2 id="heading-9">检查手机验证码是否正确</h2>
        <pre style="display: block;"><code class="language-shell hljs">/uc/ut/check-sms-code/{phoneNumber}/{smsCode}
        </code></pre>
        <ul>
        <li>请求方式：Get</li>
        <li>query参数：<code>phoneNumber</code>为手机号码</li>
        <li>query参数：<code>smsCode</code>为短信验证码</li>
        </ul>
        <h2 id="heading-10">注册账号</h2>
        <pre style="display: block;"><code class="language-shell hljs">/uc/user/register/{smsCode}
        </code></pre>
        <ul>
        <li>请求方式：POST</li>
        <li>query参数：smsCode，前面请求的短信验证码</li>
        <li>body参数：user</li>
        </ul>
        <pre style="display: block;"><code class="language-json hljs"> user: {
            phoneNum: '',
            password: '',
            nickname: ''
        }
        </code></pre>
        <h2 id="heading-11">找回密码（通过短信找回）</h2>
        <pre style="display: block;"><code class="language-shell hljs">/uc/user/forget/{smsCode}
        </code></pre>
        <ul>
        <li>请求方式：Put</li>
        <li>query参数：<code>smsCode</code>为短信验证码</li>
        <li>body参数</li>
        </ul>
        <pre style="display: block;"><code class="language-json hljs">userVo: {
            phoneNum: '',
            password: ''
        }
        </code></pre>
        <h2 id="heading-12">修改密码（通过旧密码修改）</h2>
        <pre style="display: block;"><code class="language-shell hljs">/uc/user/modify-pwd
        </code></pre>
        <ul>
        <li>请求方式：Put</li>
        <li>body参数：modifyPwdVo</li>
        </ul>
        <pre style="display: block;"><code class="language-json hljs">modifyPwdVo: {
            oldPwd: '',
            newPwd: '',
            captcha: ''
        }
        </code></pre>
        <p><code>captcha</code> 为图灵验证码</p>
        <h1 id="heading-13">猿村（摸鱼）</h1>
        <p>猿村接口有：</p>
        <ul>
        <li>获取动态列表</li>
        <li>获取热门动态列表</li>
        <li>获取动态评论</li>
        <li>动态点赞</li>
        <li>发表评论</li>
        <li>发表动态子评论（回复评论，也就是评论的评论）</li>
        <li>上传图片</li>
        <li>删除图片</li>
        <li>发表动态</li>
        <li>获取动态详情（单条动态获取）</li>
        <li>根据size获取话题（类似于猿村侧栏）</li>
        <li>获取所有的话题</li>
        <li>解析Url</li>
        <li>关注话题</li>
        <li>取消关注话题</li>
        <li>获取关注的话题列表</li>
        </ul>
        <h2 id="heading-14">获取动态列表</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/moyu/list/{topicId}/{page}
        </code></pre>
        <ul>
        <li>请求方式：Get</li>
        <li>参数：<code>topicId</code> 话题Id，其中推荐为<code>recommend</code>，获取关注的为 <code>follow</code> 其他的则是话题的id</li>
        <li>参数：page 为页码，从1开始</li>
        </ul>
        <h2 id="heading-15">获取热门动态列表</h2>
        <p>此接口类似于右侧栏的内容，近几天点赞多的则会上榜。</p>
        <pre style="display: block;"><code class="language-shell hljs">/ct/moyu/hot/{size}
        </code></pre>
        <ul>
        <li>请求方法：GET</li>
        <li>参数：size 数量</li>
        </ul>
        <h2 id="heading-16">获取动态评论</h2>
        <p>当点击评论的时候，或者是跳转到动态详情页面的时候，可以通过此接口获取到动态的评论内容。</p>
        <pre style="display: block;"><code class="language-shell hljs">/ct/moyu/comment/{momentId}/{page}
        </code></pre>
        <ul>
        <li>请求方法：GET</li>
        <li>参数momentId：动态的ID</li>
        <li>参数page：页码，第1页开始</li>
        </ul>
        <h2 id="heading-17">动态点赞</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/moyu/thumb-up/{momentId}
        </code></pre>
        <ul>
        <li>请求方式：PUT</li>
        <li>参数：momentId 动态ID</li>
        </ul>
        <h2 id="heading-18">发表评论(评论动态)</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/moyu/comment
        </code></pre>
        <ul>
        <li>请求方法：POST</li>
        <li>body参数：momentComment</li>
        </ul>
        <pre style="display: block;"><code class="language-json hljs">comment: {
            momentId: '',
            content: ''
        }
        </code></pre>
        <p><code>momentId</code>为动态ID,<code>content</code>为评论内容。</p>
        <h2 id="heading-19">回复评论</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/moyu/sub-comment
        </code></pre>
        <ul>
        <li>请求方法:POST</li>
        <li>body参数：momentSubComment</li>
        </ul>
        <pre style="display: block;"><code class="language-json hljs">subComment: {
            content: '',
            momentId: '',
            targetUserId: '',
            commentId: ''
        }
        </code></pre>
        <p><code>content</code>为评论内容，<code>momentId</code>为动态Id，<code>targetUserId</code>是被评论内容的用户Id，<code>commentId</code>为被评论内容的Id</p>
        <h2 id="heading-20">上传动态图片：</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/image/mo_yu
        </code></pre>
        <ul>
        <li>请求方式：POST</li>
        <li>请求参数：image</li>
        </ul>
        <h2 id="heading-21">发表动态</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/moyu
        </code></pre>
        <ul>
        <li>请求方式：POST</li>
        <li>body参数：moment</li>
        </ul>
        <pre style="display: block;"><code class="language-json hljs"> moment: {
            content: '',
            topicId: '',
            images: []
        }
        </code></pre>
        <ul>
        <li>content为内容</li>
        <li>linkUrl为链接</li>
        <li>topicId为话题Id</li>
        <li>images为图片列表，图片链接地址，最多4张</li>
        </ul>
        <h2 id="heading-22">获取单条动态详情</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/moyu/{momentId}
        </code></pre>
        <ul>
        <li>请求方式：GET</li>
        <li>query参数：momentId动态的ID</li>
        </ul>
        <h2 id="heading-23">获取首页话题（类似于摸鱼首页侧栏）</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/moyu/topic/index
        </code></pre>
        <ul>
        <li>请求方式：GET</li>
        </ul>
        <h2 id="heading-24">获取话题列表</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/moyu/topic
        </code></pre>
        <ul>
        <li>请求方法：GET</li>
        </ul>
        <h2 id="heading-25">关注话题</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/moyu/topic/follow/{id}
        </code></pre>
        <ul>
        <li>请求方式：POST</li>
        <li>参数：id为话题id</li>
        </ul>
        <h2 id="heading-26">取消话题关注</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/moyu/topic/follow/{id}
        </code></pre>
        <ul>
        <li>请求方式：DELETE</li>
        <li>参数：id为话题id</li>
        </ul>
        <h2 id="heading-27">获取关注的话题列表</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/moyu/topic/follow
        </code></pre>
        <ul>
        <li>请求方法：GET</li>
        </ul>
        <h1 id="heading-28">首页</h1>
        <ul>
        <li>获取分类列表</li>
        <li>获取推荐内容</li>
        <li>根据分类获取内容</li>
        </ul>
        <h2 id="heading-29">获取分类列表</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/category/list
        </code></pre>
        <ul>
        <li>请求方法：GET</li>
        </ul>
        <h2 id="heading-30">获取推荐内容</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/content/home/recommend/{page}
        </code></pre>
        <ul>
        <li>请求方法：GET</li>
        <li>query参数：page 页码，从1开始</li>
        </ul>
        <h2 id="heading-31">根据分类获取内容</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/content/home/recommend/{categoryId}/{page}
        </code></pre>
        <ul>
        <li>请求方法：GET</li>
        <li>queyr参数：<code>categoryId</code> 分类的ID</li>
        <li>queyr参数：<code>page</code> 页码，第1页开始</li>
        </ul>
        <h1 id="heading-32">问答模块</h1>
        <h2 id="heading-33">获取问答列表</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/wenda/list?page=page&amp;state=state&amp;category=category
        </code></pre>
        <ul>
        <li>请求方法：GET</li>
        <li>page参数，页码，从1开始</li>
        <li>state，状态：lastest最新的，noanswer等待解决的，hot热门的</li>
        <li>category：-2</li>
        </ul>
        <h2 id="heading-34">获取回答排行榜</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ast/rank/answer-count/{size}
        </code></pre>
        <ul>
        <li>请求方法：GET</li>
        <li>参数size：数量5~10</li>
        </ul>
        <h2 id="heading-35">查询当前用户是否有点赞该问题</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/wenda/thumb-up/check/{wendaId}
        </code></pre>
        <ul>
        <li>请求方法：GET</li>
        <li>wendaId参数：问题的id</li>
        <li>需要cookie支持</li>
        </ul>
        <h2 id="heading-36">检查是否有点赞某个回答</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/wenda/comment/thumb-up/check/{commentId}
        </code></pre>
        <ul>
        <li>请求方法：GET</li>
        <li>commentId 参数 评论Id</li>
        <li>需要cookie支持</li>
        </ul>
        <h2 id="heading-37">获取问答详情</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/wenda/{wendaId}
        </code></pre>
        <ul>
        <li>请求方法：Get</li>
        <li>wendaId 参数：问题的Id</li>
        </ul>
        <h2 id="heading-38">问答图片上传</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/image/answer
        </code></pre>
        <ul>
        <li>请求方法：POST</li>
        <li>请求参数：image</li>
        </ul>
        <h2 id="heading-39">发表答案</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/wenda/comment
        </code></pre>
        <ul>
        <li>请求方法：POST</li>
        <li>body参数：answer</li>
        </ul>
        <pre style="display: block;"><code class="language-json hljs">  answer: {
            wendaId: '',
            content: ''
        },
        </code></pre>
        <h2 id="heading-40">评论答案</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/wenda/sub-comment
        </code></pre>
        <ul>
        <li>请求方法：POST</li>
        <li>body参数： wendaSubComment</li>
        </ul>
        <pre style="display: block;"><code class="language-json hljs">subComment: {
            content: '',
            parentId: '',
            beNickname: '',
            beUid: '',
            wendaId: '',
        }
        </code></pre>
        <ul>
        <li>parentId 被评论的答案ID</li>
        <li>beNickname 被评论人的昵称</li>
        <li>beUid 被评论人的用户ID</li>
        <li>wendaId 问题的ID</li>
        </ul>
        <h2 id="heading-41">获取答案列表</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/wenda/comment/list/{wendaId}/{page};
        </code></pre>
        <ul>
        <li>请求方法：GET</li>
        <li>wendaId参数：问题的Id</li>
        <li>page参数：页码，从第1页开始</li>
        </ul>
        <h2 id="heading-42">获取相关的问题</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/wenda/relative/{wendaId}/{size}
        </code></pre>
        <ul>
        <li>请求方法：GET</li>
        <li>wendaId 参数，当前问题的Id</li>
        <li>size 参数：推荐数量</li>
        </ul>
        <h2 id="heading-43">问题点赞</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/wenda/thumb-up/{wendaId}
        </code></pre>
        <ul>
        <li>请求方法：PUT</li>
        <li>请求参数:wendaId 问题的ID</li>
        </ul>
        <h2 id="heading-44">问题回答点赞</h2>
        <pre style="display: block;"><code class="language-shell hljs">/ct/wenda/comment/thumb-up/{wendaCommentId}
        </code></pre>
        <ul>
        <li>请求方法：PUT</li>
        <li>wendaCommentId:回答的ID</li>
        </ul>
        <h2 id="heading-45">设置为最佳答案</h2>
        <p>此接口只在当前用户与当前问答的用户一样时才可以显示，才可以调用，否则返回无权限的结果</p>
        <pre style="display: block;"><code class="language-shell hljs">/ct/wenda/comment/best/{wendaId}/{wendaCommentId}
        </code></pre>
        <ul>
        <li>请求方法：PUT</li>
        <li>wendaId：问题的Id</li>
        <li>wendaCommentId：答案的Id</li>
        </ul>
        <h2 id="heading-46">答案打赏</h2>
        <pre style="display: block;"><code class="language-shell hljs">'/ct/wenda/comment/prise/{commentId}/{count}?thumbUp=thumb
        </code></pre>
        <ul>
        <li>请求方法：PUT</li>
        <li>commentId 答案id</li>
        <li>count 打赏积分数量</li>
        <li>thumb：true/false true表示同时点赞</li>
        </ul>
        <blockquote>
        <p>=========华丽的分割线==============================</p>
        </blockquote>
        <p>关于内容的字段解析，我有空再补上， 同学们先进行模拟请求，如果有字段不知道什么意思的，可以发帖子哈。</p>
        <p>有空我就更新文档...同学们一步一步开发吧。遇到问题可以发帖子。</p>
        </div> <div class="prise-qr-code"><div class="prise-tips">"我视别人的钱财为粪土，但是你的就不一样啦！"</div> <div class="qr-code"><div class="el-image"><img src="https://imgs.sunofbeaches.com/group1/M00/00/02/rBPLFV1x6Q2AMjxyAADy5tr458c500.jpg" width="180" height="180" class="el-image__inner" style="object-fit: cover;"><!----></div></div></div> <div class="article-content-more"><div class="article-content-action"><button type="button" class="el-button el-button--default el-button--medium is-plain"><!----><!----><span><span class="iconfont iconiconfontdianzan11"></span> <span id="article-content-bottom-thumbup-count">5</span>人觉得牛逼
        </span></button> <button type="button" class="el-button el-button--default el-button--medium is-plain"><!----><!----><span><span class="el-icon-collection-tag"></span> 收藏
        </span></button> <button type="button" class="el-button article-prise-btn el-button--danger el-button--medium is-plain"><!----><!----><span>
        $ 打赏
        </span></button></div></div> <!----></div></div>"""

        open val htmlData1 = """
            <div class="article-content-part border-radius-default"><div class="article-header"><div class="article-title-part"><span>阳光沙滩博客Android实现登录</span></div> <div class="article-cover"><img src="https://images.sunofbeaches.com/content/2021_06_13/853678020374822912.jpg"></div> <div class="article-publish-time clear-fix"><div class="publish-info-left-part float-left"><a href="/u/1139423796017500160"><span class="el-avatar el-avatar--small el-avatar--circle"><img src="https://imgs.sunofbeaches.com/group1/M00/00/04/rBsADV2YuTKABc4DAABfJHgYqP8031.png" style="object-fit:cover;"></span> <span title="VIP会员" class="article-detail-user-name vip-red-name">断点-含光君</span></a> <span> 发表于 </span> <span class="iconfont iconriqi2"></span> <span>2021-06-13 13:32</span> <span class="el-icon-view"></span> <span>32</span></div> <div class="publish-info-left-right float-right"><button type="button" class="el-button el-button--success el-button--mini" id="follow-btn"><!----><!----><span>关注作者
            </span></button> <!----> <!----> <!----></div></div> <div class="article-label-part"><span><a href="/search?keyword=sob" target="_blank">
              sob
            </a></span><span><a href="/search?keyword=Android" target="_blank">
              Android
            </a></span><span><a href="/search?keyword=博客系统" target="_blank">
              博客系统
            </a></span><span><a href="/search?keyword=断点" target="_blank">
              断点
            </a></span></div></div> <!----> <div class="article-content-container" style=""><div id="article-content" class="article-content"><h2 id="heading-0">背景</h2>
<p>康师傅公布了站内api，提供大家开发APP，现在就来体验下是否有bug。 api地址：https://www.sunofbeach.net/a/1403262826952323074</p>
<h3 id="heading-1">Android端实现</h3>
<p><img src="https://images.sunofbeaches.com/content/2021_06_13/853635192894521344.png" alt="图片描述"></p>
<p>Android studio 4x java 8 kotlin 1.4x retrofit 项目代码以kt为主</p>
<hr>
<p>经过我一顿操作之后，登录界面做好了</p>
<p><img src="https://images.sunofbeaches.com/content/2021_06_13/853647187731546112.png" alt="图片描述"></p>
<h2 id="heading-2">图片验证码显示</h2>
<p>图片接口已经给出</p>
<pre style="display: block;"><code class="language-java hljs">https:<span class="hljs-comment">//api.sunofbeach.net</span>
/uc/ut/captcha?code=随机数
/uc/user/login/{captcha}
{
    phoneNum: <span class="hljs-string">''</span>,
    password: <span class="hljs-string">'取md5'</span>
}
</code></pre>
<p>接口部分</p>
<pre style="display: block;"><code class="language-java hljs"><span class="hljs-class"><span class="hljs-keyword">interface</span> <span class="hljs-title">BlogService</span> </span>{

    <span class="hljs-comment">/**
     * 登录
     */</span>
    <span class="hljs-meta">@POST</span>(<span class="hljs-string">"/uc/user/login/{captcha}"</span>)
    <span class="hljs-function">suspend fun <span class="hljs-title">doLogin</span><span class="hljs-params">(
            @Path(<span class="hljs-string">"captcha"</span>)</span> verifyCode: String,
            @Body user: LoginBody): BaseResponse&lt;SobUser&gt;
}
</span></code></pre>
<p>网络请求处理</p>
<p>LoginViewModel</p>
<pre style="display: block;"><code class="language-java hljs">        viewModelScope.launch {
            request {
                doLogin(
                        verifyCode.get()!!,
                        LoginBody(userName.get(), AppMd5Utils.getMD5(password.get())))
            }
                    .onSucceed {
                        navigateAndDestroy(MainActivity::<span class="hljs-class"><span class="hljs-keyword">class</span>.<span class="hljs-title">java</span>)
                    }
                    .<span class="hljs-title">onFailure</span> </span>{
                        AppToast.toast(it)
                        getCaptchaCode()
                    }
        }
</code></pre>
<h3 id="heading-3">隐藏的cookie处理</h3>
<p>这里需要把验证码请求得到的cookie，放到登录接口中回传。需要额外处理。 为什么？</p>
<blockquote>
<p>验证码接口生成了一个l_c_i数据，通过验证码图片下放了，当点击登录的情况下会检查cookie中是否有刚刚生成的数据。 我们显示图片的时候，如果使用默认的glide实现，是无法拿到cookie的，需要配合okhttp配置cookieManager获取。 当请求图片之后，在cookieManager中拦截下来保存，登录接口调用的时候，把cookie信息带上去。</p>
</blockquote>
<p>我使用的glide图片加载框架</p>
<pre style="display: block;"><code class="language-java hljs"><span class="hljs-comment">//okHttp3 : https://github.com/square/okhttp</span>
implementation <span class="hljs-string">'com.squareup.okhttp3:okhttp:4.9.0'</span>
<span class="hljs-comment">//okHttp3LoggingInterceptor</span>
implementation <span class="hljs-string">'com.squareup.okhttp3:logging-interceptor:4.9.0'</span>
implementation  <span class="hljs-string">'com.github.bumptech.glide:glide:4.11.0'</span>
implementation   <span class="hljs-string">'com.github.bumptech.glide:compiler:4.11.0'</span>
都是必须的
</code></pre>
<p>新增一个glide配置类</p>
<pre style="display: block;"><code class="language-java hljs"><span class="hljs-meta">@GlideModule</span>
<span class="hljs-keyword">public</span> <span class="hljs-class"><span class="hljs-keyword">class</span> <span class="hljs-title">HttpGlideModule</span> <span class="hljs-keyword">extends</span> <span class="hljs-title">AppGlideModule</span> </span>{

    <span class="hljs-meta">@Override</span>
    <span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">registerComponents</span><span class="hljs-params">(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry)</span> </span>{
        <span class="hljs-comment">// 注意这里用我们刚才现有的Client实例传入即可</span>
        registry.replace(GlideUrl<span class="hljs-class">.<span class="hljs-keyword">class</span>, <span class="hljs-title">InputStream</span>.<span class="hljs-title">class</span>, <span class="hljs-title">new</span> <span class="hljs-title">OkHttpUrlLoader</span>.<span class="hljs-title">Factory</span>(<span class="hljs-title">ApiKt</span>.<span class="hljs-title">getOkHttpClient</span>()))</span>;
    }
}
</code></pre>
<p>提供的okhttp client</p>
<pre style="display: block;"><code class="language-java hljs">
<span class="hljs-function">fun <span class="hljs-title">getOkHttpClient</span><span class="hljs-params">()</span>: OkHttpClient </span>{
    val builder: OkHttpClient.Builder = OkHttpClient.Builder()
            .cookieJar(cookieJar)
            .readTimeout(<span class="hljs-number">60</span>, TimeUnit.SECONDS) <span class="hljs-comment">//设置读取超时时间</span>
            .writeTimeout(<span class="hljs-number">60</span>, TimeUnit.SECONDS) <span class="hljs-comment">//设置写的超时时间</span>
            .connectTimeout(<span class="hljs-number">60</span>, TimeUnit.SECONDS)
    <span class="hljs-keyword">if</span> (BuildConfig.DEBUG) {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        builder.addInterceptor(httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        })
    }
    val client = builder.build()
    <span class="hljs-keyword">return</span> client
}

val cookieJar by lazy {
    CookiesManager()
}

</code></pre>
<p>cookie的管理类</p>
<pre style="display: block;"><code class="language-java hljs"><span class="hljs-class"><span class="hljs-keyword">class</span> <span class="hljs-title">CookiesManager</span> : <span class="hljs-title">CookieJar</span> </span>{
    <span class="hljs-keyword">private</span> val cookieStoreBlog = HashMap&lt;String, List&lt;Cookie&gt;&gt;()

    <span class="hljs-function">override fun <span class="hljs-title">saveFromResponse</span><span class="hljs-params">(httpUrl: HttpUrl, list: List&lt;Cookie&gt;)</span> </span>{
        LL.d(<span class="hljs-string">"Response httpUrl:httpUrl"</span>)
        <span class="hljs-keyword">if</span> (BuildConfig.UNION_BASE_URL.contains(httpUrl.host)) {
            LL.d(<span class="hljs-string">"保存sob的数据"</span>)
            cookieStoreBlog.put(BuildConfig.UNION_BASE_URL, list)
        }
    }

    <span class="hljs-function">override fun <span class="hljs-title">loadForRequest</span><span class="hljs-params">(httpUrl: HttpUrl)</span>: List&lt;Cookie&gt; </span>{

        val list = ArrayList&lt;Cookie&gt;()
        val sob = cookieStoreBlog.get(BuildConfig.UNION_BASE_URL);
        sob?.apply {
            LL.e(<span class="hljs-string">"返回sob的cookie"</span>, sob.toString())
            <span class="hljs-keyword">return</span> <span class="hljs-keyword">this</span>
        }
        <span class="hljs-keyword">return</span> list
    }
}
</code></pre>
<p>需要的配置都完成了。到此登录接口完成。 登录最重要是验证码携带cookie，在登录接口中需要回传。其他的逻辑处理就和普通的差不多了。</p>
<p>最后上全部代码</p>
<p>act</p>
<pre style="display: block;"><code class="language-java hljs">
<span class="hljs-class"><span class="hljs-keyword">class</span> <span class="hljs-title">LoginActivity</span> : <span class="hljs-title">BaseActivity</span>&lt;<span class="hljs-title">ActivityLoginBinding</span>, <span class="hljs-title">LoginViewModel</span>&gt;() </span>{

    <span class="hljs-keyword">private</span> lateinit <span class="hljs-keyword">var</span> shake: <span class="hljs-function">Animation

    override fun <span class="hljs-title">getLayoutId</span><span class="hljs-params">()</span> </span>= R.layout.<span class="hljs-function">activity_login

    override fun <span class="hljs-title">initView</span><span class="hljs-params">()</span> </span>{
        shake = AnimationUtils.loadAnimation(<span class="hljs-keyword">this</span>, R.anim.ani_shake)
        <span class="hljs-comment">//ImageHelper.load(vb.ivVerifyCode, getVerifyUrl())</span>
        vb.btnLogin.singleClick {
            viewModel.login()
        }
        <span class="hljs-comment">//navActivity&lt;JpBlogActivity&gt;()</span>
        vb.ivVerifyCode.singleClick {
            viewModel.getCaptchaCode()
        }
    }


    <span class="hljs-function">override fun <span class="hljs-title">initData</span><span class="hljs-params">(savedInstanceState: Bundle?)</span> </span>{
        viewModel.getCaptchaCode()
    }

    <span class="hljs-function">override fun <span class="hljs-title">getVariableId</span><span class="hljs-params">()</span>: Int </span>{
        <span class="hljs-keyword">return</span> BR.loginVm
    }

    <span class="hljs-function">override fun <span class="hljs-title">startObserve</span><span class="hljs-params">()</span> </span>{
        viewModel.liveDataCaptcha.observe(<span class="hljs-keyword">this</span>, {
            Glide.with(<span class="hljs-keyword">this</span><span class="hljs-meta">@LoginActivity</span>)
                    .load(it)
                    .skipMemoryCache(<span class="hljs-keyword">true</span>)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(vb.ivVerifyCode)
        })

        viewModel.shakeAnim.observe(<span class="hljs-keyword">this</span>, {
            showAnimShake(it)
        })
    }

    <span class="hljs-function"><span class="hljs-keyword">private</span> fun <span class="hljs-title">showAnimShake</span><span class="hljs-params">(view: Int)</span> </span>{
        when (view) {
            <span class="hljs-number">1</span> -&gt; {
                vb.etUser.startAnimation(shake)
            }
            <span class="hljs-number">2</span> -&gt; {
                vb.etPwd.startAnimation(shake)
            }
            <span class="hljs-number">3</span> -&gt; {
                vb.etCode.startAnimation(shake)
            }
        }
    }

    <span class="hljs-function">override fun <span class="hljs-title">onStop</span><span class="hljs-params">()</span> </span>{
        <span class="hljs-keyword">super</span>.onStop()
        vb.etCode.animation?.cancel()
        vb.etPwd.animation?.cancel()
        vb.etUser.animation?.cancel()
    }
}
</code></pre>
<p>vm</p>
<pre style="display: block;"><code class="language-java hljs"><span class="hljs-class"><span class="hljs-keyword">class</span> <span class="hljs-title">LoginViewModel</span> : <span class="hljs-title">BaseViewModel</span>() </span>{

    val shakeAnim = MutableLiveData&lt;Int&gt;()

    val userName = ObservableField&lt;String&gt;().apply { set(<span class="hljs-string">""</span>) }
    val password = ObservableField&lt;String&gt;().apply { set(<span class="hljs-string">""</span>) }
    val verifyCode = ObservableField&lt;String&gt;().apply { set(<span class="hljs-string">""</span>) }

    val liveDataCaptcha = MutableLiveData&lt;String&gt;()

    <span class="hljs-function">fun <span class="hljs-title">login</span><span class="hljs-params">()</span> </span>{
        <span class="hljs-keyword">if</span> (userName.get()?.isEmpty() == <span class="hljs-keyword">true</span>) {
            AppToast.toast(<span class="hljs-string">"输入账户"</span>)
            shakeAnim.postValue(<span class="hljs-number">1</span>)
            <span class="hljs-keyword">return</span>
        }
        <span class="hljs-keyword">if</span> (password.get()?.isEmpty() == <span class="hljs-keyword">true</span>) {
            AppToast.toast(<span class="hljs-string">"输入密码"</span>)
            shakeAnim.postValue(<span class="hljs-number">2</span>)

            <span class="hljs-keyword">return</span>
        }
        <span class="hljs-keyword">if</span> (verifyCode.get()?.isEmpty() == <span class="hljs-keyword">true</span>) {
            AppToast.toast(<span class="hljs-string">"输入验证码"</span>)
            shakeAnim.postValue(<span class="hljs-number">3</span>)
            <span class="hljs-keyword">return</span>
        }
        viewModelScope.launch {
            request {
                doLogin(
                        verifyCode.get()!!,
                        LoginBody(userName.get(), AppMd5Utils.getMD5(password.get())))
            }
                    .onSucceed {
                        navigateAndDestroy(MainActivity::<span class="hljs-class"><span class="hljs-keyword">class</span>.<span class="hljs-title">java</span>)
                    }
                    .<span class="hljs-title">onFailure</span> </span>{
                        AppToast.toast(it)
                        getCaptchaCode()
                    }
        }
    }

    <span class="hljs-function">fun <span class="hljs-title">getCaptchaCode</span><span class="hljs-params">()</span> </span>{
        liveDataCaptcha.value = BuildConfig.UNION_BASE_URL + <span class="hljs-string">"/uc/ut/captcha?code="</span> + System.currentTimeMillis()
    }


}
</code></pre>
<p>MD5工具 AppMd5Utils</p>
<pre style="display: block;"><code class="language-java hljs"><span class="hljs-keyword">public</span> <span class="hljs-class"><span class="hljs-keyword">class</span> <span class="hljs-title">AppMd5Utils</span> </span>{
    <span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-title">AppMd5Utils</span><span class="hljs-params">()</span> </span>{
    }

    <span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">static</span> String <span class="hljs-title">getMD5</span><span class="hljs-params">(String var0)</span> </span>{
        Object var1 = <span class="hljs-keyword">null</span>;
        <span class="hljs-keyword">if</span> (var0 == <span class="hljs-keyword">null</span>) {
            <span class="hljs-keyword">return</span> <span class="hljs-keyword">null</span>;
        } <span class="hljs-keyword">else</span> {
            <span class="hljs-keyword">try</span> {
                <span class="hljs-keyword">byte</span>[] var2 = var0.getBytes();
                MessageDigest var3 = MessageDigest.getInstance(<span class="hljs-string">"MD5"</span>);
                var3.update(var2);
                <span class="hljs-keyword">return</span> ByteUtils.a(var3.digest());
            } <span class="hljs-keyword">catch</span> (Exception var4) {
                <span class="hljs-keyword">return</span> (String)var1;
            }
        }
    }

    <span class="hljs-keyword">public</span> <span class="hljs-keyword">static</span> <span class="hljs-keyword">byte</span>[] getMD5(<span class="hljs-keyword">byte</span>[] var0) {
        <span class="hljs-keyword">try</span> {
            MessageDigest var1 = MessageDigest.getInstance(<span class="hljs-string">"MD5"</span>);
            var1.update(var0);
            <span class="hljs-keyword">return</span> var1.digest();
        } <span class="hljs-keyword">catch</span> (Exception var2) {
            <span class="hljs-keyword">return</span> <span class="hljs-keyword">null</span>;
        }
    }

    <span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">static</span> String <span class="hljs-title">getMD5</span><span class="hljs-params">(File var0)</span> </span>{
        FileInputStream var1 = <span class="hljs-keyword">null</span>;

        Object var3;
        <span class="hljs-keyword">try</span> {
            MessageDigest var2 = <span class="hljs-keyword">null</span>;

            <span class="hljs-keyword">try</span> {
                var2 = MessageDigest.getInstance(<span class="hljs-string">"MD5"</span>);
            } <span class="hljs-keyword">catch</span> (NoSuchAlgorithmException var18) {
                var18.printStackTrace();
            }

            var1 = <span class="hljs-keyword">new</span> FileInputStream(var0);
            <span class="hljs-keyword">byte</span>[] var22 = <span class="hljs-keyword">new</span> <span class="hljs-keyword">byte</span>[<span class="hljs-number">8192</span>];

            <span class="hljs-keyword">int</span> var4;
            <span class="hljs-keyword">while</span>((var4 = var1.read(var22)) != -<span class="hljs-number">1</span>) {
                var2.update(var22, <span class="hljs-number">0</span>, var4);
            }

            String var5 = ByteUtils.a(var2.digest());
            <span class="hljs-keyword">return</span> var5;
        } <span class="hljs-keyword">catch</span> (FileNotFoundException var19) {
            var3 = <span class="hljs-keyword">null</span>;
            <span class="hljs-keyword">return</span> (String)var3;
        } <span class="hljs-keyword">catch</span> (IOException var20) {
            var3 = <span class="hljs-keyword">null</span>;
        } <span class="hljs-keyword">finally</span> {
            <span class="hljs-keyword">try</span> {
                <span class="hljs-keyword">if</span> (var1 != <span class="hljs-keyword">null</span>) {
                    var1.close();
                }
            } <span class="hljs-keyword">catch</span> (IOException var17) {
                var17.printStackTrace();
            }

        }

        <span class="hljs-keyword">return</span> (String)var3;
    }

    <span class="hljs-keyword">public</span> <span class="hljs-keyword">static</span> <span class="hljs-keyword">byte</span>[] getMD5(InputStream var0) {
        <span class="hljs-keyword">byte</span>[] var1 = <span class="hljs-keyword">null</span>;
        <span class="hljs-keyword">if</span> (var0 != <span class="hljs-keyword">null</span>) {
            <span class="hljs-keyword">try</span> {
                MessageDigest var2 = <span class="hljs-keyword">null</span>;
                var2 = MessageDigest.getInstance(<span class="hljs-string">"MD5"</span>);
                <span class="hljs-keyword">if</span> (var2 != <span class="hljs-keyword">null</span>) {
                    <span class="hljs-keyword">byte</span>[] var3 = <span class="hljs-keyword">new</span> <span class="hljs-keyword">byte</span>[<span class="hljs-number">8192</span>];

                    <span class="hljs-keyword">int</span> var4;
                    <span class="hljs-keyword">while</span>((var4 = var0.read(var3)) != -<span class="hljs-number">1</span>) {
                        var2.update(var3, <span class="hljs-number">0</span>, var4);
                    }

                    var1 = var2.digest();
                }
            } <span class="hljs-keyword">catch</span> (Throwable var5) {
                var1 = <span class="hljs-keyword">null</span>;
            }
        }

        <span class="hljs-keyword">return</span> var1;
    }
}


</code></pre>
<p>登录流程是正常登录的，如果遇到其他问题，来评论区讨论吧。</p>
</div> <div class="prise-qr-code"><div class="prise-tips">"如果对你有帮助，请我喝一杯牛奶可好"</div> <div class="qr-code"><div class="el-image"><img src="https://imgs.sunofbeaches.com/group1/M00/00/3C/rBsADV_x1NeAZeGcAAIi9k97IkU240.jpg" width="180" height="180" class="el-image__inner" style="object-fit: cover;"><!----></div></div></div> <div class="article-content-more"><div class="article-content-action"><button type="button" class="el-button el-button--default el-button--medium is-plain"><!----><!----><span><span class="iconfont iconiconfontdianzan11"></span> <span id="article-content-bottom-thumbup-count">9</span>人觉得牛逼
            </span></button> <button type="button" class="el-button el-button--default el-button--medium is-plain"><!----><!----><span><span class="el-icon-collection-tag"></span> 收藏
            </span></button> <button type="button" class="el-button article-prise-btn el-button--danger el-button--medium is-plain"><!----><!----><span>
              ${'$'} 打赏
            </span></button></div></div> <div class="article-prise-list-box"><div class="el-table el-table--fit el-table--enable-row-hover el-table--enable-row-transition" style="width: 100%;"><div class="hidden-columns"><div></div> <div></div> <div></div></div><div class="el-table__header-wrapper"><table cellspacing="0" cellpadding="0" border="0" class="el-table__header" style="width: 690px;"><colgroup><col name="el-table_1_column_1" width="230"><col name="el-table_1_column_2" width="230"><col name="el-table_1_column_3" width="230"><col name="gutter" width="0"></colgroup><thead class="has-gutter"><tr class=""><th colspan="1" rowspan="1" class="el-table_1_column_1     is-leaf"><div class="cell">打赏人</div></th><th colspan="1" rowspan="1" class="el-table_1_column_2     is-leaf"><div class="cell">Sunof币</div></th><th colspan="1" rowspan="1" class="el-table_1_column_3     is-leaf"><div class="cell">时间</div></th><th class="gutter" style="width: 0px; display: none;"></th></tr></thead></table></div><div class="el-table__body-wrapper is-scrolling-none"><table cellspacing="0" cellpadding="0" border="0" class="el-table__body" style="width: 690px;"><colgroup><col name="el-table_1_column_1" width="230"><col name="el-table_1_column_2" width="230"><col name="el-table_1_column_3" width="230"></colgroup><tbody><tr class="el-table__row"><td rowspan="1" colspan="1" class="el-table_1_column_1  "><div class="cell"><div class="prise-user-info clear-fix"><a href="/u/1347474750661849088" target="_blank"><div class="prise-user-avatar float-left"><img src="https://imgs.sunofbeaches.com/group1/M00/00/40/rBsADWAYITCAJpK1AABZPRa3kCo649.png"></div> <div class="prise-user-name float-left">bugdr</div></a></div></div></td><td rowspan="1" colspan="1" class="el-table_1_column_2  "><div class="cell"><span style="color: rgb(255, 69, 0);">16</span></div></td><td rowspan="1" colspan="1" class="el-table_1_column_3  "><div class="cell"><span>2021-06-16 20:24</span></div></td></tr><tr class="el-table__row"><td rowspan="1" colspan="1" class="el-table_1_column_1  "><div class="cell"><div class="prise-user-info clear-fix"><a href="/u/1274165387499433984" target="_blank"><div class="prise-user-avatar float-left"><img src="https://imgs.sunofbeaches.com/group1/M00/00/2A/rBsADV80qt6ASPajAABRTM8wiqs313.png"></div> <div class="prise-user-name float-left">ncayu618</div></a></div></div></td><td rowspan="1" colspan="1" class="el-table_1_column_2  "><div class="cell"><span style="color: rgb(255, 69, 0);">16</span></div></td><td rowspan="1" colspan="1" class="el-table_1_column_3  "><div class="cell"><span>2021-06-14 10:06</span></div></td></tr><tr class="el-table__row"><td rowspan="1" colspan="1" class="el-table_1_column_1  "><div class="cell"><div class="prise-user-info clear-fix"><a href="/u/1153952789488054272" target="_blank"><div class="prise-user-avatar float-left"><img src="https://imgs.sunofbeaches.com/group1/M00/00/07/rBsADV22ZymAV8BwAABVL9XtNSU926.png"></div> <div class="prise-user-name float-left">拉大锯</div></a></div></div></td><td rowspan="1" colspan="1" class="el-table_1_column_2  "><div class="cell"><span style="color: rgb(255, 69, 0);">16</span></div></td><td rowspan="1" colspan="1" class="el-table_1_column_3  "><div class="cell"><span>2021-06-14 09:55</span></div></td></tr><tr class="el-table__row"><td rowspan="1" colspan="1" class="el-table_1_column_1  "><div class="cell"><div class="prise-user-info clear-fix"><a href="/u/1256120724666454016" target="_blank"><div class="prise-user-avatar float-left"><img src="https://imgs.sunofbeaches.com/group1/M00/00/24/rBsADV8EOPeAWEoCAAA-P-JPI7o280.png"></div> <div class="prise-user-name float-left">宿夜星辰叹</div></a></div></div></td><td rowspan="1" colspan="1" class="el-table_1_column_2  "><div class="cell"><span style="color: rgb(255, 69, 0);">16</span></div></td><td rowspan="1" colspan="1" class="el-table_1_column_3  "><div class="cell"><span>2021-06-14 09:16</span></div></td></tr><tr class="el-table__row"><td rowspan="1" colspan="1" class="el-table_1_column_1  "><div class="cell"><div class="prise-user-info clear-fix"><a href="/u/1284274686481473536" target="_blank"><div class="prise-user-avatar float-left"><img src="https://images.sunofbeaches.com/content/2021_06_18/855509704015609856.png"></div> <div class="prise-user-name float-left">YanLQ</div></a></div></div></td><td rowspan="1" colspan="1" class="el-table_1_column_2  "><div class="cell"><span style="color: rgb(255, 69, 0);">32</span></div></td><td rowspan="1" colspan="1" class="el-table_1_column_3  "><div class="cell"><span>2021-06-13 17:31</span></div></td></tr><!----></tbody></table><!----><!----></div><!----><!----><!----><!----><div class="el-table__column-resize-proxy" style="display: none;"></div></div></div></div></div>
        """
    }
}