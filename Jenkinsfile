def gv

pipeline {   
    agent any

    tools{
        maven 'maven-3.9'
    
    }

    
        stage("build jar") {
            steps {
                script {
                    echo "building the application..."
                    sh 'mvn package'

                }
            }
        }

        stage("build docker image") {
            steps {
                script {
                    echo "buidling the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'dockerhublogin', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t 'chisom444/demo-images:jma-2.0' .'
                        sh 'echo $PASS | docker login -u $USER --password-stdin'
                        sh 'docker push chisom444/demo-images:jma-2.0'
                    

                    }

                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    echo "Deploying the application"
                }
            }
        }               
    }