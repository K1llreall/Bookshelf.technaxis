# Bookshelf.technaxis
перед запуском приложения необходимо создать таблицу books в pgAdmin.
после первого запуска,необходимо в файле application.properties 
на 12 сроке spring.jpa.hibernate.ddl-auto=create изменить параметр create на update чтобы таблица не создавалась каждый запуск снова.
