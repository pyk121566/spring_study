<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">

	//입력 양식 서버로 전송
	function regist(){
		$("#form1").attr({
			action:"/news/regist",
			method:"POST"
		});
		
		$("#form1").submit();
	}

	$(function(){
		$("#bt_regist").click(()=>{			
			regist();
		});
	});

</script>


</head>
<body>

	<div class="container">
		<h2>뉴스기사 작성</h2>
		<form id="form1">
		
			<div class="form-group">
				 <input type="text" class="form-control"  placeholder="Enter title" name="title">
			</div>

			<div class="form-group">
				 <input type="text" class="form-control"  placeholder="Enter title" name="writer">
			</div>
	
				<div class="form-group">
				 <textarea type="text" class="form-control"  placeholder="Enter title" name="content"> </textarea>
			</div>
			
			<button type="submit" class="btn btn_default" id="bt_regist">글등록</button>
			<button type="submit" class="btn btn_default" id="bt_list">목록으로</button>
	
		</form>
	</div>

</body>
</html>
