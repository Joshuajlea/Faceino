function retrievePosts() {
    var url = '/posts';
   
    if ($('#content').val() != '') {
        url = url + '/' + $('#content').val();
    } 
    
    $("#hiddenContent").load(url);
    $("#contentPage").load('/posts');
    document.getElementById("contentPage").innerHTML= document.getElementById("hiddenContent").innerHTML;
}
