cmake_minimum_required(VERSION 3.18.1)
project("ndklib")
add_library(
        ndklib
        SHARED
        ndk-wrapper.cpp)

find_library(
        log-lib
        log)

add_library(
        shared
        SHARED
        IMPORTED)

set_property(
        TARGET
        shared
        PROPERTY
        IMPORTED_LOCATION
        "${CMAKE_CURRENT_SOURCE_DIR}/libs/${ANDROID_ABI}/libshared.so"
)

include_directories("${CMAKE_CURRENT_SOURCE_DIR}/libs/${ANDROID_ABI}")

target_link_libraries(
        ndklib
        ${log-lib}
        shared
)
