(function(){
    var startsend = location.href.indexOf("=");
    var startreceive = location.href.lastIndexOf("=");
    var end = location.href.indexOf("&");
    var sendUserId = location.href.substring(startsend+1, end);
    var receiveUserId = location.href.substring(startreceive+1);
    $.ajax({
            type: 'GET',
            url: '/shine/sunUser/user/'+receiveUserId,
            dataType: 'json',
             success: function (json) {
                if (json.meta.code == 200) {
                    $(".send-to").html(json.data.nickname)
                }
                 else {
                    console.log(json.meta.message);
                 }
            },
            error: function (err) {
                console.log(err);
            }
        });

    $(".send-item").click(function(){
        var content = $(".enter-input").val(); 
        if(content){
            var data = {
                sendUserId: sendUserId,
                receiveUserId: receiveUserId,
                chatContent: content
            };
            console.log(data);
            $.ajax({
                type: 'POST',
                url: '/shine/privateChat/sendPrivateChat',
                data: data,
                dataType: 'json',
                 success: function (json) {
                    if (json.meta.code == 200) {
                        alert("发送成功成功");
                        location.href = document.referrer;
                    }
                     else {
                        console.log(json.meta.message);
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