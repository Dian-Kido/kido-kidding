<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="section-title">
                    <#if springMacroRequestContext.requestUri?contains("/author/pipi")>
                        <h2>一起喵喵喵~</h2>
                        <p>皮皮这么可爱，我们一起来揉它呀~</p>
                    <#elseif springMacroRequestContext.requestUri?contains("/author/about")>
                        <h2>知与谁同</h2>
                        <p>叹烟波渺渺，<a class="internal-link" href="javascript:void(0)"
                                    onclick=showKidoWx('${kidoWx}')>知音何处</a></p>
                    <#elseif springMacroRequestContext.requestUri?contains("/author/emotion")>
                        <h2>如此良人何</h2>
                        <p>既见君子，云胡不喜</p>
                    <#elseif springMacroRequestContext.requestUri?contains("/author/wish")>
                        <h2>浮幻人间世</h2>
                        <p>你好，我叫<a class="internal-link" href="javascript:void(0)"
                                   onclick=showKidoWx('${kidoWx}')>泡面大厨</a>，请多指教~</p>
                    <#elseif springMacroRequestContext.requestUri?contains("/book")>
                        <h2>淡墨留香</h2>
                        <p>以书为伴，以文会友</p>
                    <#elseif springMacroRequestContext.requestUri?contains("/tab/show")>
                        <h2>留言框</h2>
                    <#else>
                        <h2>留言框</h2>
                        <#if mvBozhuLiuyan != "">
                            <p>${mvBozhuLiuyan}</p>
                        <#--                            <p>你喜欢电影吗，<a class="internal-link" href="javascript:void(0)" onclick="showTopMoivesWxq('https://kido-1257686190.cos.ap-beijing.myqcloud.com/wx_erweima/top_movies_wxq/top_movies_wxq-20200530-2.png')">加入爱电影的小伙伴呀~</a></p>-->
                        <#else>
                            <p>你喜欢电影吗？那我也喜欢~</p>
                        </#if>
                    </#if>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 text-center">
                <form name="sentMessage" id="" novalidate="">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="Your Name *" id="mesName"
                                       required=""
                                       data-validation-required-message="Please enter your name." name="mesName">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <input type="email" class="form-control" placeholder="Your Email *" id="mesEmail"
                                       required="" data-validation-required-message="Please enter your email address."
                                       name="mesEmail">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-12">
                            <div class="form-group">
                                <textarea class="form-control" placeholder="Your Message * (如果你希望博主回复，请填写准确的联系方式哈)"
                                          id="mesContent" required=""
                                          data-validation-required-message="Please enter a message."
                                          name="mesContent"></textarea>
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <div id="success"></div>
                            <div href="javascript:void(0);" onclick="sendMsg()" class="btn">Send Message</div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>