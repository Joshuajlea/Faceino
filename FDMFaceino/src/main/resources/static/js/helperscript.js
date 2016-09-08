function updateOnlineUsers() {
    var url = '/onlineUsers';
    $("#userOnlinePage").load(url);
}

function updatePosts() {
    var url = '/posts';    
    $("#contentPage").load(url);
}