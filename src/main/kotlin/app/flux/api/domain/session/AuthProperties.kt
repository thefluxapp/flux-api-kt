package app.flux.api.domain.session

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import java.security.KeyPairGenerator
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey

@Component
@ConfigurationProperties(prefix = "auth")
class AuthProperties {
    final var privateKey: RSAPrivateKey
    final var publicKey: RSAPublicKey

    init {
        val keyPairGenerator = KeyPairGenerator.getInstance("RSA")
        keyPairGenerator.initialize(2048)
        val keyPair = keyPairGenerator.generateKeyPair()

        privateKey = keyPair.private as RSAPrivateKey
        publicKey = keyPair.public as RSAPublicKey
    }
}
