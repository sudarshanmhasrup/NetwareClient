package netware.client.extensions

import com.google.gson.Gson

object Serializer {
    @JvmStatic
    fun serialize(dataClass: Any?): String {
        return try {
            Gson().toJson(dataClass)
        } catch (exception: Exception) {
            "Cannot serialize the provide data class due to: $exception"
        }
    }
}