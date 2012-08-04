$(document)
.on('pjax:start', function() { $('body').showLoading(); })
.on('pjax:end',   function() { $('body').hideLoading(); });

var snavi = {};
(function() {
	snavi.ajax = function(param) {
		if (param.error  == null) {
			param.error  = function(XMLHttpRequest, textStatus, errorThrown) {
				alert(textStatus + ':error!!');
			};
		}
		$('body').showLoading();
		$.ajax(param);
		$('body').hideLoading();
	};

	snavi.ajax.post =  function(formId, container) {
		if (container == null) {
			container = 'contains-body';
		}
		var param = {
				url: $('#' + formId).attr('action'),
				type: 'POST',
				data: $('#' + formId).serializeArray(),
				dataType: 'html',
				complete: function(response, textStatus) {
					window.history.pushState(null, document.title, response.getResponseHeader("REDIRECT-URL"));
				},
				success: function(data, dataType) {
					$('#' + container).html(data);
				},
				beforeSend: function(jqXHR, settings) {
					jqXHR.setRequestHeader('X-PJAX', 'true');
				}
		};

		snavi.ajax(param);
	};

	snavi.pjax = function(param) {
		$.pjax(param);
	};

	snavi.lang = {};
	snavi.lang.change = function(val) {
		$.cookie('SNAVI_LANG', val);
		var param = {
			url: window.history.current,
			container: '#contains-body'
		};
		snavi.pjax(param);
	};

	snavi.style = {};
	snavi.style.change = function(val) {
		$.cookie('SNAVI_STYLE', val);
		var param = {
			url: window.history.current,
			container: '#contains-body'
		};
		snavi.pjax(param);
	};
})();
