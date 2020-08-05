// resources/pocs/pipelines/aws/Jenkinsfile-withAWS.groovy
pipeline {
    agent {
        kubernetes {
          containerTemplate {
            name 'aws-cli'
            image 'carlosrodlop/jenkins-slave-aws:e7c3999'
            ttyEnabled true
            }
        }
    }
    stages {
        stage('hello AWS') {
            steps {
                withAWS(credentials: 'support_vault_aws') { // Pre-requisite: 'support_vault_aws'
                    echo "Trying 'aws sts get-caller-identity'"
                    sh "aws sts get-caller-identity"
                    echo "Trying 'awsIdentity()'"
                    script {
                        def identity = awsIdentity()
                    }
                }
            }
        }
    }
}