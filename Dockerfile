# Usar una imagen base de Amazon Corretto
FROM amazoncorretto:21-alpine-jdk

# Copiar el código fuente y el script mvnw al contenedor
COPY . /app

# Establecer el directorio de trabajo
WORKDIR /app

# Dar permisos de ejecución al script mvnw
RUN chmod +x mvnw

# Ejecutar Maven para compilar el proyecto
RUN ./mvnw clean package -DskipTests

# Exponer el puerto 8080
EXPOSE 8080

# Ejecutar la aplicación
CMD ["java", "-jar", "target/currecyapp-0.0.1-SNAPSHOT.jar"]
