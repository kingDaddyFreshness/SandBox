FROM tomcat:7.0

COPY src/main/resources/tomcat-users.xml /usr/local/tomcat/conf

ADD target/docker-intro-1-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/

CMD ["catalina.sh", "run"]