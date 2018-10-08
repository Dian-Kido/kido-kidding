<section id="contact">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="section-title">
                    <h2>Contact Me</h2>
                    <p>If you have some Questions or need Help! Please Contact Me!<br></p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12 text-center">
                <form name="sentMessage" id="contactForm" novalidate="">
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
                            <button onclick="sendMsg()" class="btn">Send Message</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>