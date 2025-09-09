def call(String url, String branch){
    git url: "${url}", branch: "${branch}"
    echo "✅ Git cloned successfully! from ${url}(branch: ${branch})" 
}
