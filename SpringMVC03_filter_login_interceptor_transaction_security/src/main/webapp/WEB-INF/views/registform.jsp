<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	function idchk(){
		var memberid = $("#memberid").val().trim();
		$.ajax({
			type:"post",
			url:"ajaxidchk.do",
			data:  {memberid: memberid},
			dataType: "json",
			success:function(msg){
				if(msg.check == false){
					alert("사용 가능한 아이디입니다.");
					$("#memberid").attr("title","y");
					$("#canRegist").css("display","");
				}else{
					alert("이미 존재하는 아이디입니다.");
				}
			},
			error: function(error){
				alert("통신실패");
				console.log(error);
			}
		})
	}
	
	function pleaseChkId(){
		if($("#memberid").attr("title")=="n"){
			alert("아이디 중복체크를 먼저 해주세요");
			$("#memberid").focus();
		}
			
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="regist.do" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="memberid" title="n" id="memberid" required="required"></td>
				<td><input type="button" value="중복체크" onclick="idchk();" >
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="memberpw" id="memberpw" required="required" onclick="pleaseChkId();"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="membername" required="required" onclick="pleaseChkId();"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="회원가입" style="display: none;" id="canRegist"><input type="button" value="돌아가기" onclick="location.href='index.html'"></td>
			</tr>
		</table>
	</form>
</body>
</html>