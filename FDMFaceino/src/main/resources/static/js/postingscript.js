function retrievePosts() {
    var url = '/posts';
   
    if ($('#content').val() != '') {
    	var temp = $('#content').val();
    	temp = temp.replace(/ /g,'%20');
    	url = url + '/' + temp;
    } 
    
    $("#contentPage").load(url);
    $("#hiddenContent").load('/posts');
}
