def gv

pipeline {   
    agent any

    tools{
        maven 'maven-3.9'
        }

stages{
    
        stage("build jar") {
            steps {
                script {
                    gv = load 'script.groovy'
                    gv.buildJar()
                }
            }
        }

        stage("build docker image") {
            steps {
                script {

                    gv.buildAndPushDockerImage()
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    gv.deployApp()

                }
            }
        }               
    }

}