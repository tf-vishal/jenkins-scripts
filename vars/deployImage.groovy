def call(String imageName){
    sh "docker compose down"
    sh "fuser -k 8080/tcp || true "
    sh "fuser -k 3000/tcp || true "
    sh "docker pull ${imageName}:${BUILD_TAG}"
    sh "docker compose up -d "
    sh "rm -f ${FRONTEND_PATH}.env ${BACKEND_PATH}.env"
}