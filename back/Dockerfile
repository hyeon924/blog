# Java 17 기반 이미지 사용
FROM eclipse-temurin:17-jdk

# 작업 디렉토리 생성
WORKDIR /app

# 빌드된 jar 파일 복사
COPY build/libs/blog-0.0.1-SNAPSHOT.jar app.jar

# 외부에서 8080 포트 접근 가능하게
EXPOSE 8080

# 애플리케이션 실행 명령
ENTRYPOINT ["java", "-jar", "app.jar"]
