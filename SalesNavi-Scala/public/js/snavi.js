var snavi = {};
(function() {
	snavi.ajax = function(param) {
		if (param.error  == null) {
			param.error  = function(XMLHttpRequest, textStatus, errorThrown) {
				alert(textStatus + ":error!!");
			};
		}
		$("body").showLoading();
		$.ajax(param);
		$("body").hideLoading();
	};

	snavi.pjax = function(param) {
		$("body").showLoading();
		$.pjax(param);
		$("body").hideLoading();
	}

	snavi.lang = {};
	snavi.lang.change = function(val) {
		$.cookie("SNAVI_LANG", val);
		var param = {
			url: window.history.current,
			container: '#contains-body'
		};
		snavi.pjax(param);
	};

	snavi.style = {};
	snavi.style.change = function(val) {
		$.cookie("SNAVI_STYLE", val);
		var param = {
			url: window.history.current,
			container: '#contains-body'
		};
		snavi.pjax(param);
	};
})();
