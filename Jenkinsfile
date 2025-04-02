pipeline {
    agent any

    tools {
        jdk 'JDK21'
    }

    environment {
        JAVA_HOME = "${tool 'JDK21'}"
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
                bat 'echo Using Java Home: %JAVA_HOME%'
                bat 'java -version'
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
            junit '**/build/test-results/test/*.xml'
        }
    }
}
