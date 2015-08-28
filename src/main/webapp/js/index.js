(function(){
	var index = {
		_param:{},
		_init: function(){
			this._event();
			this._pageLoad();
		},
		_event: function(){
			console.log(1);
			document.querySelector('#mySlider').addEventListener('slide', myFunction)
		},		
		_pageLoad : function(){
			$.get('/shine/sunChannel/getAllChannelsOrderByTemp',function(data){
				var loc = index._param;
				loc.channel = JSON.parse(data);
				if(loc.channel.meta.code === 200){
					var locdata = loc.channel.data,
						target = $('.content>ul>li');
					for(var idx in locdata){
						if(target.eq(idx)){
							target.eq(idx).find('.temperature').text(locdata[idx].channelTemp+"&#176;");
							target.eq(idx).find('.content-tit').text(locdata[idx].channelName);
							target.eq(idx).find('.channel-link').attr('href','/shine/topic.html?channelId='+locdata[idx].channelId);
							index._loadTopic(locdata[idx].channelId, target.eq(idx)); 
						}
					}
				}
			});
		},
		_loadTopic : function(idx, tar){
			$.get('/shine/sunTopic/getMaxTempTopicByChannelId/'+idx,function(data){
				var loc = index._param;
				loc.topic = JSON.parse(data);
				if(loc.topic.meta.code === 200){
					var locdata = loc.topic.data[0];
					tar.find('.temperature-small').text(locdata.topicTemp+"&#176;");
					tar.find('.content-inner').text(locdata.topicContent);
				}
			});
		}
	}	
	index._init();
})()