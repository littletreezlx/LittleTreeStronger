import java.security.SecureRandom
import javax.net.ssl.*


class SSLSocketClient {




    //获取这个SSLSocketFactory
    fun getSSLSocketFactory(): SSLSocketFactory {
        try {
            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, getTrustManager(), SecureRandom())
            return sslContext.socketFactory
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    //获取TrustManager

    private fun getTrustManager(): Array<TrustManager> {
//        val trustManager = X509TrustManager()

        return arrayOf<TrustManager>(object: X509TrustManager {

            override fun checkClientTrusted(
                chain: Array<out java.security.cert.X509Certificate>?,
                authType: String?
            ) {
            }

            override fun checkServerTrusted(
                chain: Array<out java.security.cert.X509Certificate>?,
                authType: String?
            ) {
            }

            override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
                return arrayOf()
            }

            //            fun checkClientTrusted(
//                chain: Array<out X509Certificate>?,
//                authType: String?
//            ) {
//
//            }
//
//            fun checkServerTrusted(
//                chain: Array<out X509Certificate>?,
//                authType: String?
//            ) {
//
//            }
//
//
//            fun getAcceptedIssuers(): Array<X509Certificate> {
//                return arrayOf()
//            }

        }
        )
    }

    //获取HostnameVerifier
    fun getHostnameVerifier(): HostnameVerifier {
        return HostnameVerifier { s, sslSession -> true }
    }

}