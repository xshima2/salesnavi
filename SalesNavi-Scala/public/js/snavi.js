$(document)
.on('pjax:start', function() { $('body').showLoading(); })
.on('pjax:end',   function() { $('body').hideLoading(); });

var snavi = {};
(function() {
	snavi.ajax = function(param) {
		if (param.error  == null) {
			param.error  = function(response, textStatus, errorThrown) {
				if (errorThrown == '') {
					alert(textStatus + ":" + 通信エラー);
				}
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
				container: container,
				url: $('#' + formId).attr('action'),
				type: 'POST',
				data: $('#' + formId).serializeArray(),
				dataType: 'html',
				complete: function(response, textStatus) {
					$('#' + container).html(response.responseText);
					if (response.getResponseHeader("REDIRECT-URL") != null) {
						window.history.pushState(null, document.title, response.getResponseHeader("REDIRECT-URL"));
					}
				},
				success: function(data, dataType) {
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

	$('a[data-pjax]').pjax();

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

	snavi.reset = function(formId) {
		$(':input', $(formId)).each(function() {
			var type = this.type;
			var tag = this.tagName.toLowerCase();
			if (type == 'text' || type == 'password' || tag == 'textarea') this.value = '';
			else if (type == 'checkbox' || type == 'radio') this.checked = false;
			else if (tag == 'select') this.selectedIndex = -1;
		});
	};
})();
