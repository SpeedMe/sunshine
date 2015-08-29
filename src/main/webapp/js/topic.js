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
					window.location.href = 'topic-detail.html?channelId=' + topic._param.channelId + '&topicId=' + tid;
				}else{
					window.location.href = 'login.html';
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
		_pageLoad : function(){
			var loc = topic._param;
			loc.href = location.href;
			var sp = loc.href.lastIndexOf('=');
			loc.channelId = loc.href.substring(sp+1);
			var arr = ['宝贝回家','月亮孩子','灾后重生'];
			$('.title').text(arr[loc.channelId-1]);
			$.get('/shine/sunTopic/getTopicsByChannelIdOrderByTemp/'+loc.channelId,function(data){
				loc.topics = data;
				if(loc.topics.meta.code === 200){
					var locdata = loc.topics.data,
						target = $('.content');
					target.children().remove();
					for(var idx in locdata){
					 	var html = '<div class="topic-info" data-topic="'+locdata[idx].topicId+'">'
						        +'    <p class="writer-info">'
						        +'        <span class="writer-name">来自匿名</span>'
						        +'        <img src="img/person.png" alt="">'
						        +'        <span class="temperature-small fr">'+locdata[idx].topicTemp+'° </span>'
						        +'    </p>'
						        +'    <p class="content-detail">'
						        +locdata[idx].topicContent
						        +'    </p>'
						        +'    <div class="hot-answer" style="display:none" >'
						        +'        <div class="fl answer-user">'
						        +'            <p class="temperature-small">0° </p>'
						        +'        </div>'
						        +'        <div class="topic-answer">'
						        +'            <p></p>'
						        +'        </div>'
						        +'    </div>'
						        +'</div>';
						var $tar = $(html);
						target.append($tar);
						topic._loadTopicAnswer(locdata[idx].topicId,$tar);
						if(!locdata[idx].isAnonymity){
							topic._loadUserDetail( locdata[idx].userId,$tar);
						}
					}
				}
			});
		},
		_loadUserDetail : function(uid, target){
			var loc = topic._param;
			$.get('/shine/sunUser/user/'+uid,function(data){
				loc.user = data;
				if(loc.user.meta.code === 200&&loc.answer.data){
					var locdata = loc.user.data;
					target.find('.writer-name').text("来自"+locdata.nickname);
					target.find('.writer-info').attr('src',locdata.avatarPath);

				}
			});
		},
		_loadTopicAnswer : function(tid, target){
			var loc = topic._param;
			$.get('/shine/sunAnswer/queryMaxTempAnswerByTopicId/'+tid,function(data){
				loc.answer = data;
				if(loc.answer.meta.code === 200 &&loc.answer.data){
					var locdata = loc.answer.data;
					target.find('.hot-answer .temperature-small').text(locdata.topicAnswerTemp+"° ");
					target.find('.hot-answer .topic-answer p').text(locdata.topicAnswerContent);
					target.find('.hot-answer').css('display','block');
				}
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