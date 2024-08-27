# Etapa de construcción
FROM amazoncorretto:21-alpine-jdk AS build

# Instalar Maven
RUN apk add --no-cache maven

# Copiar el código fuente y el script mvnw al contenedor
COPY . /app

# Establecer el directorio de trabajo
WORKDIR /app

# Dar permisos de ejecución al script mvnw
RUN chmod +x mvnw

# Ejecutar Maven para compilar el proyecto
RUN ./mvnw clean package -DskipTests

# Etapa de ejecución
FROM amazoncorretto:21-alpine-jdk

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el JAR generado desde la etapa de construcción
COPY --from=build /app/target/currencywebapp-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto 8080 (o el puerto definido por la variable de entorno PORT)
EXPOSE 8080

# Ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
