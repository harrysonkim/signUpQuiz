<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script></head>
</head>

<body class="container">

<h1>회원가입</h1>
<hr>
<form action="/member/join" method="post" class="form">

<div class="form-floating mb-3 col-4">
  <input type="text" class="form-control" name="userName" id="userName" placeholder="Name">
  <label for="floatingInput">Name</label>
</div>

<div class="form-floating mb-3 col-4">
  <input type="text" class="form-control" name="userNickName"  id="userNickName" placeholder="닉네임">
  <label for="floatingPassword">닉네임</label>
</div>

<div class="form-floating col-4">
  <input type="text" class="form-control" name="userEmail"  id="userEmail" placeholder="Email">
  <label for="floatingPassword">Email</label>
</div>

<div>
	<button>확인</button>
</div>

</form>

</body>
</html>