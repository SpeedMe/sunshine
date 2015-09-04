(function () {
    var topic = {
        _param: {},
        _init: function () {
            //当前登陆的用户
            var loginUser = JSON.parse(topic._getLoginUser()).data;

            topic._event(loginUser);
            topic._loginState();
        },
        _event: function (loginUser) {
            //绑定话题
            $('.content').on('click', '.topic-info', function (e) {
                var target = $(e.target);
                if (topic._param.login.data) {
                    if (!target.hasClass('topic-info'))
                        target = target.closest('.topic-info');
                    var tid = target.attr('data-topic');
                    window.location.href = '/shine/sunTopic/getTopicByTopicId/' + tid;
                } else {
                    window.location.href = '/login.html';
                }
            });
            //个人中心查看消息分类
            $(".check-information").on("click", ".table-view-cell", function () {
                var shortInfomation = $(this).find(".short-information");
                var longInfomation = $(this).find(".long-information");
                if (shortInfomation.length) {
                    shortInfomation.addClass("long-information");
                    shortInfomation.removeClass("short-information");
                } else {
                    longInfomation.addClass("short-information");
                    longInfomation.removeClass("long-information");
                }
            });
            $(".center-btn").on("click", function () {
                $("#mySlider").addClass("show");
            });

            $('#mySlider').bind('swipeleft swipeleftup', function () {
                $("#mySlider").removeClass("show");
                return false;
            });
            //得到所有发布的话题
            $(".go-check-topic").click(function () {
                $.ajax({
                    type: "GET",
                    url: "/shine/sunTopic/getIssueTopicsByUserId/" + loginUser.userId,
                    success: function (res) {
                        var issueTopics = res.data;
                        $("#check-topic").addClass("show");

                        for (var i = 0; i < issueTopics.length; i++) {

                            $("#check-topic").append("<li class=" + "'table-view-cell media'" + "onclick = getTopicByTopicId(" + issueTopics[i].topicId + ")>"
                            + "<a>"
                            + "<div class=" + "'issue-topic'" + ">"
                            + "<p>" + issueTopics[i].topicContent + "</p>"
                            + "<p>"
                            + "<span>" + issueTopics[i].followPeopleNum + "人关注" + "</span>"
                            + "<span>" + issueTopics[i].answerNum + "个回答" + "</span>"
                            + "</p>"
                            + "</div>"
                            + "</a>"
                            + "</li>")
                        }
                    }
                });
            });
            //得到关注的所有话题
            $(".go-attention-topic").click(function () {
                $.ajax({
                    type: "GET",
                    url: "/shine/sunTopic/getFollowedTopicsByUserId/" + loginUser.userId,
                    success: function (res) {
                        var followedTopics = res.data;
                        $("#attention-topic").addClass("show");

                        for (var i = 0; i < followedTopics.length; i++) {

                            $("#attention-topic").append("<li class=" + "'table-view-cell media'" + "onclick = getTopicByTopicId(" + followedTopics[i].topicId + ")>"
                            + "<a>"
                            + "<div class=" + "'attention-topic'" + ">"
                            + "<p>" + followedTopics[i].topicContent + "</p>"
                            + "<p>"
                            + "<span>" + followedTopics[i].followPeopleNum + "人关注" + "</span>"
                            + "<span>" + followedTopics[i].answerNum + "个回答" + "</span>"
                            + "</p>"
                            + "</div>"
                            + "</a>"
                            + "</li>")
                        }
                    }
                });
            });
            //私聊消息
            $(".go-check-information").click(function () {
                $("#check-information").addClass("show");

                $.ajax({
                    type: "GET",
                    url: "/shine/sunTopic/getTopicsByUserId/" + loginUser.userId,
                    success: function (res) {
                        console.info(res);
                    }
                });
            });
            $(".back-check-topic").click(function () {
                $("#check-topic").removeClass("show");
            });
            $(".back-attention-topic").click(function () {
                $("#attention-topic").removeClass("show");
            });
            $(".back-check-information").click(function () {
                $("#check-information").removeClass("show");
            });


        },


        _loginState: function () {
            $.get('/shine/sunUser/loginState', function (data) {
                var loc = topic._param;
                loc.login = data;
                var stateName = data.data == null ? "未登录" : data.data.nickname;
                //var stateName = data.data.nickname||"未登录";
                $(".p-name").html(stateName);
                if (stateName == "未登录") {
                    $(".p-worlds").hide();
                } else {
                    $(".p-worlds").show();
                }
                if (loc.login.meta.message === "已登录") {
                    $('.bottom-btn').eq(1).removeClass('no-login');
                    $('.bottom-btn').eq(0).addClass('no-login');
                    $('nav').eq(1).find('a').attr('href', 'issue.html?channelId=' + topic._param.channelId + '&userId=' + loc.login.data.userId);
                } else {
                    $('.bottom-btn').eq(0).removeClass('no-login');
                    $('.bottom-btn').eq(1).addClass('no-login');
                }
            });
        },
        _getLoginUser: function () {
            //get函数是返回的数据其他函数接受不到因为异步原因，所以使用这种方式
            return $.ajax({
                type: "GET",
                url: "/shine/sunUser/loginState",
                async: false,
                cache: false,
                success: function () {
                }
            }).responseText;
        }

    }
    $(document).ready(topic._init);

})();

//进入单个话题内容
function getTopicByTopicId(topicId) {
    window.location.href = "/shine/sunTopic/getTopicByTopicId/" + topicId;
}

