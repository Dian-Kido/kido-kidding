<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="section-title">
                    <#if springMacroRequestContext.requestUri?contains("/author/pipi")>
                        <h2>一起喵喵喵~</h2>
                        <p>皮皮这么可爱，我们一起来揉它呀~<br></p>
                    <#elseif springMacroRequestContext.requestUri?contains("/author")>
                        <h2>留言</h2>
                        <p>谢谢你关注我微不足道的人生</br>你好，我叫<a class="internal-link" href='https://weibo.com/chendianshu'
                                                     onclick=clickRecord('点击微博')
                                                     target='_blank'>@泡面大厨</a>，请多指教~</p>
                    <#elseif springMacroRequestContext.requestUri?contains("/book")>
                        <h2>以书会友</h2>
                        <p>如果你也喜欢阅读，一起交流吧<br></p>
                    <#else>
                        <h2>吐槽框</h2>
                        <p>If you have some Questions or need Help! Please Contact Me!<br></p>
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
                                <textarea class="form-control" placeholder="Your Message *" id="mesContent" required=""
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