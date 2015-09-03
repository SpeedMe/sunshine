(function () {
    var answer = {
        _param: {},
        _init: function () {
            var uid = $(".topic-header").attr("data-user-id");
            var aid = $(".topic-header").attr("data-answer-id");
            answer._event(uid, aid);
        },
        _event: function (uid, aid) {
            //绑定返回
            $('.turn-back').on('click', function (e) {
                history.go(-1);
            });
            //绑定私聊
            $('.bottom-btn .chat').on('click', function (data) {
                var loc = answer._param;
                location.href = 'chat.html?sendUserId=' + loc.userId + '&receiveUserId=' + loc.answer.data.userId;
            });
            //绑定感谢
            $('.bottom-btn .thanks').on('click', function (e) {
                $.post('/shine/sunAnswer/thankAnswer', {userId: uid, topicAnswerId: aid}, function (data) {
                    $('.bottom-btn .thanks').off();
                    $('.bottom-btn .thanks').css('color', '#aaa');
                });
            });
        }
    };
    $(document).ready(answer._init)
})();