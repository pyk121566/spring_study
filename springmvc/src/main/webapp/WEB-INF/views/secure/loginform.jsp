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
</head>
<script type="text/javascript">
	/*
	비동기 기술의 발전 순서
	1) XMLhttpRequest 를 직접 제어
	2) JQuery Ajax (외부 의존 라이브러리이므로 사용이 지양되고 있는 추세)
 	3) Promise (브라우저 자체 지원 API)
	4) fetch (Promise 가 사용하기에 너무 코드량이 많고 복잡하므로 fetch 로 숨겨놓음) 
 	5) async/await 
	*/
	
	
	function login(){
 		/*
 		Promise란 ? 미래의 확정되지 않는 작업에 사용되는 비동기 처리기술 (웹 요청 등)
 		화살표 함수의 매개변수
 		변수1) resolve 라는 이름의 함수명을 정함 - 비동기 요청이 성공하였을 떄 호출할 함수명 
 		변수2) reject 라는 이름의 함수명을 정함 - 비동기 요청이 실패하였을 때 호출할 함수명
 		*/
 		let formData={
 			accountId:$("input[name='accountId']").val(),
 			pwd:$("input[name='pwd']").val()
 		}
		let promise = new Promise((resolve, reject)=>{
			
			//비동기 출발!
			$.ajax({
				url:"/login",	//우리가 정한 로그인 요청 url 이므로, 스프링 시큐리티에게 알려줘야 함
				type:"POST",
				data:formData,	//스프링 시큐리티는 form 전송을 허용하므로, json 으로 보내지 말자 contentType:"application/jason; charset=UTF-8" 하지말자
										//개발자가 contentType 을 생략하면 디폴트 폼 파라미터임
				success:function(result, status, xhr){	 //2xx 성공의 상태 status 코드 서버로부터 받아올때
					resolve(result);
				},
				error:function(xhr, status, error){	//3xx 이상의 문제가 생긴 status 코드를 서버로부터 받아올때 
					reject(error);
				}
			});
		});	//Promise 생성자의 닫는 소괄호
		
		return promise;
	}

	$(function(){
		$("#bt-login").click(()=>{
			login()
				.then((result)=>{
					console.log("로그인 성공 후 반환 데이터는", result);
					console.log("서버의 응답 정보", result);
					alert("로그인 성공");
					location.href="/spa/main";
				})		//반환된 Promise의 then 을 호출한다.. then 은 reseolve() 호출시 호출된다.
				.catch((error)=>{
					alert("로그인 정보가 올바르지 않습니다.");
				})  	//반환된 Promise 에서 reject 호출 시 catch 가 호출된다.
			
				console.log("AAA");
			
		});
	});

</script>
<body>

	<div class="container">
		<h2>로그인</h2>
		<form id="form1">
			<div class="form-group">
				 <input type="text" class="form-control"  placeholder="Enter Your Id"name="accountId">
			</div>
			
			<div class="form-group">
				 <input type="password" class="form-control"  placeholder="Enter password" name="pwd">
			</div>

			<button type="button" class="btn btn-primary" id="bt-login">Submit</button>
		</form>
	</div>

</body>
</html>
