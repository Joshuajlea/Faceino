/**
 * 
 */
var stompClient = null;

	function setConnected(connected) {
		document.getElementById('conversationDiv').style.visibility = connected ? 'visible'
				: 'hidden';
		document.getElementById('response').innerHTML = '';
	}

	function connect() {
		var socket = new SockJS('/public');
		stompClient = Stomp.over(socket);
		stompClient.connect({}, function(frame) {
			setConnected(true);
			console.log('Connected: ' + frame);
			stompClient.subscribe('/user/queue/messages', function(message) {
				showMessage(JSON.parse(message.body));
			});
		});
	}

	function sendChatMessage() {
		var sender = document.getElementById('hiddenUser').innerHTML;
		var message = document.getElementById('message').value;
		stompClient.send("/app/public", {}, JSON.stringify({
			'sender' : sender,
			'content' : message
		}));
		var content = document.getElementById('message');
		content.value = '';
		content.focus();
	}

	function showMessage(message) {
		var response = document.getElementById('response');

		var boldName = document.createElement('b');
		var name = message.sender.split('@')[0];
		boldName.appendChild(document.createTextNode(name));

		var cursivContent = document.createElement('i');
		cursivContent.appendChild(document.createTextNode(message.content));

		var p = document.createElement('div');
		p.id = "oneMessageInChat";
		p.style.wordWrap = 'break-word';
		p.appendChild(boldName);
		p.appendChild(document.createTextNode(' : '));
		p.appendChild(cursivContent);
		p.appendChild(document.createElement('br'));
		p.appendChild(document.createElement('br'));
		response.insertBefore(p, response.childNodes[0]);
	}

	$('#myTabs').bind('show', function(e) {
		paneID = $(e.target).attr('href');
		src = $(paneID).attr('data-src');
		// if the iframe hasn't already been loaded once
		if ($(paneID + " iframe").attr("src") == "") {
			$(paneID + " iframe").attr("src", src);
		}
	});