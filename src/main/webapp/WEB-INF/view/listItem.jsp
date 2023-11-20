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
<c:import url="parts/header.jsp" />

<div class="container mt-3">
  <h1>備品リスト</h1>
  <div class="row">
    <div class="col-md-12">
      <table class="table table-bordered">
        <tr>
          <th>品名</th>
          <th>数量</th>
          <th>場所</th>
          <th>備考</th>
          <th>登録日</th>
          <th>更新日</th>
          <th colspan="2">データの操作</th>
        </tr>
        <c:forEach items="${ItemList}" var="item">
        <tr>
          <td><c:out value="${item.name}" /></td>
          <td><c:out value="${item.amount}" /></td>
          <td><c:out value="${item.locationName}" /></td>
          <td><c:out value="${item.note}" /></td>
          <td><fmt:formatDate value="${item.registered}" pattern="y年MM月dd日 HH:mm:ss" /></td>
          <td><fmt:formatDate value="${item.updated}" pattern="y年MM月dd日 HH:mm:ss" /></td>
	      <td><a href="updateItem?id=<c:out value="${item.id}" />&locationId=<c:out value="${item.locationId}" />">更新</a></td>
	      
	                   <%-- 呼び出したいサーブレット名 --%>
		  <td><a href="deleteList?id=<c:out value="${item.id}" />">削除
</a></td>
        </tr>
        </c:forEach>
      </table>
      <a class="btn btn-primary" href="addItem">備品の追加</a>
    </div>
  </div>
</div><!-- /.container -->
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>
</body>
</html>
