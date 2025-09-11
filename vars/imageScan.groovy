def call(String imageName){
    echo "SCANNING ${imageName} FOR VULNERABILITUES"
    sh "trivy image --exit-code 1 --severity LOW ${imageName}"
}