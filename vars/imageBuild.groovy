def call(String imageName, String context, String tag){
    echo "Building ${imageName}:${tag} from ${context}"
    sh "docker build -t {imageName}:{tag} ${context}"
}