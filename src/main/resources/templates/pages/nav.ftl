<!-- Navigation -->
<nav class="navbar navbar-default navbar-custom navbar-fixed-top">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/">KIDO</a>
        </div>

        <div id="huxblog_navbar">
            <div class="navbar-collapse movie-bar-font">
                <ul class="nav navbar-nav navbar-right">


                    <li>
                        <a href="/movie/list/1/15">电影推荐</a>
                    </li>

                    <li>
                        <a href="https://blog.kido.site/">技术博客</a>
                    </li>

                    <li>
                        <a href="/tab/show">网站导航</a>
                    </li>

                    <li>
                        <a href="/author/about">不要点开</a>
                    </li>


                </ul>
            </div>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
<script>
    // Drop Bootstarp low-performance Navbar
    // Use customize navbar with high-quality material design animation
    // in high-perf jank-free CSS3 implementation
    var $body = document.body;
    var $toggle = document.querySelector('.navbar-toggle');
    var $navbar = document.querySelector('#huxblog_navbar');
    var $collapse = document.querySelector('.navbar-collapse');

    $toggle.addEventListener('click', handleMagic)

    function handleMagic(e) {
        if ($navbar.className.indexOf('in') > 0) {
            // CLOSE
            $navbar.className = " ";
            // wait until animation end.
            setTimeout(function () {
                // prevent frequently toggle
                if ($navbar.className.indexOf('in') < 0) {
                    $collapse.style.height = "0px"
                }
            }, 400)
        } else {
            // OPEN
            $collapse.style.height = "auto"
            $navbar.className += " in";
        }
    }
</script>