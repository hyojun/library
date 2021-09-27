FROM adoptopenjdk/openjdk11
COPY build/libs/*.jar ./library.jar
ENTRYPOINT ["java", "-jar", "library.jar", "-DLIBRARY_NAME=\"$LIBRARY_NAME\""]
