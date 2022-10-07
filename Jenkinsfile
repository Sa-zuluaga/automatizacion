pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                bat 'gradlew.bat clean build -x test'
            }
        }
        stage('test-chrome') catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE'){
            steps {
                bat "gradlew.bat test -Dcontext=chrome -Dwebdriver.driver=chrome"

            }
        }
        stage('test-firefox') catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE'){
            steps {
                bat "gradlew.bat test -Dcontext=firefox -Dwebdriver.driver=firefox"

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