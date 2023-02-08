pipeline {
  agent any
  stages {
    stage('Build Jar') {
      steps {
        sh 'mvn clean package -DskipTests'
      }
    }

    stage('Build Image') {
      steps {
        sh 'docker build -t=\'sahilmutreja/audibene-test\' .'
      }
    }

    stage('Push Image') {
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