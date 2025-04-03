def buildJar() {

    echo "building the application..."
    sh 'mvn package'

}

def buildAndPushDockerImage(){

    echo "buidling the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhublogin', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh 'docker build -t chisom444/demo-images:jma-3.0 .'
    sh 'echo $PASS | docker login -u $USER --password-stdin'
    sh 'docker push chisom444/demo-images:jma-3.0'

    }

}


def deployApp() {

echo "Deploying the application"

}




return this