pipeline {
  agent any
  stages {
    stage('Build Jar') {
      agent any
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }

    stage('Build Image') {
      agent any
      steps {
        sh 'docker build -t=\'sahilmutreja/audibene-test\' .'
      }
    }

    stage('Push Image') {
      agent any
      environment {
        credentialsId = 'dockerhub'
        passwordVariable = 'pass'
        usernameVariable = 'user'
      }
      steps {
        withCredentials(bindings: [usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
          sh "docker login --username=${user} --password=${pass}"
          sh "docker push sahilmutreja/audibene-test:${BUILD_NUMBER}"
          sh 'docker push sahilmutreja/audibene-test:latest'
        }

      }
    }

  }
}