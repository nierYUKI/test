<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<h1>ユーザー登録</h1>
<form action="" method="post">

<p>ログインID：
<input type="text" name="loginId">
</p>

<p>ログインPASS：
<input type="text" name="loginPass">
</p>

<p>名前
<input type="text" name="name">
</p>

<p>
<input type="submit" value="登録">
</p>

</form>

</body>
</html>