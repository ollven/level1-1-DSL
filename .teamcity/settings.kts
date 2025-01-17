import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2024.03"

project {

    vcsRoot(HttpsGithubComOllvenLevel11refsHeadsMain)
    vcsRoot(HttpsGithubComOllvenLevel11refsHeadsMain1)

    buildType(Build2)
    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(HttpsGithubComOllvenLevel11refsHeadsMain1)
    }

    steps {
        script {
            id = "simpleRunner"
            scriptContent = "pwd"
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})

object Build2 : BuildType({
    name = "Build2"

    vcs {
        root(HttpsGithubComOllvenLevel11refsHeadsMain)
    }

    steps {
        script {
            id = "simpleRunner"
            scriptContent = "pwd"
        }
    }
})

object HttpsGithubComOllvenLevel11refsHeadsMain : GitVcsRoot({
    name = "https://github.com/ollven/level1-1#refs/heads/main"
    url = "https://github.com/ollven/level1-1"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "ollven"
        password = "credentialsJSON:c6fc6010-81fc-4566-a6a2-0833552ebdcd"
    }
})

object HttpsGithubComOllvenLevel11refsHeadsMain1 : GitVcsRoot({
    name = "https://github.com/ollven/level1-1#refs/heads/main (1)"
    url = "https://github.com/ollven/level1-1"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    checkoutSubmodules = GitVcsRoot.CheckoutSubmodules.IGNORE
    authMethod = password {
        userName = "ollven"
        password = "credentialsJSON:c6fc6010-81fc-4566-a6a2-0833552ebdcd"
    }
})
