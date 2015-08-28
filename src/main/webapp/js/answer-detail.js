(function(){
	var answer = {
		_param:{},
		_init: function(){
			this._event();
			this._pageLoad();
		},
		_event: function(){
			//绑定返回
			$('.turn-back').on('click',function(e){
				location.href = '/shine/topic-detail.html?channelId='+this._param.channelId+ '&topicId='+this._param.topicId;
				return false
			});
			//绑定私聊
			$('.bottom-btn .chat').on('click',function(e){
				var loc = topic._param;
				location.href = '/shine/chat.html?sendUserId='+loc.userId+'&receiveUserId='+loc.answer.data.userId;
			});
			//绑定感谢
			$('.bottom-btn .thanks').on('click',function(e){
				var loc = topic._param;
				$.post('/shine/sunAnswer/thankAnswer',{userId:loc.userId,topicAnswerId:loc.answer.data.topicAnswerId},function(e){
					console.log(data);
				});
			});
		},
		_pageLoad : function(){
			var loc = topic._param;
			loc.href = location.href;
			var sp = loc.href.lastIndexOf('answerId=');
			loc.answerId = loc.href.substring(sp+1);
			var tsp = loc.href.lastIndexOf('userId='),
				mid = loc.href.lastIndexOf('&');
			loc.userId = loc.href.substring(tsp+1,mid);
			var tsp = loc.href.lastIndexOf('topicId='),
				mid = loc.href.lastIndexOf('&');
			loc.topicId = loc.href.substring(tsp+1,mid);
			var tsp = loc.href.lastIndexOf('channelId='),
				mid = loc.href.lastIndexOf('&');
			loc.channelId = loc.href.substring(tsp+1,mid);
			$.get('/shine/sunAnswer/getAnswerById'+loc.answerId,function(e){
				loc.answer = JSON.parse(data);
				if(loc.answer.meta.code === 200){
					var locdata = loc.answer.data;
					$('.content .temperature-small').text(locdata.topicAnswerTemp+"&#176;");
					$('.content .answer-detail').text(locdata.topicAnswerContent);
					$('.answer-time').text(locdata.topicAnswerTime);
					answer._loadWriter(locdata.userId);
				}
			});
		},
		_loadWriter : function(uid){
			var loc = topic._param;
			$.get('/shine/sunUser/user/'+uid,function(data){
				loc.writeUser = JSON.parse(data);
				if(loc.writeUser.meta.code === 200){
					var locdata = loc.writeUser.data;
					$('.writer-name').text(locdata.nickname);
					$('.writer-img').attr('src',locdata.avatarPath);
				}
			});
		};
	}
})();