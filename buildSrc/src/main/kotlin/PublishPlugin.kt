import com.android.build.api.dsl.LibraryExtension
import com.android.build.api.variant.AndroidComponentsExtension
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication

/**
 * 发布应用的插件
 */
abstract class PublishPlugin : Plugin<Project> {

    val VERSION = latestGitTag().ifEmpty { Config.versionName }

    override fun apply(project: Project) {
        project.plugins.apply("maven-publish")

        // 1：注册一个release类型的发布信息
//        registerPublishType(project)

        // 在从构建文件对DSL对象进行评估之后，以及在构建过程的后续步骤(如变体或任务创建)中使用之前，以编程方式自定义DSL对象的API。
//        val androidComponents = project.extensions.getByType(AndroidComponentsExtension::class.java)
//        androidComponents.finalizeDsl { extension ->
//            // 2: 获取model的名字
//            val modelName = getModelNameForNamespace(extension.namespace)
//            println("> Task :[modelName] :${modelName}")
//            // 3: 发布
//            publishTask(project, modelName)
//        }

        publishTask(project, "modelName")
    }

    /**
     * 注册一个release的发布类型
     */
    private fun registerPublishType(project: Project) {
        // LibraryExtension.android
        project.extensions.getByType(LibraryExtension::class.java)
            .apply {
                // 1：注册publishing.release
                publishing {
                    singleVariant("release") {
                        withSourcesJar()
                        withJavadocJar()
                        println("> Task :[register:release] success! ")
                    }
                }
            }
    }

    /**
     * 获取model的name
     */
    private fun getModelNameForNamespace(nameSpace: String?): String {
        var result = "default"
        nameSpace?.let {
            if (it.contains(".")) {
                result = it.split(".")
                    .reversed()
                    .first()
            }
        }
        return result
    }

    /**
     * 如果要使用：PublishingExtension扩展属性的话，必须要依赖于这个插件
     *   plugins {
     *     id "maven-publish"
     *   }
     */
    private fun publishTask(project: Project, modelName: String) {
        project.extensions.getByType(PublishingExtension::class.java)
            .apply {
                // 发布内容
                this.publications {
                    create("release", MavenPublication::class.java, object : Action<MavenPublication> {
                        override fun execute(it: MavenPublication) {
                            it.groupId = "com.android" // 组的名字
                            it.artifactId = modelName // 插件名称
                            it.version = VERSION // 版本号

                            // 在所有的配置都完成之后执行
                            project.afterEvaluate {
                                // 从当前 module 的 release 包中发布
                                it.from(components.getByName("release"))
                                println("> Task :[publish:release] success!")
                            }
                        }
                    })
                }
            }
    }

    /**
     * 获取 git 仓库中最新的 tag作为版本号
     */
    private fun latestGitTag(): String {
        val process = ProcessBuilder("git", "describe", "--tags", "--abbrev=0").start()
        return process.inputStream.bufferedReader()
            .use { bufferedReader ->
                bufferedReader.readText()
                    .trim()
            }
    }
}