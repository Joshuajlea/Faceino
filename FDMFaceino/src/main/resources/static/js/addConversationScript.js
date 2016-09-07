
function loadRegisteredUsers() {
    $.ajax({
        url:"/allusers",  
        success:function(data) {
        	showAllUserNames(data); 
        }
      });
    
}

function showAllUserNames(data){
	for (i=0 ; i<data.length ; i++){
		var name = data[i];
		var checkbox = document.createElement("INPUT");
		checkbox.setAttribute("type", "checkbox");
		checkbox.id = 'checkbox_' + i;
		checkbox.name = name;
		var p = document.createElement('p');
		var parentElement = document.getElementById('userNames');
		p.appendChild(checkbox);
		p.appendChild(document.createTextNode('   ' + name));
		parentElement.appendChild(p);
	}
}

function createConversation(){
	var receivers = [];
	for (i=0 ; i<document.getElementById('userNames').elements.length ; i++){
		if (document.getElementById('checkbox_' + i).checked) {
			receivers.push(document.getElementById('checkbox_' + i).name);
		}
	}
	$.ajax({
		   type: "POST",
		   data: {myArray: receivers},
		   url: "/conversation",
		   success: function(msg){
		     
		   }
		});
}
