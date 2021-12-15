<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main</title>
</head>
<body>
<form action="/" method="get">
    <input type="text" name="type" placeholder="Type" value="${RequestParameters.type!}"/>
    <input type="text" name="date" placeholder="Date" value="${RequestParameters.date!}"/>
    <button type="submit" name="search">search</button>
</form>
<b>Сurrency table </b>
<#list curr as currs>
    <div class="values">
        <span>${currs.date}</span>
        <span>${currs.type}</span>
        <span>${currs.value}</span>
    </div>
</#list>
</body>
</html>