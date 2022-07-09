pipeline {
    agent any
    stages {
        stage('Run the playnook') {
            steps {
                sh 'cd $WORKSPACE && rm -rf *'
                sh 'git clone https://github.com/glendsoza/projCert.git'
                    sh 'ansible-playbook --inventory /tmp/inv $WORKSPACE/projCert/deploy-php.yaml --extra-vars "env=test build_tag=$BUILD_NUMBER"'
        }
                post { 
                    always { 
                        cleanWs() 
                }
            }
            }
        }
}
