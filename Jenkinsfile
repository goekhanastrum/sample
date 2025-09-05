pipeline {
    agent any
    stages {
        stage('Build and Test') {
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw clean test -Dspring.profiles.active=ci'
            }
        }
        stage('Code Quality Check') {
            steps {
                sh './mvnw checkstyle:check -Dspring.profiles.active=ci'
            }
        }
    }
}