package io.github.henryssondaniel.teacup.protocol.http.node;

import static io.github.henryssondaniel.teacup.core.assertion.Factory.createBooleanAssert;
import static io.github.henryssondaniel.teacup.core.assertion.Factory.createByteArrayAssert;
import static io.github.henryssondaniel.teacup.core.assertion.Factory.createIntegerAssert;
import static io.github.henryssondaniel.teacup.core.assertion.Factory.createLongAssert;
import static io.github.henryssondaniel.teacup.core.assertion.Factory.createObjectArrayAssert;
import static io.github.henryssondaniel.teacup.core.assertion.Factory.createStringAssert;

import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.LongAssert;
import io.github.henryssondaniel.teacup.core.assertion.ObjectArrayAssert;
import java.security.Principal;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import org.junit.jupiter.api.Test;

class SslSessionTest {
  @Test
  void verify() throws SSLPeerUnverifiedException {
    GenericIntegerAssert<IntegerAssert> integerAssert = createIntegerAssert().isEqualTo(0);
    GenericLongAssert<LongAssert> longAssert = createLongAssert().isEqualTo(0L);
    GenericObjectArrayAssert<Object, ObjectArrayAssert> objectArrayAssert =
        createObjectArrayAssert().isEmpty();

    SSLSession sslSession = new TestExtendedSslSession();

    Factory.createSslSessionBuilder()
        .setApplicationBufferSize(integerAssert)
        .setCipherSuite(createStringAssert().isEqualTo("cipherSuite"))
        .setCreationTime(longAssert)
        .setId(createByteArrayAssert().isEmpty())
        .setLastAccessedTime(longAssert)
        .setLocalCertificates(objectArrayAssert)
        .setLocalPrincipal(
            Factory.createPrincipalBuilder()
                .setAssertion(
                    io.github.henryssondaniel.teacup.core.assertion.Factory
                        .<Principal>createObjectAssert()
                        .isSameAs(sslSession.getLocalPrincipal()))
                .build())
        .setPacketBufferSize(integerAssert)
        .setPeerCertificates(objectArrayAssert)
        .setPeerHost(createStringAssert().isEqualTo("peerHost"))
        .setPeerPort(integerAssert)
        .setPeerPrincipal(
            Factory.createPrincipalBuilder()
                .setAssertion(
                    io.github.henryssondaniel.teacup.core.assertion.Factory
                        .<Principal>createObjectAssert()
                        .isSameAs(sslSession.getPeerPrincipal()))
                .build())
        .setProtocol(createStringAssert().isEqualTo("protocol"))
        .setSessionContext(
            Factory.createSslSessionContextBuilder()
                .setAssertion(
                    io.github.henryssondaniel.teacup.core.assertion.Factory
                        .<SSLSessionContext>createObjectAssert()
                        .isSameAs(sslSession.getSessionContext()))
                .build())
        .setValid(createBooleanAssert().isFalse())
        .setValueNames(objectArrayAssert)
        .build()
        .verify(sslSession);
  }

  @Test
  void verifyWithError() {
    Factory.createSslSessionBuilder()
        .setPeerCertificates(createObjectArrayAssert().isSameAs(null))
        .setPeerPrincipal(
            Factory.createPrincipalBuilder()
                .setAssertion(
                    io.github.henryssondaniel.teacup.core.assertion.Factory
                        .<Principal>createObjectAssert()
                        .isSameAs(null))
                .build())
        .build()
        .verify(new ErrorExtendedSslSession());
  }
}
