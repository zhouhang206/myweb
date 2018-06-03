<%@ page  pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8">
<title>员工注册</title>
</head>
<body>
	<from action="empsave.do" enctype="multipart/form-data" method="post">
		姓名：<input name="name" placeholder="姓名"><br> 
		性别：<input type="radio" name="sex" value="男" checked>男 
			<input type="radio" name="sex" value="女">女<br> 
		生日：<input type="date" placeholder="生日" name="birthday"><br>
		电话：<input name="phone" placeholder="电话" ><br>
		岗位：<input name="job" placeholder="岗位" ><br>
		住址：<input name="addr" placeholder="住址" ><br>
		照片：<input type="file" name="photo"><br>
		<button>保存</button>
	</from>
</body>
</html>