FROM tomcat:7.0

COPY src/main/resources/tomcat-users.xml /usr/local/tomcat/conf

COPY target/my-web-app-4.war /usr/local/tomcat/webapps/

EXPOSE 8080

CMD ["catalina.sh", "run"]