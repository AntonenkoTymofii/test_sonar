pipeline {
    agent any

    tools {
        jdk 'JDK 21'
        gradle 'Gradle 8.10.2'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'gradle clean build'
            }
        }

        stage('Test') {
            steps {
                sh 'gradle test'
            }
        }
    }

    post {
        always {
            junit '**/build/test-results/test/*.xml'
        }
    }
}