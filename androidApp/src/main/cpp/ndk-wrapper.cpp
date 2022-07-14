#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_ryunen344_kotlin_android_android_NdkWrapper_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
