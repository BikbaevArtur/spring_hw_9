# Используйте официальный образ MySQL
FROM mysql:latest

# Установите переменные окружения
ENV MYSQL_DATABASE=hw_9 \
    MYSQL_ROOT_PASSWORD=password \
#    PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin \
    GOSU_VERSION=1.17 \
    MYSQL_MAJOR=innovation \
    MYSQL_VERSION=8.3.0-1.el8 \
    MYSQL_SHELL_VERSION=8.3.0-1.el8

COPY init.sql /docker-entrypoint-initdb.d/


EXPOSE 3306
