(function(){
	var topic = {
		_param:{},
		_init: function(){
			topic._event();
			topic._loginState();
			topic._pageLoad();
		},
		_event: function(){
			//绑定话题
			$('.content').on('click','.topic-info',function(e){
				var target = $(e.target);
				if(topic._param.login.data) {
					if (!target.hasClass('topic-info'))
						target = target.closest('.topic-info');
					var tid = target.attr('data-topic');
					window.location.href = '/shine/sunTopic/getTopicByTopicId/' + tid;
				}else{
					window.location.href = '/login.html';
				}
			});
			//个人中心查看消息分类
			$(".check-information").on("click", ".table-view-cell", function(){
				var shortInfomation = $(this).find(".short-information");
				var longInfomation = $(this).find(".long-information");
				if(shortInfomation.length){
					shortInfomation.addClass("long-information");
					shortInfomation.removeClass("short-information");
				}else{
					longInfomation.addClass("short-information");
					longInfomation.removeClass("long-information");
				}
			});
			$(".center-btn").on("click",function(){
				$("#mySlider").addClass("show");
			});

			$('#mySlider').bind('swipeleft swipeleftup',function(){
				$("#mySlider").removeClass("show");
				return false;
			});
			$(".go-check-topic").click(function(){
				$("#check-topic").addClass("show");
			});
			$(".go-attention-topic").click(function(){
				$("#attention-topic").addClass("show");
			});
			$(".go-check-information").click(function(){
				$("#check-information").addClass("show");
			});
			$(".back-check-topic").click(function(){
				$("#check-topic").removeClass("show");
			});
			$(".back-attention-topic").click(function(){
				$("#attention-topic").removeClass("show");
			});
			$(".back-check-information").click(function(){
				$("#check-information").removeClass("show");
			});
		},
		_loginState : function(){
			$.get('/shine/sunUser/loginState',function(data){
				var loc = topic._param;
				loc.login = data;
				var stateName = data.data==null ? "未登录":data.data.nickname;
				//var stateName = data.data.nickname||"未登录";
				$(".p-name").html(stateName);
				if(stateName == "未登录"){
					$(".p-worlds").hide();
				}else{
					$(".p-worlds").show();
				}
				if(loc.login.meta.message === "已登录"){
					$('.bottom-btn').eq(1).removeClass('no-login');
					$('.bottom-btn').eq(0).addClass('no-login');
					$('nav').eq(1).find('a').attr('href','issue.html?channelId='+topic._param.channelId+'&userId='+loc.login.data.userId);
				}else{
					$('.bottom-btn').eq(0).removeClass('no-login');
					$('.bottom-btn').eq(1).addClass('no-login');
				}
			});
		}
	}
	$(document).ready(topic._init);
})();