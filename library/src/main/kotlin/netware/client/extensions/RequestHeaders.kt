package netware.client.extensions

// Extension class for easy header implementation
@Suppress("unused")
class RequestHeaders {

    private val headerList = mutableMapOf<String, String>()

    fun add(key: String, value: String): RequestHeaders {
        headerList[key] = value
        return this
    }

    fun getHeaders() = headerList
}