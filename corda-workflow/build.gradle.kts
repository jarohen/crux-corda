plugins {
    kotlin("jvm")
    id("dev.clojurephant.clojure")
    id("net.corda.plugins.cordapp")
    id("net.corda.plugins.quasar-utils")
}

val cordaGroup = "net.corda"
val cordaVersion = "4.5"

cordapp {
    workflow {
        targetPlatformVersion = 4
        minimumPlatformVersion = 4
    }
}

dependencies {
    implementation("org.clojure", "clojure", "1.10.0")
    implementation("juxt", "crux-core", "20.09-1.11.0-beta")
    implementation ("com.h2database", "h2", "1.4.199")

    cordaCompile(cordaGroup, "corda-core", cordaVersion)
    cordaCompile(cordaGroup, "corda-jackson", cordaVersion)
    cordaCompile(cordaGroup, "corda-rpc", cordaVersion)
    cordaRuntime(cordaGroup, "corda", cordaVersion)
    cordapp(project(":corda-contract"))
}

