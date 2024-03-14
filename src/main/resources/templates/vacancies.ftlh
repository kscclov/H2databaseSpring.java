<!DOCTYPE html>
<html lang="en">
<head>
    <title>Vacancies</title>
</head>
<body>
<h1>Цифровое будущее</h1>
<h4> Вакансии</h4>
<#list vacancies as vacancy>
    <div>
        <p><b>${vacancy.title}</b> ${vacancy.salary}</p>
    </div>
</#list>
<hr>
<h3>Создать новую вакансию</h3>
<form action="/vacancy/create" method="post">
    Название вакансии: <input type="text" name = "title"/><br><br>
    Описание вакансии: <input type="text" name = "description"/><br><br>
    Должность: <input type="text" name = "jobTitle"/><br><br>
    Зарплата: <input type="number" name = "salary"/><br><br>
    Опыт: <input type="text" name = "expirience"/><br><br>
    Город: <input type="text" name = "city"/><br><br>
    <input type="submit" value="добавить вакансию"/>
</form>
</body>
</html>