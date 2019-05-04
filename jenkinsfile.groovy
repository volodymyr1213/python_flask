ndoe {
    properties([parameters([string(defaultValue: 'IP', description: 'Please give IP to build a site', name: 'IP', trim: true)])])
    stage ("Clone Repo"){
        git 'https://github.com/volodymyr1213/Flaskex.git'
    }
    stage ("Built application")
        sh "scr -r * ec2-user@${ENV}:/tmp"
        sh "scr -r * ec2-user@${ENV} pip install -r /tmp/requirements.txt"
    }
    stage ("App Run")
        sh "scr -r * ec2-user@${ENV} python /tmp/app.py"
    }     
}
