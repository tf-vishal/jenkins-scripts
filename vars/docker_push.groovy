def call(String imageName) {
    withCredentials([usernamePassword(
        credentialsId: 'dockerhub',
        usernameVariable: 'DOCKER_USER',
        passwordVariable: 'DOCKER_PASS'
    )]) {
        sh """
        echo ' Logging in to DockerHub...'
        echo "${DOCKER_PASS}" | docker login --username "${DOCKER_USER}" --password-stdin

        echo ' Tagging image: ${imageName}:${BUILD_TAG}'
        docker tag ${imageName}:${BUILD_TAG} ${imageName}:${BUILD_TAG}

        echo ' Pushing image to DockerHub: ${imageName}:${BUILD_TAG}'
        docker push ${imageName}:${BUILD_TAG}

        echo '✅ Docker image pushed successfully!'
        """
    }
}
