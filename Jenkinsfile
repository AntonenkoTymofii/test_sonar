pipeline {
    agent any

    tools {
        jdk 'JDK17'
    }

    environment {
        JAVA_HOME = "${tool 'JDK17'}"
        PATH = "${JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'gradlew.bat clean build'
            }
        }

        stage('Test') {
            steps {
                catchError(buildResult: 'UNSTABLE', stageResult: 'FAILURE') {
                    bat 'gradlew.bat test'
                }
            }
        }
    }

    post {
        always {
            junit '**/build/test-results/test/*.xml' // Исправлен путь
        }
    }
}
