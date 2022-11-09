// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    with(com.epilepticcat.buildsrc.Versions) {
        id("com.android.application") version agp apply false
        id("com.android.library") version agp apply false
        id("org.jetbrains.kotlin.android") version kotlin apply false
        id("org.jetbrains.kotlin.jvm") version kotlin apply false
    }
}
