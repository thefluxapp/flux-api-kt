package app.flux.api.domain.session

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component
import java.security.KeyPairGenerator
import java.security.interfaces.RSAPrivateKey

@Component
@ConfigurationProperties(prefix = "auth")
class AuthProperties {
  final var privateKey: RSAPrivateKey = generateDefaultPrivateKey()

  private fun generateDefaultPrivateKey (): RSAPrivateKey {
    val kpg = KeyPairGenerator.getInstance("RSA")

    kpg.initialize(2048)
    return kpg.generateKeyPair().private as RSAPrivateKey
  }
}