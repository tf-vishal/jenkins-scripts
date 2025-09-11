def call(String envName){
    withCredentials([
        file(credentialsId: envName}),
        variable: '${envName}_FILE'
    ])

    sh '''
    chmod -R u+@ ${envPath}
    cp "${${envName}_FILE}" ${envPath}.env
}