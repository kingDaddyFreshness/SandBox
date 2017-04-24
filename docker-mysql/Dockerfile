FROM mysql/mysql-server:latest

COPY script.sql /root

ENV MYSQL_ROOT_PASSWORD garbo

CMD ["mysql --user=root --password=garbo < /root/script.sql", "run"]