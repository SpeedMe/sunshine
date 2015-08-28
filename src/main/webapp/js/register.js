(function(){
		$(".J-register-btn").click(function(){
			var tar = $(this);
            var form = tar.closest('.register-form');
            if(!form.length) return;
            if(_checkForm(form)){
                var data = {
					email: form.find('[name=email]').val(),
					nickname: form.find('[name=name]').val(),
					password:form.find('[name=password]').val()
                };
                $.ajax({
                    type: 'POST',
                    url: 'http://192.168.201.200/shine/sunUser/register',
                    data: data,
                    dataType: 'json',
                    success: function(json){
                        if (json.state == 202) {
                        	alert("注册成功");
                        	window.location.href="login.html"; 
                        }
                    },
                    error: function(err) {
                    	console.log(err);
                    }
                });
            }
		});
		//输入框验证
		function _checkForm(form){
			var email = form.find('[name=email]');
            var name = form.find('[name=name]'); 
            var password = form.find('[name=password]');
            var emailReg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
            var nameReg = /^[0-9a-zA-Z\u4E00-\u9FA5]{2,10}$/;
            var passwordReg = /(?!^\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{8,}/;
            
            var temp = true;
        
            if(!email.val()){
                temp = false;
                _showTip(email,'请填写邮箱');   
            }else if(!emailReg.test(email.val())){
                temp = false;
                _showTip(email,'邮箱格式不正确');
            }else if(!name.val()){
                temp = false;
                _showTip(name,'请填写用户名');
            } else if(!nameReg.test(name.val())){
                temp = false;
                _showTip(name,'用户名只能为2-10中文、英文、数字');
            }else if(!password.val()){
                temp = false;
                _showTip(password,'请填写您的密码');
            }else if(!passwordReg.test(password.val())){
                temp = false;
                _showTip(password,'密码格式错误');
            }
            return temp;
        };
        //显示错误提示
         function _showTip(target, msg){
         	alert(msg);
        };
        $("form").submit(function(e){
		    e.preventDefault();
		    
		  });
})();