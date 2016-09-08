function updateOnlineUsers() {
    var url = '/onlineUsers';
    $("#userOnlinePage").load(url);
}

function updatePosts() {  
    $("#contentPage").load('/posts');
    $("#hiddenContent").load('/posts');
}