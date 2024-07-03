pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', credentialsId: 'f22013b5-5da4-43d6-bb6a-a0113def43ee', url: 'https://github.com/Yashwanthraomakthe/TestAutomationFrameworkHomeTask.git'
            }
        }
        
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        
        stage('Archive') {
            steps {
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
        
        stage('Results') {
            steps {
                sh 'mvn test'
                junit '**/target/surefire-reports/*.xml'
            }
        }
    }
}