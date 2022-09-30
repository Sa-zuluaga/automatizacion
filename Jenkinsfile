pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                bat 'gradlew.bat clean build -x test'
            }
        }
        stage('test-chrome') {
            steps {
                {
                    bat "gradlew.bat test -Dcontext=chrome -Dwebdriver.driver=chrome -Denvironment=${params.ENV}"
                }
            }
        }
        stage('test-firefox') {
            steps {
                {
                    bat "gradlew.bat test -Dcontext=firefox -Dwebdriver.driver=firefox -Denvironment=${params.ENV}"
                }
            }
        }
        stage('aggregate') {
            steps {
                bat 'gradlew.bat aggregate'
            }
        }
        stage('publish report'){
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'target/site/serenity',
                    reportFiles: 'index.html',
                    reportName: 'SerenityBDD',
                    reportTitles: ''
                ])
            }
        }
    }
}