cmake_minimum_required(VERSION 3.18.1)
project("ndklib")
add_library(
        ndklib
        SHARED
        ndk-wrapper.cpp)

find_library(
        log-lib
        log)

target_link_libraries(
        ndklib
        ${log-lib})

add_library(
        shared
        SHARED
        IMPORTED)
