/**
 * 
 */

function load_nUsers(){
	document.getElementById("contentPage").innerHTML= document.getElementById("hiddenNUser").innerHTML;
}
   
function load_eUsers(){
	document.getElementById("contentPage").innerHTML= document.getElementById("hiddenEUser").innerHTML;
}
   
function load_bUsers(){
	document.getElementById("contentPage").innerHTML= document.getElementById("hiddenBUser").innerHTML;
}

function retrieveGuests() {
    var url = '/test';
   
    if ($('#stuff_id').val() != '') {
        url = url + '/' + $('#stuff_id').val();
    } 
    
    $("#hiddenContent").load(url);
    document.getElementById("contentPage").innerHTML= document.getElementById("hiddenContent").innerHTML;
}