package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericByteArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.LongAssert;
import io.github.henryssondaniel.teacup.core.assertion.StringAssert;
import java.security.cert.Certificate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SslSessionBuilderImplTest {
  private final GenericIntegerAssert<?> genericIntegerAssert = mock(IntegerAssert.class);
  private final GenericLongAssert<?> genericLongAssert = mock(LongAssert.class);
  private final GenericStringAssert<?> genericStringAssert = mock(StringAssert.class);
  private final Principal principal = mock(Principal.class);
  @InjectMocks private final SslSessionBuilder sslSessionBuilder = new SslSessionBuilderImpl();

  @Mock private GenericObjectArrayAssert<? super Certificate, ?> genericObjectArrayAssert;
  @Mock private GenericObjectArrayAssert<? super String, ?> genericStringArrayAssert;
  @Mock private SslSessionSetter implementation;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createImplementation() {
    assertThat(new SslSessionBuilderImpl().createImplementation())
        .isExactlyInstanceOf(SslSessionImpl.class);
  }

  @Test
  void setApplicationBufferSize() {
    assertThat(sslSessionBuilder.setApplicationBufferSize(genericIntegerAssert))
        .isSameAs(sslSessionBuilder);
    verify(implementation).setApplicationBufferSize(genericIntegerAssert);
  }

  @Test
  void setCipherSuite() {
    assertThat(sslSessionBuilder.setCipherSuite(genericStringAssert)).isSameAs(sslSessionBuilder);
    verify(implementation).setCipherSuite(genericStringAssert);
  }

  @Test
  void setCreationTime() {
    assertThat(sslSessionBuilder.setCreationTime(genericLongAssert)).isSameAs(sslSessionBuilder);
    verify(implementation).setCreationTime(genericLongAssert);
  }

  @Test
  void setId() {
    var genericByteArrayAssert = mock(GenericByteArrayAssert.class);

    assertThat(sslSessionBuilder.setId(genericByteArrayAssert)).isSameAs(sslSessionBuilder);
    verify(implementation).setId(genericByteArrayAssert);
  }

  @Test
  void setLastAccessedTime() {
    assertThat(sslSessionBuilder.setLastAccessedTime(genericLongAssert))
        .isSameAs(sslSessionBuilder);
    verify(implementation).setLastAccessedTime(genericLongAssert);
  }

  @Test
  void setLocalCertificates() {
    assertThat(sslSessionBuilder.setLocalCertificates(genericObjectArrayAssert))
        .isSameAs(sslSessionBuilder);
    verify(implementation).setLocalCertificates(genericObjectArrayAssert);
  }

  @Test
  void setLocalPrincipal() {
    assertThat(sslSessionBuilder.setLocalPrincipal(principal)).isSameAs(sslSessionBuilder);
    verify(implementation).setLocalPrincipal(principal);
  }

  @Test
  void setPacketBufferSize() {
    assertThat(sslSessionBuilder.setPacketBufferSize(genericIntegerAssert))
        .isSameAs(sslSessionBuilder);
    verify(implementation).setPacketBufferSize(genericIntegerAssert);
  }

  @Test
  void setPeerCertificates() {
    assertThat(sslSessionBuilder.setPeerCertificates(genericObjectArrayAssert))
        .isSameAs(sslSessionBuilder);
    verify(implementation).setPeerCertificates(genericObjectArrayAssert);
  }

  @Test
  void setPeerHost() {
    assertThat(sslSessionBuilder.setPeerHost(genericStringAssert)).isSameAs(sslSessionBuilder);
    verify(implementation).setPeerHost(genericStringAssert);
  }

  @Test
  void setPeerPort() {
    assertThat(sslSessionBuilder.setPeerPort(genericIntegerAssert)).isSameAs(sslSessionBuilder);
    verify(implementation).setPeerPort(genericIntegerAssert);
  }

  @Test
  void setPeerPrincipal() {
    assertThat(sslSessionBuilder.setPeerPrincipal(principal)).isSameAs(sslSessionBuilder);
    verify(implementation).setPeerPrincipal(principal);
  }

  @Test
  void setProtocol() {
    assertThat(sslSessionBuilder.setProtocol(genericStringAssert)).isSameAs(sslSessionBuilder);
    verify(implementation).setProtocol(genericStringAssert);
  }

  @Test
  void setSessionContext() {
    var sslSessionContext = mock(SslSessionContext.class);

    assertThat(sslSessionBuilder.setSessionContext(sslSessionContext)).isSameAs(sslSessionBuilder);
    verify(implementation).setSessionContext(sslSessionContext);
  }

  @Test
  void setValid() {
    var genericBooleanAssert = mock(GenericBooleanAssert.class);

    assertThat(sslSessionBuilder.setValid(genericBooleanAssert)).isSameAs(sslSessionBuilder);
    verify(implementation).setValid(genericBooleanAssert);
  }

  @Test
  void setValueNames() {
    assertThat(sslSessionBuilder.setValueNames(genericStringArrayAssert))
        .isSameAs(sslSessionBuilder);
    verify(implementation).setValueNames(genericStringArrayAssert);
  }
}
