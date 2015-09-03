(function () {
    var answer = {
        _param: {},
        _init: function () {
            //回复话题的用户
            var uid = $(".topic-header").attr("data-user-id");
            var aid = $(".topic-header").attr("data-answer-id");

            //当前登陆的用户
            var loginUser = JSON.parse(answer._loginState()).data;

            answer._hasFollowed(aid, loginUser);
            answer._event(uid, aid, loginUser);

        },
        _event: function (uid, aid, loginUser) {
            //绑定返回
            $('.turn-back').on('click', function (e) {
                history.go(-1);
            });
            //绑定私聊
            $('.bottom-btn .chat').on('click', function (data) {
                //var chatData = JSON.parse(answer._loginState());
                location.href = '/chat.html?sendUserId=' + loginUser.userId + '&receiveUserId=' + uid;
            });
            //绑定感谢
            $('.bottom-btn .thanks').on('click', function (e) {
                $.ajax({
                    type: "POST",
                    url: "/shine/sunAnswer/thankAnswer",
                    data: {userId: uid, topicAnswerId: aid},
                    success: function () {
                        $('.bottom-btn .thanks').off();
                        $('.bottom-btn .thanks').css('color', '#aaa');
                    }
                });
            });
        },
        _loginState: function () {
            //get函数是返回的数据其他函数接受不到因为异步原因，所以使用这种方式
            return $.ajax({
                type: "GET",
                url: "/shine/sunUser/loginState",
                async: false,
                cache: false,
                success: function () {
                }
            }).responseText;
        },
        _hasFollowed: function(aid, loginUser){
            $.ajax({
                type: "POST",
                url: "/shine/sunAnswer/hasThankedAnswer",
                data: {userId: loginUser.userId, topicAnswerId: aid},
                success: function(res){
                    if(res.data){
                        $('.bottom-btn .thanks').off();
                        $('.bottom-btn .thanks').css('color', '#aaa');
                    }
                }
            });
        }
    };
    $(document).ready(answer._init)
})();