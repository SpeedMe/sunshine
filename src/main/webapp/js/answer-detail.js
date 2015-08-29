(function(){
	var answer = {
		_param:{},
		_init: function(){
			answer._event();
			answer._pageLoad();
		},
		_event: function(){
			//绑定返回
			$('.turn-back').on('click',function(e){
				history.go(-1);
			});
			//绑定私聊
			$('.bottom-btn .chat').on('click',function(data){
				var loc = answer._param;
				location.href = 'chat.html?sendUserId='+loc.userId+'&receiveUserId='+loc.answer.data.userId;
			});
			//绑定感谢
			$('.bottom-btn .thanks').on('click',function(e){
				var loc = answer._param;
				$.post('/shine/sunAnswer/thankAnswer',{userId:loc.userId,topicAnswerId:loc.answer.data.topicAnswerId},function(data){
					console.log(data);
					$('.bottom-btn .thanks').off();
					$('.bottom-btn .thanks').css('color','#aaa');
				});
			});
		},
		_pageLoad : function(){
			var loc = answer._param;
			loc.href = location.href;
			var sp = loc.href.lastIndexOf('answerId=');
			loc.answerId = loc.href.substring(sp+9);
			var tsp = loc.href.lastIndexOf('userId='),
				mid = loc.href.lastIndexOf('&');
			loc.userId = loc.href.substring(tsp+7,mid);
			var tsp = loc.href.lastIndexOf('topicId='),
				mid = loc.href.lastIndexOf('&userId');
			loc.topicId = loc.href.substring(tsp+8,mid);
			var tsp = loc.href.lastIndexOf('channelId='),
				mid = loc.href.lastIndexOf('&topicId');
			loc.channelId = loc.href.substring(tsp+10,mid);
			$.get('/shine/sunAnswer/getAnswerById/'+loc.answerId,function(data){
				loc.answer = data;
				if(loc.answer.meta.code === 200){
					var locdata = loc.answer.data;
					$('.content .temperature-small').text(locdata.topicAnswerTemp+"° ");
					$('.content .answer-detail').text(locdata.topicAnswerContent);
					$('.answer-time').text((new Date(locdata.topicAnswerTime)).toLocaleDateString());
					answer._loadWriter(locdata.userId);
				}
			});
		},
		_loadWriter : function(uid){
			var loc = answer._param;
			$.get('/shine/sunUser/user/'+uid,function(data){
				loc.writeUser = data;
				if(loc.writeUser.meta.code === 200){
					var locdata = loc.writeUser.data;
					$('.writer-name').text(locdata.nickname);
					$('.writer-img').attr('src',locdata.avatarPath);
				}
			});
		}
	};
	$(document).ready(answer._init)
})();