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
  <h1>備品登録</h1>
  <div class="row">
    <div class="col-md-12">
      <p>備品の登録が完了しました。</p>
      <p><a href="listItem">備品リストに戻る</a></p>
    </div>
  </div>
</div><!-- /.container -->
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>
</body>
</html>
