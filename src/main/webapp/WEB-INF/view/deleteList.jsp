<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>備品管理</title>
</head>
<body>
	<h1>備品削除</h1>
	<form action="" method="post">
		<table border="1">
		<c:forEach items="${ItemList}" var="item">
			<tr>
				<th>品名</th>
				<td><c:out value="${item.name}" /></td>
			</tr>
			<tr>
				<th>数量</th>
				<td><c:out value="${item.amout}" /></td>
			</tr>
			<tr>
				<th>場所</th>
				<td><c:out value="${item.locationName}" /></td>
			</tr>
			<tr>
				<th>備考</th>
				<td><c:out value="${item.note}" /></td>
			</tr>
			<tr>
				<th>登録日</th>
				<td><fmt:formatDate value="${item.registered}" pattern="y年MM月dd日 HH:mm:ss" /></td>
			</tr>
			</c:forEach>
		</table>
		<p>
			<input type="submit" value="削除">
		</p>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script>
		$(document).ready(function() {
			$("form").submit(function() {
				return confirm("本当に削除しますか？");
			});
		});
	</script>
</body>
</html>