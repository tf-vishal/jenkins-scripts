def call(string id,string imageName){
    withCredentials([usernamePassword(
        Credentialsid:"${id}",
        passwordVar: "dockerHubpass"
        usernameVar: "dockerHubuser"
    )]){

        sh "docker login -u ${env.dockerHubuser} -p ${env.dockerHubpass}"
        sh "docker image tag ${imageName} ${env.dockerHubuser}/${imageName}"
        sh "docker push ${env.dockerHubuser}/${imageName}:latest"
    }
}