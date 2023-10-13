<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css">
    <title>Home</title>
</head>
<body>
    <h1>¡List of All Persons!</h1>
    <table class="center">
        <thead>
        <tr class="col-header">
            <th class="col">DNI</th>
            <th class="col">Name</th>
            <th class="col">LastName</th>
            <th class="col">Profession</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <tr class="rows">
            <td class="row">123456789</td>
            <td class="row">Mark</td>
            <td class="row">Otto</td>
            <td class="row">Developer</td>
            <td><a class="button btn-edit" href="#">Edit</a></td>
            <td><a class="button btn-delete" href="#">Delete</a></td>
        </tr>
        </tbody>
    </table>
    <div style="margin: 10px;">
        <a class="button btn-new" href="#">Add new Person</a>
    </div>
    <a href="#">Default</a>
</body>
</html>