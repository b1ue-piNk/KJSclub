$(function() {
	
	$("#title").keydown(function(event) {
		if(event.keyCode==13){
			if($(this).val() == ""){
				alert("请输入操作！");
			}
			else{
				// alert("11");
				var txt = $(this).val();
				// console.log(txt);
				var todo = $("<li></li>");
				todo.html("<input type='checkbox'>" + "<p>" + txt + "</p>" +
							"<a href='javascript:;'></a>");
				// console.log(todo);
				$(".todo").prepend(todo);
				count();
				
				$(this).val("");
			}
		}
	});
	
	$("ul").on("click","a",function() {
		$(this).parent().remove();
		count();
	});
	
	$("ul").on("change","input",function() {
		if($(this).prop("checked")){
			// console.log("11");
			$(this).parent().appendTo(".done");
			count();
		}else {
			$(this).parent().appendTo(".todo");
			count();
		}
	});
	
	function count() {
		var num1 = $(".todo li").length;
		var num2 = $(".done li").length;
		$(".num").eq(0).html(num1);
		$(".num").eq(1).html(num2);
	}
})