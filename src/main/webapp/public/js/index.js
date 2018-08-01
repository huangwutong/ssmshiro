$.ajax({
	url:ctx+'/menu/findAll',
	type:"post",
	dataType: 'json',  
	success: function(data){
		 jQuery.each(data,function(i,item){     
			 alert(item.id+","+item.name);     
         }); 
	 },     
     error: function(){     
         return;     
     }     
 });    
