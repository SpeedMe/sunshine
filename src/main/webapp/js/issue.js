(function(){
    $('.topic-header .btn-nav').click(function(e){
        location.href = document.referrer;
    });
	$(".check").click(function(){
        $(".check").find('.icon').toggleClass("icon-check");
    });
    $(".issue-btn").click(function(){
        var content = $(".issue-content").find("textarea").val(); 
        if(content){
            var isAnonymity = 0;
            var start = location.href.indexOf("=");
            var start2 = location.href.lastIndexOf("=");
            var end = location.href.indexOf("&");
            var channelId = location.href.substring(start+1, end);
            var userId = location.href.substring(start2+1);
            if($(".check").find('.icon-check').length){
                isAnonymity = 1;
            }
            var data = {
                userId: userId,
                channelId: channelId,
                isAnonymity: isAnonymity,
                topicContent: content
            };
            $.ajax({
                type: 'POST',
                url: '/shine/sunTopic/issueTopic',
                data: data,
                dataType: 'json',
                 success: function (json) {
                    if (json.meta.code == 200) {
                        alert("发布成功");
                        location.href = document.referrer;
                    }
                     else {
                        alert(json.meta.message);
                     }
                },
                error: function (err) {
                    console.log(err);
                }
            });
        }else{
            alert("请填写内容后再发布");
        }
    })
})();