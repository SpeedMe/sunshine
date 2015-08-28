(function(){
	var index = {
		_init: function(){
			this._event();
		},
		_event: function(){
			console.log(1);
			document.querySelector('#mySlider').addEventListener('slide', myFunction)
		}
	}	
	index._init();
})()