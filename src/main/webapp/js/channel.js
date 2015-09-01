//(function(){
//    var channel = {
//        _param:{},
//        _init: function(){
//            this._event();
//        },
//        _event: function(){
//
//        },
//        _loadTopic : function(idx, tar){
//            $.get('/shine/sunTopic/getMaxTempTopicByChannelId/'+idx,function(data){
//                console.info(data);
//                var loc = channel._param;
//                loc.topic = data;
//                if(loc.topic.meta.code === 200){
//                    if(loc.topic.data) {
//                        var locdata = loc.topic.data;
//                        tar.find('.temperature-small').text(locdata.topicTemp + "° ");
//                        tar.find('.content-inner').text(locdata.topicContent);
//                    }
//                }
//            });
//        }
//    }
//    channel._init();
//})()
function getMaxTopic(channelId){
    console.info(channelId);
    $.get('/shine/sunTopic/getMaxTempTopicByChannelId/'+channelId,function(data){
        console.info(data);
        var loc = channel._param;
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