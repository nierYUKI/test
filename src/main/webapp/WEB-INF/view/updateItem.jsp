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
  <h1>備品登録</h1>
  <div class="row">
    <div class="col-md-12">
      <form action="" method="post">
        <div class="form-group mb-3">
          <label for="formName">品名</label>
          <input type="text" name="name" id="formName" class="form-control"
          value="<c:out value="${name }"/>" />
          <c:if test="${!empty errorName }">
          <div class="alert alert-danger mt-1" role="alert">
          	<c:out value="${errorName }"></c:out>
          </div>
          </c:if>
        </div>
        
        <div class="form-group mb-3">
          <label for="formAmount">数量</label>
          <input type="text" name="amount" id="formAmount" class="form-control"
          	value="<c:out value="${amount }"/>"  />
          	<c:if test="${!empty erroramount  }">
          	<div class="alert alert-danger mt-1" role="alert">
          		<c:out value="${erroramount }"/>
          	</div>
          	</c:if>
        </div>
        
        <div class="form-group mb-3">
          <label for="formLocation">場所</label>
          <select name="locationId" id="formLocation" class="form-control">
            <c:forEach items="${locationList}" var="location">
              <option value="<c:out value="${location.id}" />">
                <c:out value="${location.name}" />
              </option>
            </c:forEach>
          </select>
        </div>
        <div class="form-group mb-3">
          <label for="formNote">備考</label>
          <textarea name="note" id="formNote" class="form-control"></textarea>
        </div>
        <div class="form-group">
          <input type="submit" class="btn btn-primary" value="登録" />
          <a href="listItem" class="btn btn-secondary">キャンセル</a>
        </div>
      </form>
    </div>
  </div>
</div><!-- /.container -->
<script src="js/bootstrap.bundle.min.js"></script>
<script src="js/jquery-3.6.0.min.js"></script>
</body>
</html>
