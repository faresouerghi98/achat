pipeline {
    agent any


    stages {
        stage('GIT') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'wissem',
                url: 'https://github.com/faresouerghi98/achat.git'
            }
        }
        stage('MVN CLEAN') {
            steps {
                // Get some code from a GitHub repository
                sh 'mvn clean'
            }
        }
        
         stage('MVN COMPILE') {
            steps {
                // Get some code from a GitHub repository
                sh 'mvn  compile'
            }
        }
        stage('SONARQUBE') {
            steps {
                // Get some code from a GitHub repository
              // You can override the credential to be used
                sh 'mvn sonar:sonar -Dsonar.projectKey=achat -Dsonar.host.url=http://192.168.1.118/:9000 -Dsonar.login=ead050293b8944807e773e4b00d909803730dd11'
    
            }
        }
        
        stage('JUNIT/MOCKITO') {
            steps {
                // Get some code from a GitHub repository
                sh 'mvn test'
            }
        }
          stage('NEXUS') {
            steps {
                // Get some code from a GitHub repository
                sh 'mvn deploy'
            }
        }
       
        
    }
}