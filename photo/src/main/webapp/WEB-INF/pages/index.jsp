<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Prog.kiev.ua</title>
</head>
<body>
<div align="center">
    <form action="view" method="POST">
        <input type="submit" value="Посмотреть загруженные"/>
    </form>

    <form action="add_photo" enctype="multipart/form-data" method="POST">
        Photo: <input type="file" name="photo">
        <input type="submit"/>
    </form>
</div>
</body>
</html>
