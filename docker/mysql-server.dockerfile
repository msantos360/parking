FROM mysql:5.6

EXPOSE 3306
ENV MYSQL_ROOT_PASSWORD=1234 MYSQL_DATABASE=parkingDb MYSQL_HOST=mysql-server
VOLUME [ "/home/michael/Documents/fiap/database:/var/lib/mysql" ]
COPY ./db/ /docker-entrypoint-initdb.d