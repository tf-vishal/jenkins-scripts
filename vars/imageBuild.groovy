def call(String imageName, String context) {
    echo "Building ${imageName}:${BUILD_TAG} from ${context}"
    sh "docker build -t ${imageName}:${BUILD_TAG} ${context}"
}
