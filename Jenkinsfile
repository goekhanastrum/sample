pipeline {
    agent any
    stages {
        stage('Build and Test') {
            steps {
                sh './mvnw clean test'
            }
        }
        stage('Code Quality Check') {
            steps {
                sh './mvnw checkstyle:check'
            }
        }
    }
}