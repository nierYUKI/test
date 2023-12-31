<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="css/bootstrap.min.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" />
<title>備品管理</title>
</head>
<body>
	<div class="container mt-5">
		<div class="row">
			<div class="col-lg-4 offset-lg-4">
				<form action="" method="post">
					<h1 class="h3 text-center mb-3 fw-normal">備品管理システム</h1>

					<c:if test="${error}">
						<div class="alert alert-danger" role="alert">
							ログインIDまたはパスワードが間違っています。</div>
					</c:if>

					<div class="form-floating">
						<input type="text" name="loginId"
							class="form-control rounded-0 rounded-top" id="floatingInput"
							placeholder="ログインID"> <label for="floatingInput">ログインID</label>
					</div>

					<div class="form-floating mb-3">
						<input type="password" name="loginPass"
							class="form-control border-top-0 rounded-0 rounded-bottom"
							id="floatingPassword" placeholder="パスワード"> <label
							for="floatingPassword">パスワード</label>
					</div>

					<input class="w-100 btn btn-lg btn-primary mb-3" type="submit"
						value="ログイン">

					<p class="text-center text-muted">&copy; ZDRIVE Inc.</p>
				</form>
			</div>
		</div>
	</div>
	<!-- /.container -->
	<script src="js/bootstrap.bundle.min.js"></script>
	<script src="js/jquery-3.6.0.min.js"></script>
</body>
</html>
