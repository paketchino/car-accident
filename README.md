## Нужно будет разработать проект - Автонарушители.

### В системе существуют три роли. Обычные user, admin, supervisor.

- Пользователь может добавлять accidents.

- Админ может добавлять доп. статьи, типы инцидента и изменять их

- Supervisor закрывает инциденты

- В заявлении указывает: адрес, номер машины, описание нарушения, фотографию нарушения, статус соответсвующий закон и тип инцидента.

- У заявки есть статус. В процессе. Завершена. Может только завершать supervisor, если user попытается это сделать, 

- ему придет сообщение с ошибкой 403 forbidden 

- Вид системы. Главная страница - это поиск с таблицей.

- Так же присутствуют списки со статьями и инцидентами. 

- Они доступны только admin, это страница /adminView, для более упрощенного использования всех функций

- Так же для регистрации админа присутствует /redAdmin для упрощения 

- Под этот проект создайте новый репозиторий job4j_car_accident

## Стек технологий:

![java](https://img.shields.io/badge/Java--17-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot--2.7.5-F2F4F9?style=for-the-badge&logo=spring-boot)
![Bootstrap](https://img.shields.io/badge/Bootstrap--5.2.2-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white)
![PostgresSQL](https://img.shields.io/badge/PostgreSQL--42.3.6-316192?style=for-the-badge&logo=postgresql&logoColor=white)

![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.0.0.RELEASE-blue)
![Liquibase](https://img.shields.io/badge/Liquibase-4.17.2-red)
![Junit](https://img.shields.io/badge/JUNIT-4.13.1-orange)
![Mockito](https://img.shields.io/badge/MOCKITO-3.5.13-red)
![H2](https://img.shields.io/badge/hsqldb-2.1.214-yellowgreen)
![Log4j](https://img.shields.io/badge/Log4j-2.18.0-green)
![Lombok](https://img.shields.io/badge/Lombok-1.18.24-white)

## Контакты
[![Telegram](https://img.shields.io/badge/TELEGRAM-26A5E4?style=for-the-badge&logo=telegram&logoColor=white)](https://t.me/romanka3)

### chansforman@gmail.com

## Перед запуском установите:

- Java 17
- Apache Maven 3.x
- Postgres 14


## Запуск приложения

1. Создать бд:
```sql
create database job4j_car_accident;
```

2. Запуск приложения с maven. Перейдите в корень проекта через командную строку и выполните команды:
```
    mvn clean install
    mvn spring-boot:run
```
3. Запустить ссылку http://localhost:8080/index

Сначало нужно пройти регистрацию перейти, зарегистрироваться как user или admin через /regAdmin 

![](src/main/resources/image/image_2022-12-08_13-32-16.png)

После авторизации вы попадете на стартовую страницу 

![](src/main/resources/image/Screenshot_8.png)

Где можете создать новый accident

![](src/main/resources/image/image_2022-12-10_01-47-43.png)

После чего перейти по ссылки 

![](src/main/resources/image/image_2022-12-10_01-52-16.png)

Внести изменения и сохранить 

![](src/main/resources/image/image_2022-12-10_01-51-24.png)

Для создания или обновления обьектов rule, accidentType нужно перейти по ссылке в качестве роли ADMIN

![](src/main/resources/image/Screenshot_1.png)

После перехода откроется ссылка на все возможные функции

![](src/main/resources/image/Screenshot_2.png)

Создание 

![](src/main/resources/image/Screenshot_3.png)

![](src/main/resources/image/Screenshot_5.png)

Обновление для удобства оно превращено используется список  

![](src/main/resources/image/Screenshot_4.png)

Где можно перейти по ссылке и изменить данный параметр

![](src/main/resources/image/Screenshot_6.png)

Созданные заявки закрывает supervisor, чтобы ее закрыть нужно иметь роль ADMIN или SUPERVISOR. USER МОЖЕТ ТОЛЬКО ИХ СОЗДАВАТЬ!!

![](src/main/resources/image/Screenshot_8.png)

После перехода нужно нажать подтвердить после чего заявка будет считаться закрытой

![](src/main/resources/image/Screenshot_9.png)

Закрытая заявка

![](src/main/resources/image/Screenshot_10.png)