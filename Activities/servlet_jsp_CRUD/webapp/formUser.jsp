<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style.css">
    <title>User management</title>
</head>
<body>
    <h1>Register / Update Person</h1>
    <form class="center" action="#" method="POST">
        <div class="field">
            <div>
                <label>Name</label>
            </div>
            <div>
                <input class="text-center" type="text" placeholder="Bill">
            </div>
        </div>

        <div class="field">
            <div>
                <label>Last Name</label>
            </div>
            <div>
                <input class="text-center" type="text" placeholder="Gates">
            </div>
        </div>

        <div class="field">
            <div>
                <label>DNI</label>
            </div>
            <div>
                <input class="text-center" type="tel" placeholder="11222333">
            </div>
        </div>

        <div class="field">
            <label>Date of Birth</label>
            <input class="text-center" type="date" min="">
        </div>
        
        <div class="field">
            <label>Profession</label>
            <select class="text-center">
                <option value="#" disabled selected>--- Select An Option ---</option>
                <option value="BACKEND_DEVELOPER">Backend Developer</option>
                <option value="FRONTEND_DEVELOPER">Frontend Developer</option>
                <option value="QA_TESTER">Tester QA</option>
                <option value="FULLSTACK_DEVELOPER">Fullstack Developer</option>
            </select>
        </div>

        <div class="field" style="margin-top: 25px;">
            <a class="button btn-new" href="#">Save Changes</a>
        </div>
    </form>
    <a href="#">Back</a>
</body>
</html>