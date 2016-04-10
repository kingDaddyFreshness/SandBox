FROM tomcat:7.0

COPY src/main/resources/tomcat-users.xml /usr/local/tomcat/conf

ADD target/my-web-app.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]