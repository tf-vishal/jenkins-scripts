def call(String imageName){
    withCredentials([usernamePassword(
        credentialsId: 'dockerhub',
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )])

    sh """
        echo ' Logging in to DockerHub...'
        echo "${DOCKER_PASS}" | docker login --username "${DOCKER_USER}" --password-stdin

        docker rmi {imageName}:${BUILD_TAG} || true
}