pipeline {

    agent {
        label 'docker'
    }
    environment {

        CREDENTIALS = credentials('ARTIFACTORY_PASSWORD')
        email = "rutuja.n.arwade@lowes.com"
        projKey = "e-lbcb"
        repository =  "renohacks-api"
        api_repository = "e-dpiac-docker-local.docker.lowes.com/leap/workshop/${repository}"


    }
    stages {
        stage('Build and Test Application') {
          environment {
            MAVEN_OPTS="-Dmaven.repo.local=/lowes/m2/"
            }
            agent {
                docker {
                    reuseNode true
                    image 'e-dpiac-docker-local.docker.lowes.com/irs-image-jdk:13-alpine'
                    args '-v /home/jenkins/.m2:/lowes/m2/'
                }
            }
            steps {
                sh 'chmod +x mvnw'
                sh './mvnw --settings /lowes/m2/settings.xml package'
            }
        }
        stage('Docker Build and Push Image') {
            steps {
                script {
                    if(env.BRANCH_NAME == 'master'){
                        IMAGE_TAG = "${BRANCH_NAME}-${env.BUILD_ID}"
                        sh 'echo $CREDENTIALS > keyfile.json'
                        sh 'docker login -u carbon-rpm-key -p "$(cat keyfile.json)" https://e-dpiac-docker-local.docker.lowes.com'
                        sh "docker build . -t ${api_repository}:${IMAGE_TAG}"
                        sh "docker push ${api_repository}:${IMAGE_TAG}"
                    }
                }
            }
        }
}
        post {
          always {
            cleanWs()
            }
            failure {
                script {
                    mail (to: "${email}",
                            subject: "Job '${env.JOB_NAME}' (${env.BUILD_NUMBER}) failed.",
                            body: "Please visit ${env.BUILD_URL} for further information."
                    );
                }
            }
        }
}