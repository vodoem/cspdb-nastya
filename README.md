# Tour Agency System

Spring Boot приложение для автоматизации работы турагентства с серверным рендерингом на Thymeleaf и работой с PostgreSQL через Spring Data JPA.

## Технологии
- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- PostgreSQL
- Thymeleaf
- Maven
- Bootstrap 5

## Запуск
1. Убедитесь, что PostgreSQL доступен и БД создана по предоставленному SQL-скрипту.
2. Проверьте настройки подключения в `src/main/resources/application.properties`.
3. Запустите приложение:
   ```bash
   mvn spring-boot:run
   ```
4. Откройте: `http://localhost:8080`

## Конфигурация БД
```properties
spring.datasource.url=jdbc:postgresql://localhost:5434/cspdb-nastya
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
```

## Структура проекта
- `src/main/java/ru/touragency/entity` — JPA сущности всех таблиц.
- `src/main/java/ru/touragency/repository` — репозитории.
- `src/main/java/ru/touragency/service` — сервисный слой.
- `src/main/java/ru/touragency/controller` — MVC контроллеры.
- `src/main/java/ru/touragency/dto` — формы и DTO для отчетов.
- `src/main/resources/templates` — Thymeleaf шаблоны.
- `src/main/resources/static` — статические файлы.

## Доступные страницы
- `/`
- `/clients`, `/clients/{id}`
- `/managers`, `/managers/{id}`
- `/tours`, `/tours/{id}`
- `/requests`, `/requests/{id}`, `/requests/new`
- `/bookings`, `/bookings/{id}`
- `/booking-tourists/new`
- `/tourists`, `/tourists/{id}`
- `/reports`, `/reports/tours`, `/reports/managers`, `/reports/clients`
