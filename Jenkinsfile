pipeline{
    agent any
    stages{
        stage('Jenkis Classroom'){
            steps{
                echo 'Jankins classroom interface'
            }
        }
        stage('Build Interface'){
            steps{
                build job: 'store.classroom', wait: true
            }
        }

        stage('Build'){
            steps{
                sh 'mvn clean package'
            }
        }

        stage('Build Image'){

            steps{
                script{
                    classroom = docker.build("c0d8/classroom:${env.BUILD_ID}", "-f Dockerfile .")
                }
            }

        }

        stage('Push Image'){
            steps{
                script{
                    docker.withRegistry('https://registry.hub.docker.com', 'dockerhub-credential'){
                        classroom.push("${env.BUILD_ID}")
                        classroom.push("latest")
                    }
                }
            }
        }
       
    }
}