pipeline {
    agent any

    tools {
        maven "Maven_Local"
    }

    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Oganzi01/DemoQA_POM.git', branch: 'master'
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    if (fileExists('mvnw')) {
                        sh 'chmod +x mvnw'
                        sh './mvnw clean test'
                    } else {
                        sh 'mvn clean test'
                    }
                }
            }
        }
    }

    post {
        always {
            // Удаляем проблемный GitHubCommitStatusSetter
            // Вместо него добавляем сбор отчетов JUnit, чтобы Jenkins рисовал графики
            junit '**/target/surefire-reports/*.xml'

            echo 'Билд завершен, отчеты собраны.'
        }
        success {
            echo 'Ура! Все тесты прошли успешно.'
        }
        failure {
            echo 'Тесты упали. Проверь логи и состояние сайта DemoQA.'
        }
    }
}