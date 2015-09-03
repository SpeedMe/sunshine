(function () {
    var topic = {
        _param: {},
        _init: function () {
            var uid = $(".writer-info").attr('data-user-id');
            var tid = $(".writer-info").attr('data-topic-id');
            var cid = $(".writer-info").attr('data-channle-id');
            topic._event(uid, tid, cid);
            topic._loginState(uid, tid);
            //topic._pageLoad();
        },
        _event: function (uid, tid, cid) {
            //绑定回答
            $('.answer').on('click', 'li', function (e) {
                var loc = topic._param,
                    target = $(e.target);
                if (e.target.tagName !== "LI") {
                    target = $(e.target).closest('li');
                }
                var answerId = target.attr('data-answerId');
                location.href = '/shine/sunAnswer/getAnswerById/' + answerId;

            });
            //绑定关注按钮
            $('.follow-btn').on('click', function (e) {
                var target = $(e.target);
                //if (e.target.tagName === 'SPAN')
                //    target = $(e.target).closest('button');
                if (target.hasClass('follow')) {
                    target.removeClass('follow');
                    target.addClass('followed');
                    target.text("取消关注");
                    target.append("<span></span>")
                    topic._topicFollow(true, uid, tid);
                } else {
                    target.removeClass('followed');
                    target.addClass('follow');
                    target.text("关注");
                    target.append("<span></span>")
                    topic._topicFollow(false, uid, tid);
                }
                return false
            });
            //回答按钮
            $('.answer-btn').on('click', function (e) {
                var loc = topic._param;
                location.href = '/answer-write.html?channelId=' + cid + '&topicId=' + tid + '&userId=' + uid;
                return false
            });
            //返回
            $('.turn-back').on('click', function (e) {
                history.go(-1);
            });
        },
        _topicFollow: function (flag, uid, tid) {
            var url = flag ? '/shine/sunTopic/followTopic' : '/shine/sunTopic/unfollowTopic';
            $.post(url, {userId: uid, topicId: tid}, function (data) {
                console.log(data);
            });
        },
        _loginState: function (uid, tid) {
            $.get('/shine/sunUser/loginState', function (data) {
                var loc = topic._param;
                loc.login = data;
                $.ajax({
                    type: 'GET',
                    url: '/shine/sunTopic/hasFollowedTopic',
                    data: {userId: uid, topicId: tid},
                    dataType: 'json',
                    success: function (re) {
                        loc.followed = re;
                        console.info("re" + loc.followed.meta.code);
                        if (loc.followed.meta.code === 200) {
                            var locdata = loc.followed.data;
                            console.info(locdata);
                            if (locdata) {
                                $('.follow-btn').removeClass('follow');
                                $('.follow-btn').addClass('followed');
                                $('.follow-btn').text("取消关注");
                                $('.follow-btn').append("<span></span>")
                            } else {
                                $('.follow-btn').removeClass('followed');
                                $('.follow-btn').addClass('follow');
                                $('.follow-btn').text("关注");
                                $('.follow-btn').append("<span></span>")
                            }
                        }
                    }
                });
            });
        }
    }
    $(document).ready(topic._init);
})();