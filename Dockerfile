# Usa una imagen base con OpenJDK
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo de configuración de Maven (si usas Maven)
COPY pom.xml .

# Descarga las dependencias del proyecto
RUN apt-get update && apt-get install -y maven && mvn dependency:resolve

# Copia el resto de los archivos del proyecto al contenedor
COPY src ./src

# Compila el proyecto
RUN mvn package

# Define el puerto en el que la aplicación se ejecutará
ENV PORT=8080

# Expone el puerto para que esté accesible desde fuera del contenedor
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "target/nombre-del-archivo.jar"]
