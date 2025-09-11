def call(String envName, String envPath) {
    withCredentials([
        file(credentialsId: envName, 
        variable: 'ENV_FILE')
    ]) {
        sh """
            chmod -R u+w ${envPath}
            cp "${ENV_FILE}" ${envPath}/.env
            ls -l ${envPath}/.env
        """
    }
}
