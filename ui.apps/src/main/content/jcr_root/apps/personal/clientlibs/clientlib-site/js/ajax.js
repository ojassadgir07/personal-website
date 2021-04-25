$(document).ready(function(){
    $('#submit').click(function() {

    //Get the user-defined values
    var firstValue= $('#firstval').val() ; 
    var secondValue= $('#secondval').val() ; 

  
    //Use JQuery AJAX request to post data to a Sling Servlet
    $.ajax({
         type: 'POST',    
         url:'/bin/calculatorServlet',
         data:'firstVal='+ firstValue +'&secondVal='+ secondValue,
         success: function(msg){
           $('#totalval').val(msg.totalValue); 
         }
     });
  });

});