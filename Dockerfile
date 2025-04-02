# Usar la imagen oficial de Tomcat 9
FROM tomcat:9.0

# Copiar el archivo WAR generado al directorio webapps de Tomcat
COPY target/tu-aplicacion.war /usr/local/tomcat/webapps/

# Exponer el puerto 8080 para que Render pueda acceder a la app
EXPOSE 8080

# Iniciar Tomcat cuando el contenedor se ejecute
CMD ["catalina.sh", "run"]
