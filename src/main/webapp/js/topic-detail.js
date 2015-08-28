(function(){
	var topic = {
		_param:{},
		_init: function(){
			this._event();
			this._loginState();
			this._pageLoad();
		},
		_event: function(){
			//绑定回答
			$('.answer').on('click','li',function(e){
				if(loc.writeUser){
					var answerId = $(e.target).attr('data-answerId');
					location.href = '/shine/answerDetail.html?channelId='+loc.channelId+'&topicId='+loc.topicId+'&userId='loc.writeUser.data.userId+'&answerId='+answerId;
				}else{
					location.href = '/shine/login.html';
				}
			});
			//绑定关注按钮
			$('.follow-btn').on('click',function(e)){				
				var target = $(e.target),
					loc = topic._param;
				if(loc.writeUser){
					if(e.target.tagName === 'SPAN')
						target = $(e.target).closest('button');
					if(target.hasClass('follow')){
						target.removeClass('follow');
						target.addClass('followed');
						target.text("取消关注");
						target.append("<span></span>")
						this._topicFollow(true,loc.writeUser.data.userId,loc.topicId);
					}else{
						target.removeClass('followed');
						target.addClass('follow');
						target.text("关注");
						target.append("<span></span>")
						this._topicFollow(false,loc.writeUser.data.userId,loc.topicId);
					}
				}else{
					location.href = '/shine/login.html';
				}
				return false
			});
			//回答按钮
			$('answer-btn').on('click',function(e){
				var loc = topic._param;
				if(loc.writeUser){
					location.href = '/shine/answerWrite.html?channelId='+loc.channelId+'&topicId='+loc.topicId+'&userId='loc.writeUser.data.userId;
				}else{
					location.href = '/shine/login.html';
				}
				return false
			});
			//返回
			$('.turn-back').on('click',function(e){
				location.href = '/shine/topic.html?channelId=' + topic._param.channelId;
			});
		},		
		_pageLoad : function(){
			var loc = topic._param;
			loc.href = location.href;
			var sp = loc.href.lastIndexOf('topicId=');
			loc.topicId = loc.href.substring(sp+1);
			var tsp = loc.href.lastIndexOf('channelId='),
				mid = loc.href.lastIndexOf('&');
			loc.channelId = loc.href.substring(tsp+1,mid);

			$.get('/shine/sunTopic/getTopicByTopicId/'+loc.topicId,function(data){
				loc.topic = JSON.parse(data);
				if(loc.topic.meta.code === 200){
					var locdata = loc.topic.data;
					$('.content .writer-info .temperature-small').text(locdata.topicTemp+'&#176;');
					$('.content .content-detail').text(locdata.topicContent);
					topic._loadWriter(locdata.userId);
				}
			});
			
			this._loadAnswer(loc.topicId);
		},
		_loadAnswer : function(tid){
			var loc = topic._param,
			target = $('answer');
			target.children().remove();
			$.get('/shine/sunAnswer/queryAnswersByTopicIdOrderByTemp/'+tid,function(data){
				loc.answers = JSON.parse(data);
				if(loc.answers.meta.code === 200){
					var locdata = loc.answers.data;
					for(var idx in locdata){
						var html = '<li data-answerId="'+locdata[idx].topicAnswerId+'">'
						            +'    <div class="fl answer-user">'
						            +'        <p><img class="user-image" src="http://placehold.it/25x25" alt=""></p>'
						            +'        <p class="temperature-small">'+locdata[idx].topicAnswerTemp+'&#176;</p>'
						            +'    </div>'
						            +'    <div class="topic-answer">'
						            +'        <p class="answer-name">匿名</p>'
						            +'        <p class="answer-container">'+locdata[idx].topicAnswerContent+'</p>'
						            +'    </div>'
						            +'</li>';
						var $tar = $(html);
						target.append($tar);
						if(!locdata[idx].isAnonymity){
							topic._loadAnswerDetail( locdata[idx].userId,$tar);
						}
					}
				}
			})
		},
		_loadWriter : function(uid){
			var loc = topic._param;
			$.get('/shine/sunUser/user/'+uid,function(data){
				loc.writeUser = JSON.parse(data);
				if(loc.writeUser.meta.code === 200){
					var locdata = loc.writeUser.data;
					$('.writer-name').text("来自"+locdata.nickname);
					$('.writer-name+img').attr('src',locdata.avatarPath);
				}
			});
		},
		_loadAnswerDetail : function(uid, tar){
			var loc = topic._param;
			$.get('/shine/sunUser/user/'+uid,function(data){
				loc.answerUser = JSON.parse(data);
				if(loc.answerUser.meta.code === 200){
					var locdata = loc.answerUser.data;
					tar.find('.answer-name').text(locdata.nickname);
					tar.find('.answer-user .user-image').attr('src',locdata.avatarPath);
				}
			});
		},
		_topicFollow : function(flag, uid, tid){
			var url = flag ? '/shine/sunTopic/followTopic' : '/shine/sunTopic/unfollowTopic';
			$.post(url,{userId:uid,topicId:tid},function(data){
				console.log(data);
			});
		},
		_loginState : function(){
			$.get('/shine/sunUser/loginState',function(data){
				var loc = topic._param;
				loc.login = JSON.parse(data);
				$.post('/shine/sunTopic/hasFollowedTopic',{userId:loc.login.data.userId,topicId:loc.topicId},function(re){
					loc.followed = JSON.parse(re);
					if(loc.followed.meta.code === 200){
						var locdata = loc.followed.data;
						if(locdata){
							$('.follow-btn').removeClass('follow');
							$('.follow-btn').addClass('followed');
							$('.follow-btn').text("取消关注");
							$('.follow-btn').append("<span></span>")	
						}else{
							$('.follow-btn').removeClass('followed');
							$('.follow-btn').addClass('follow');
							$('.follow-btn').text("关注");
							$('.follow-btn').append("<span></span>")	
						}
					}
				});
			});
		}
	}
})();