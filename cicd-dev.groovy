node('linux')
{
  stage ('Poll') {
    checkout([
      $class: 'GitSCM',
      branches: [[name: '*/main']],
      doGenerateSubmoduleConfigurations: false,
      extensions: [],
      userRemoteConfigs: [[url: 'https://github.com/zopencommunity/hexcurseport.git']]])
  }
  stage('Build') {
    build job: 'Port-Pipeline', parameters: [string(name: 'PORT_GITHUB_REPO', value: 'https://github.com/zopencommunity/hexcurseport.git'), string(name: 'PORT_DESCRIPTION', value: 'Hexcurse is a ncurses-based console hexeditor written in C' ), string(name: 'BUILD_LINE', value: 'DEV') ]
  }
}
