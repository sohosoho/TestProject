<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학과 테이블</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	function insertPopup(){
		$("#no").val(0);
		window.open("","pop","width=700,height=400");
		$("#popupForm").attr("action","/subject/selectSubject.do");
		$("#popupForm").attr("target","pop");
		$("#popupForm").attr("insert","1");
		$("#popupForm").submit();
	}
	function updatePopup(no){
		$("#no").val(no);
		window.open("","pop","width=700,height=400");
		$("#popupForm").attr("action","/subject/selectSubject.do");
		$("#popupForm").attr("target","pop");
		$("#popupForm").submit();
		
	}
</script>
</head>
<body>
	<div>
		<a href="../">메인</a>
	</div>
	<form id="popupForm" name="popupForm" method="post">
		<input type="hidden" name="no" id="no" />
	</form>
	<div>
		<table border="1">
			<caption><h3>학과[Subject]</h3></caption>
			<colgroup>
				<col width="120px" />
				<col width="100px" />
				<col width="220px" />
				<col width="110px" />
			</colgroup>
			<thead>
				<tr>
					<th>학과일련번호</th>
					<th>학과 번호</th>
					<th>학 과 명</th>
					<th>상세보기</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty subjectList}">
					<tr>
						<td colspan="5" align="center">등록된 학과 정보가 존재하지 않습니다.</td>
					</tr>
				</c:if>
				<c:forEach items="${subjectList}" var="row">
					<tr>
						<td align="center">${row.no}</td>
						<td align="center">${row.s_num}</td>
						<td align="center">${row.sname}</td>
						<td align="center"><input type="button" value="[수정/삭제]" onclick="updatePopup('${row.no}')" /></td>
					</tr>
				</c:forEach>
					<tr>
						<td colspan="3" align="center">학과 정보 등록</td>
						<td align="center"><input type="button" onclick="insertPopup()" value="[ 학과 등록 ]"/></td>
					</tr>
			</tbody>
		</table>
	</div>
	<p></p>
	<div>
		<!-- search -->
		<form id="searchForm" name="searchForm" method="post">
			<table border="1" cellpadding="1" cellspacing="1">
				<tr>
					<th>학 과 명</th>
					<td><input type="text" id="s_name" name="s_name" /></td>
					<td><input type="button" onclick="listSearch()" value="검색" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>