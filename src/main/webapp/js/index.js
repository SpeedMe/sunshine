(function(){
	var index = {
		_param:{},
		_init: function(){
			this._event();
			this._pageLoad();
		},
		_event: function(){

		},		
		_pageLoad : function(){
			$.get('/shine/sunChannel/getAllChannelsOrderByTemp',function(data){
				var loc = index._param;
				loc.channel = data;
				if(loc.channel.meta.code === 200){
					var locdata = loc.channel.data,
						target = $('.content>ul>li');
					for(var idx in locdata){
						if(target.eq(idx)){
							target.eq(idx).find('.temperature').text(locdata[idx].channelTemp+"° ");
							target.eq(idx).find('.content-tit').text(locdata[idx].channelName);
							target.eq(idx).find('.channel-link').attr('href','/topic.html?channelId='+locdata[idx].channelId);
							index._loadTopic(locdata[idx].channelId, target.eq(idx)); 
						}
					}
				}
			});
		},
		_loadTopic : function(idx, tar){
			$.get('/shine/sunTopic/getMaxTempTopicByChannelId/'+idx,function(data){
				var loc = index._param;
				loc.topic = data;
				if(loc.topic.meta.code === 200){
					if(loc.topic.data) {
						var locdata = loc.topic.data;
						tar.find('.temperature-small').text(locdata.topicTemp + "° ");
						tar.find('.content-inner').text(locdata.topicContent);
					}
				}
			});
		}
	}	
	index._init();
})()