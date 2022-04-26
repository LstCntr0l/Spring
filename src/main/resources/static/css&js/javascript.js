
$(document).ready(function(){
$('.table .eBtn ').on('click', function(event){
event.preventDefault();
var href = $(this).attr('href');

$.get(href,function(cash,status)
{
$(' .myForm #update').val(cash.update)
});
$('myForm #exampleModalLabel').modal();
});
});