package netware.client.extensions

@Suppress("unused")
class RequestHeaders {

    private val headerList = mutableMapOf<String, String>()

    fun add(key: String, value: String) {
        headerList[key] = value
    }

    fun getHeaders() = headerList
}