# Usar una imagen base de Maven para depuración
FROM maven:3.9.4-eclipse-temurin-21 AS builder

# Copiar el código fuente al contenedor
COPY . /app

# Establecer el directorio de trabajo
WORKDIR /app

# Ejecutar Maven para compilar el proyecto
RUN mvn clean package -DskipTests

# Usar una imagen base de Amazon Corretto para el runtime
FROM amazoncorretto:21-alpine-jdk

# Copiar el JAR construido del contenedor builder
COPY --from=builder /app/target/currecyapp-0.0.1-SNAPSHOT.jar /currency_webapp.jar

# Exponer el puerto 8080
EXPOSE 8080

# Copiar el JAR a un directorio accesible
RUN mkdir /app && cp /currency_webapp.jar /app/

# Usar una imagen interactiva para depuración
ENTRYPOINT ["sh"]
