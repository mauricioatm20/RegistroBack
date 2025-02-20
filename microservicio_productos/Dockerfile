# Usa una imagen oficial de Java como base
FROM openjdk:21-jdk-slim

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de tu aplicación al contenedor
COPY target/microservicio_productos-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que corre la aplicación
EXPOSE 8084

# Configurar las variables de entorno para la conexión a la base de datos
ENV SPRING_APPLICATION_NAME=microservicio_productos \
    SPRING_DATASOURCE_URL=jdbc:mysql://mysql-ecomerce.cj4k2kme62ll.eu-north-1.rds.amazonaws.com:3306/market \
    SPRING_DATASOURCE_USERNAME=root \
    SPRING_DATASOURCE_PASSWORD=root1234.p \
    SERVER_PORT=8084

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
