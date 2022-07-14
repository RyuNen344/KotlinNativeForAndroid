cmake_minimum_required(VERSION 3.18.1)
project("android")
add_library(
        android
        SHARED
        shared-wrapper.cpp)

#find_library(
#        libshared
#        shared)
#
#target_link_libraries(
#        hogehoge
#        ${libshared})
