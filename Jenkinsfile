pipeline {
    agent any

    environment {
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=false"
        TEAM_EMAIL = "karalegurudas@gmail.com"
    }

    stages {

        stage('Checkout') {
            steps {
                echo "Checking out code from SCM..."
                checkout scm
            }
        }

        stage('Set Up Environment') {
            steps {
                echo "Setting up Maven environment..."
                bat 'mvn -v'
            }
        }

        stage('Clean & Build') {
            steps {
                echo "Cleaning and compiling the project..."
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                echo "Running Selenium + Cucumber Tests..."
        
            catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
            bat 'mvn test'
                }
            }
        }

        stage('Publish Extent Report') {

             when {
                always() 
             }
            
            steps {
                echo "Publishing Extent HTML Report..."
                
                archiveArtifacts artifacts: 'target/ExtentReport/**', fingerprint: true

                
                publishHTML([
                    reportDir: 'target/ExtentReport',
                    reportFiles: 'Spark.html',
                    reportName: 'Extent Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: true
                ])
            }
        }
    }

    post {
        success {
            echo "Build succeeded. Sending notification..."
            emailext(
                to: "${TEAM_EMAIL}",
                subject: "✅ SUCCESS: Build #${BUILD_NUMBER} for ${JOB_NAME}",
                body: """
<html>
<body style="font-family:Arial,sans-serif;">
<h2 style="color:green;">✅ Build Successful!</h2>
<p>The Jenkins build <b>#${BUILD_NUMBER}</b> for <b>${JOB_NAME}</b> completed successfully.</p>
<p>
🔗 <b>Build URL:</b> <a href="${BUILD_URL}">${BUILD_URL}</a><br>
📁 <b>Extent Report:</b> Available under <b>Extent Report</b> in the Jenkins sidebar.<br>
📎 Also attached below.
</p>
<br>
<p>Regards,<br><b>Jenkins CI</b></p>
</body>
</html>
""",
                mimeType: 'text/html',
                from: "karalegurudas@gmail.com",
                replyTo: "karalegurudas@gmail.com",
                attachmentsPattern: 'target/extent-reports/*.html'
            )
        }

        failure {
            echo "Build failed. Sending notification..."
            emailext(
                to: "${TEAM_EMAIL}",
                subject: "❌ FAILED: Build #${BUILD_NUMBER} for ${JOB_NAME}",
                body: """
<html>
<body style="font-family:Arial,sans-serif;">
<h2 style="color:red;">❌ Build Failed!</h2>
<p>The Jenkins build <b>#${BUILD_NUMBER}</b> for <b>${JOB_NAME}</b> has failed.</p>
<p>
🔗 <b>Build URL:</b> <a href="${BUILD_URL}">${BUILD_URL}</a><br>
Please check the console logs or the Extent report for failed test details.
</p>
<br>
<p>Regards,<br><b>Jenkins CI</b></p>
</body>
</html>
""",
                mimeType: 'text/html',
                from: "karalegurudas@gmail.com",
                replyTo: "karalegurudas@gmail.com",
                attachmentsPattern: 'target/ExtentReport/*.html'
            )
        }

        always {
            echo "Cleaning workspace..."
            deleteDir()
        }
    }
}
