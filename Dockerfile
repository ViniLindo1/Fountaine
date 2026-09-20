FROM tomcat:11-jdk21-temurin-jammy
COPY dist/*.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
