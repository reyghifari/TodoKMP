package id.raihan.todokmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform