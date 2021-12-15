# Current
-MySQL для БД
Приложение загружает в БД данные проверяя входящие значения на дублирование в существующих записях БД,а затем отображает данные.
Данные можно фильтровать по аргументам type(валюта),date(дата значения котировки) в строке поиска или ,например, в Postman.
Я не успел реализовать миграцию поэтому для работы надо в application.properties прописать следующее:

spring.jpa.generate-ddl=true
spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/[ИМЯ БД MYSQL]
spring.datasource.username=[ИМЯ ЮЗЕРА]
spring.datasource.password=[ПАРОЛЬ]
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver







