<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
	<head>
		<meta charset="utf-8">
		<title>Welcome</title>
	<jsp:include page="/WEB-INF/common/common.jsp"/>
	<script type="text/javascript">
$(document).ready(function(){
	$('.ajaxCall').click(function() {
		console.log('ajaxList : ' + $(this).val());
	    $.ajax({
	        url : "${pageContext.request.contextPath}/" + $(this).val(),
	        type: "get",
	        data : { "id" : $("#id").val() },
	        success : function(data){
	        	console.dir(data);
	        	data.forEach(function(val, index){
	        		console.log(val + ' : ' + index);
	        	});
	        }
	    });
	});//END OF CLICK FUNCTION
	
});
	</script>
	</head> 
	<body>
		<input type="text" id="id" />
		<input type="button" id="list_init" class="ajaxCall" value="list_init"/>
		<input type="button" id="list_listVoArr" class="ajaxCall" value="list_listVoArr"/>
		<input type="button" id="list_StringArr" class="ajaxCall" value="list_StringArr"/>
		<input type="button" id="list" class="ajaxCall" value="list"/>
	</body>
</html>
