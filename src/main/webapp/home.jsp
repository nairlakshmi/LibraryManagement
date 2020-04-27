<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<h2 title="title">Books and Libraries</h2>
</head>
<body>

<form action="addLib">
<label for="libId">Lib Id</label>
<input type="text" name="libId" required><br>
<label for="libName">Name</label>
<input type="text" name="libName" required><br>
<input type="submit" value="Add Library"><br><br><br><br>
</form>

<form action="addBook">
<label for="id">Id</label>
<input type="text" name="id" required><br>
<label for="libId">Lib Id</label>
<input type="text" name="libId" value="0"><br>
<label for="name">Name</label>
<input type="text" name="name" required><br>
<label for="desc">Description</label>
<input type="text" name="desc" required><br><br>
<input type="submit" value="Add Book"><br><br><br><br>
</form>

<form action="mvBook">
<label for="id">Id</label>
<input type="text" name="id" required><br>
<label for="libId">Lib Id</label>
<input type="text" name="libId" required><br>
<input type="submit" value="Move Book to Library"><br><br><br><br>
</form>

<form action="updateBook">
<label for="id">Id</label>
<input type="text" name="id" value=${book.id}><br>
<label for="name">Name</label>
<input type="text" name="name" value=${book.name}><br>
<label for="desc">Description</label>
<input type="text" name="desc" value=${book.desc}><br><br>
<input type="submit" value="Update Book"><br><br><br>
</form>

<form action="getBook">
<label for="id">Id</label>
<input type="text" name="id"><br>
<input type="submit" value="Retrieve details on Book"><br><br>
</form>

<form action="getBooksofLib">
<label for="libId">Lib Id</label>
<input type="text" name="libId"><br>
<input type="submit" value="Retrieve List of Books from Library"><br><br>
</form>

<form action="delBook">
<label for="id">Id</label>
<input type="text" name="id"><br>
<input type="submit" value="Delete the Book"><br>
</form>

</body>
</html>