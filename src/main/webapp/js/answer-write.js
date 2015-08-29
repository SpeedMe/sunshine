(function(){
	var answer = {
		_param:{},
		_init: function(){
			answer._event();
			answer._pageLoad();
		},
		_event: function(){
			//绑定匿名按钮
			$('.bottom-btn .tab-item-left').on('click',function(e){
				var target = $(e.target);
				if(!target.hasClass('icon'))
					target = target.find('.icon');
				if(target.hasClass('icon-check')){
					target.removeClass('icon-check');
				}else{
					target.addClass('icon-check');
				}
				return false
			});
			//绑定发布
			$('.bottom-btn .tab-item-right').on('click',function(e){
				var loc = answer._param,
					isAnonymity = $('.bottom-btn .tab-item-left .icon').hasClass('icon-check') ? true : false;
					topicAnswerContent = $('.enter-input').val();
				if(topicAnswerContent!=""){
					$.post('/shine/sunAnswer/answerTopic',{topicId:loc.topicId,userId:loc.userId,isAnonymity:isAnonymity,topicAnswerContent:topicAnswerContent},function(data){
						var loc = answer._param;
						loc.ret = data;
						if(loc.ret.meta.code === 200){
							location.href = document.referrer;
						}
					})
				}else
					alert('内容不能为空')
				return false
			});
			//绑定返回
			$('.trun-back').on('click',function(e){
				history.go(-1);
			});
		},		
		_pageLoad : function(){
			var loc = answer._param;
			loc.href = location.href;
			var sp = loc.href.lastIndexOf('userId=');
			loc.userId = loc.href.substring(sp+7);
			var tsp = loc.href.lastIndexOf('topicId='),
				mid = loc.href.lastIndexOf('&');
			loc.topicId = loc.href.substring(tsp+8,mid);
			var tsp = loc.href.lastIndexOf('channelId='),
				mid = loc.href.lastIndexOf('&topicId');
			loc.channelId = loc.href.substring(tsp+9,mid);
		}
	};
	$(document).ready(answer._init);
})();