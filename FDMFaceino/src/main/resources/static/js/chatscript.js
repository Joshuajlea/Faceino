/**
 * 
 */
var stompClient = null;
var stompClient2 = null;

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
			stompClient.subscribe('/user/topic/messages', function(message) {
				showMessage(JSON.parse(message.body), 'response');
			});
		});
		var socket2 = new SockJS('/private');
		stompClient2 = Stomp.over(socket2);
		stompClient2.connect({}, function(frame) {
			setConnected(true);
			console.log('Connected: ' + frame);
			stompClient2.subscribe('/user/queue/messages', function(message) {
				showPrivateMessage(JSON.parse(message.body));
			});
		});
	}

	function sendPublicChatMessage() {
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

	function sendPrivateChatMessage(messageField) {
		var sender = document.getElementById('hiddenUser').innerHTML;
		var content = document.getElementById('messageGroup'+messageField).value;
		stompClient2.send("/app/private", {}, JSON.stringify({
			'sender' : sender,
			'content' : content,
			'conversationId' : messageField
		}));
		content = document.getElementById('messageGroup'+messageField);
		content.value = '';
		content.focus();
	}

	function showMessage(message, responseField) {
		var response = document.getElementById(responseField);

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
	
	function showPrivateMessage(message) {
		var response = document.getElementById('response' + message.conversationId);
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