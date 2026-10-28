<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>책 등록</title>
</head>
<body>

    <h1>새로운 책 등록</h1>

    <form action="/books/regist" method="post">

        <p>
            책 제목:
            <input type="text" name="title">
        </p>

        <p>
            저자:
            <input type="text" name="author">
        </p>

        <p>
            장르:
            <input type="text" name="genre">
        </p>

        <button type="submit">등록하기</button>

    </form>

</body>
</html>