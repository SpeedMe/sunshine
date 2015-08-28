(function(){
	var topic = {
		_param:{},
		_init: function(){
			this._event();
			this._pageLoad();
		},
		_event: function(){
			//绑定话题
			$('.content').on('click','.topic-info',function(e){
				var target = $(e.target);
				if(!target.hasClass('topic-info'))
					target = target.closest('.topic-info');
				var tid = target.attr('data-topic');
				location.href = '/shine/topic-detail.html?channelId='+topic._param+'&topicId='+tid;
			});
		},		
		_pageLoad : function(){
			var loc = topic._param;
			loc.href = location.href;
			var sp = loc.href.lastIndexOf('=');
			loc.channelId = loc.href.substring(sp+1);

			$.get('/shine/sunTopic/getTopicsByChannelIdOrderByTemp/'+loc.channelId,function(data){
				loc.topics = JSON.parse(data);
				if(loc.topics.meta.code === 200){
					var locdata = loc.topics.data,
						target = $('.content');
					target.children().remove();
					for(var idx in locdata){
					 	var html = '<div class="topic-info" data-topic="'+locdata.topicId+'">'
						        +'    <p class="writer-info">'
						        +'        <span class="writer-name">来自匿名</span>'
						        +'        <img src="http://placehold.it/25x25" alt="">'
						        +'        <span class="temperature-small fr">'+locdata[idx].topicTemp+'&#176;</span>'
						        +'    </p>'
						        +'    <p class="content-detail">'
						        +locdata[idx].topicContent
						        +'    </p>'
						        +'    <div class="hot-answer" style="display:none" >'
						        +'        <div class="fl answer-user">'
						        +'            <p class="temperature-small">0&#176;</p>'
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
				loc.user = JSON.parse(data);
				if(loc.user.meta.code === 200){
					var locdata = loc.user.data;
					target.find('.writer-name').text("来自"+locdata.nickname);
					target.find('.writer-info').attr('src',locdata.avatarPath);
				}
			});
		},
		_loadTopicAnswer : function(tid, target){
			var loc = topic._param;
			$.get('/shine/sunAnswer/queryMaxTempAnswerByTopicId/'+tid,function(data){
				loc.answer = JSON.parse(data);
				if(loc.answer.meta.code === 200){
					var locdata = loc.answer.data;
					target.find('.hot-answer .temperature-small').text(locdata.topicAnswerTemp+"&#176;");
					target.find('.hot-answer .topic-answer p').text(locdata.topicAnswerContent);
				}
			});
		},
		_loginState : function(){
			$.get('/shine/sunUser/loginState',function(data){
				var loc = topic._param;
				loc.login = JSON.parse(data);
				if(loc.login.meta.message === "已登录"){
					$('.bottom-btn').eq(0).removeClass('no-login');
					$('.bottom-btn').eq(1).addClass('no-login');
					$('nav').eq(1).find('a').attr('href','/shine/rssue.html?channelId='+topic._param.channelId+'&userId='+loc.login.data.userId);
				}else{
					$('.bottom-btn').eq(1).removeClass('no-login');
					$('.bottom-btn').eq(0).addClass('no-login');
				}
			});
		}
	}
	topic._init();
})();