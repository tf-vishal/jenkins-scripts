def call(String imageName){
    def prevTag = (BUILD_TAG.toInteger()-1).toString()
    
    sh "docker compose down"
    sh "docker pull ${imageName}:${prevTag}"
    sh "sed -i 's/${BUILD_TAG}/${prevTag}/g' docker-compose.yml"
    sh "docker compose up -d"
}