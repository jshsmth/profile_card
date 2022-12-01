package com.example.profile_card

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform