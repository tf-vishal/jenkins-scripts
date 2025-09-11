def call(String imageName){
    sh "docker compose down"
    sh "docker pull ${imageName}:${BUILD_TAG}"
    sh "docker compose up -d "
    sh "rm -f ${FRONTEND_PATH}.env ${BACKEND_PATH}.env"
}