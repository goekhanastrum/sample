pipeline {
    agent any
    stages {
        stage('Build and Test') {
            steps {
                bat 'mvnw.cmd clean test'
            }
        }
        stage('Code Quality Check') {
            steps {
                bat 'mvnw.cmd checkstyle:check'
            }
        }
    }
}