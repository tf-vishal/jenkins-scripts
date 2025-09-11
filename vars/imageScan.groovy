def call(String imageName, String tag){
    echo "SCANNING ${imageName} FOR VULNERABILITUES"
    sh "trivy image --exit-code 1 --severity LOW $(imageName)"
}