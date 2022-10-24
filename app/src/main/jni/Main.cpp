
#include <pthread.h>
#include <jni.h>
#include <unistd.h>
#include "Logger.h"

//Serve Do Painel
extern "C" JNIEXPORT jstring
JNICALL
Java_com_calora_login_Auth_Title(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF(("https://yournameserver.000webhostapp.com/login.php"));
}


//Nome Da Equipe
extern "C" JNIEXPORT jstring
JNICALL
Java_com_calora_login_MainActivity_team(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF(("PsTeam"));
}


//Grupo Do Telegram
extern "C" JNIEXPORT jstring
JNICALL
Java_com_calora_login_MainActivity_Grupo(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF(("WhatsApp Channel Oficial"));
}

//Grupo Do Telegram
extern "C" JNIEXPORT jstring
JNICALL
Java_com_calora_login_MainActivity_LinkGrupo(JNIEnv *env, jobject thiz) {
    return env->NewStringUTF(("https://chat.whatsapp.com/GikyZutq2lc7ajrz5RZtex"));
}


