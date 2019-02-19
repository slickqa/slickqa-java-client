pipeline {
    agent {
        docker {
            image 'maven:3.6-jdk-8'
            args '-v /data/docker/maven:/.m2'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh '''
                    export MAVEN_OPTS="-Dmaven.repo.local=/.m2/repository -Duser.home=/"
                    POM_BUILD_NUMBER=${BUILD_NUMBER}
                    if [ "$BRANCH_NAME" != "master" ]; then POM_BUILD_NUMBER="${BRANCH_NAME}-${BUILD_NUMBER}"; fi

                    ORIGINAL_VERSION=$(mvn -q -DforceStdout help:evaluate -Dexpression='project.version')
                    NEW_VERSION=$(echo ${ORIGINAL_VERSION} | sed -e "s/SNAPSHOT/${POM_BUILD_NUMBER}/")

                    mvn -Dmaven.repo.local=/.m2/repository -B versions:set -DnewVersion=${NEW_VERSION}
                    mvn -q -DforceStdout help:evaluate -Dexpression='settings.localRepository' && echo
                '''
                sh '''
                    export MAVEN_OPTS="-Dmaven.repo.local=/.m2/repository -Duser.home=/"
                    mvn -B -DskipTests clean package
                '''
            }
        }
        stage('Test') { 
            steps {
                sh '''
                    export MAVEN_OPTS="-Dmaven.repo.local=/.m2/repository -Duser.home=/"
                    mvn -Dmaven.repo.local=/.m2/repository test
                ''' 
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
    }
}
