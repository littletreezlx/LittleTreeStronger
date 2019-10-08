package com.example.littletreestronger.common.util

import android.content.Context
import com.bumptech.glide.Glide
import java.io.IOException
import java.security.*
import java.security.cert.CertificateException
import java.security.cert.CertificateFactory
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory


fun getSLLContext(context: Context): SSLContext? {
    var sslContext: SSLContext? = null
    try {
        val certificateFactory = CertificateFactory.getInstance("X.509")
//        X.509
//        PKCS12
        val certificate = context.getAssets().open("keystore.p12")
        val keyStore = KeyStore.getInstance(KeyStore.getDefaultType())
        keyStore.load(null)
        val certificateAlias = Integer.toString(0)
        keyStore.setCertificateEntry(
            certificateAlias,
            certificateFactory.generateCertificate(certificate)
        )
        sslContext = SSLContext.getInstance("TLS")
        val trustManagerFactory =
            TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        trustManagerFactory.init(keyStore)
        sslContext!!.init(null, trustManagerFactory.getTrustManagers(), SecureRandom())
    } catch (e: CertificateException) {
        e.printStackTrace()
    } catch (e: KeyStoreException) {
        e.printStackTrace()
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    } catch (e: IOException) {
        e.printStackTrace()
    } catch (e: KeyManagementException) {
        e.printStackTrace()
    }
    return sslContext
}
