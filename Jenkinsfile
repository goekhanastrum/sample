pipeline {
    agent any
    stages {
        stage('Checkout from Repo') {
            steps {
                git 'https://your-git-repo-url'
            }
        }
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