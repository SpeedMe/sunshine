(function () {
    $(".J-login-btn").click(function () {
        var tar = $(this);
        var form = tar.closest('.login-form');
        if (!form.length) return;

        var data = {
            nickname: form.find('[name=nickname]').val(),
            password: form.find('[name=password]').val()
        };
        $.ajax({
            type: 'POST',
            url: '/shine/sunUser/login',
            data: data,
            dataType: 'json',
            success: function (json) {
                if (json.meta.code == 200) {
                   location.href = document.referrer;
                } else {
                    alert(json.meta.message);
                }
            },
            error: function (err) {
                console.log(err);
            }
        });
    });
    //显示错误提示
    function _showTip(target, msg) {
        alert(msg);
    };
    $("form").submit(function (e) {
        e.preventDefault();

    });
})();