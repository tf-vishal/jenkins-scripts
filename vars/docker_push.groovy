def call(String imageName) {
    withCredentials([usernamePassword(
        credentialsId: "dockerhub",
        passwordVariable: "dockerHubPass",
        usernameVariable: "dockerHubUser"
    )]) {
        sh "echo '🔑 Logging in to DockerHub...'"
        sh "echo '${dockerhubPass}' | docker login --username '${dockerhubUser}' --password-stdin"

        sh "echo '🏷️ Tagging image: ${imageName}'"
        sh "docker image tag ${imageName} ${env.dockerHubUser}/${imageName}:${BUILD_TAG}"

        sh "echo '📤 Pushing image to DockerHub. ${imageName} ${env.dockerHubUser}/${imageName}:${BUILD_TAG}"

        sh "echo '📤 Pushing image to DockerHub...'"
        sh "docker push ${env.dockerHubUser}/${imageName}:${BUILD_TAG}"

        sh "echo '✅ Docker image pushed succes..'"
        sh "docker push ${env.dockerHubUser}/${imageName}:${BUILD_TAG}"


    }
}
