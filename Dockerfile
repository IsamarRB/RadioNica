# Usa una imagen base con Maven para construir el archivo .war
FROM maven:3.8.5-openjdk-17 AS builder

# Establece el directorio de trabajo para la construcción
WORKDIR /app

# Copia los archivos necesarios para la construcción
COPY pom.xml .
RUN mvn dependency:resolve

# Copia el resto de los archivos del proyecto
COPY . .

# Construye el archivo .war
RUN mvn package

# Usa una imagen base de Tomcat para ejecutar el archivo .war
FROM tomcat:9.0

# Configura el directorio de trabajo en Tomcat
WORKDIR /usr/local/tomcat/webapps

# Copia el archivo .war generado por Maven al directorio de despliegue de Tomcat
COPY --from=builder /app/target/radionica-1.0-SNAPSHOT.war ROOT.war

# Expone el puerto de Tomcat
EXPOSE 8080

# Inicia Tomcat
CMD ["catalina.sh", "run"]
