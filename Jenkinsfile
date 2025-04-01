pipeline {
    agent any

    tools {
        // Вказання версії JDK
        jdk 'JDK 11'
        // Якщо використовуєте Maven
        maven 'Maven 3.8.1'
        // Або якщо використовуєте Gradle
        // gradle 'Gradle 7.4'
    }

    stages {
        stage('Checkout') {
            steps {
                // Клонування репозиторію
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Для Maven
                sh 'mvn clean compile'
                // Або для Gradle
                // sh 'gradle clean build'
            }
        }

        stage('Test') {
            steps {
                // Для Maven
                sh 'mvn test'
                // Або для Gradle
                // sh 'gradle test'
            }
        }
    }

    post {
        always {
            // Публікація результатів JUnit тестів
            junit '**/target/surefire-reports/*.xml'
            // Або для Gradle
            // junit '**/build/test-results/test/*.xml'
        }
    }
}