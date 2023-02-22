package app.flux.api

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.util.AssertionErrors.assertEquals

@SpringBootTest
class ApplicationTests {

  @Test
  fun contextLoads() {
    assertEquals("Test","Test", "Test")
  }
}
