package org.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.security.cert.Certificate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.ByteArrayAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.LongAssert;
import org.teacup.core.assertion.ObjectArrayAssert;
import org.teacup.core.assertion.StringAssert;

class SslSessionBuilderImplTest {
  private final IntegerAssert<?> integerAssert = mock(IntegerAssert.class);
  private final LongAssert<?> longAssert = mock(LongAssert.class);
  private final Principal principal = mock(Principal.class);
  @InjectMocks private final SslSessionBuilder sslSessionBuilder = new SslSessionBuilderImpl();
  private final StringAssert<?> stringAssert = mock(StringAssert.class);

  @Mock private ObjectArrayAssert<? super Certificate, ?> certificateArrayAssert;
  @Mock private SslSessionSetter implementation;
  @Mock private ObjectArrayAssert<? super String, ?> stringArrayAssert;

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
    assertThat(sslSessionBuilder.setApplicationBufferSize(integerAssert))
        .isSameAs(sslSessionBuilder);
    verify(implementation).setApplicationBufferSize(integerAssert);
  }

  @Test
  void setCipherSuite() {
    assertThat(sslSessionBuilder.setCipherSuite(stringAssert)).isSameAs(sslSessionBuilder);
    verify(implementation).setCipherSuite(stringAssert);
  }

  @Test
  void setCreationTime() {
    assertThat(sslSessionBuilder.setCreationTime(longAssert)).isSameAs(sslSessionBuilder);
    verify(implementation).setCreationTime(longAssert);
  }

  @Test
  void setId() {
    var byteArrayAssert = mock(ByteArrayAssert.class);

    assertThat(sslSessionBuilder.setId(byteArrayAssert)).isSameAs(sslSessionBuilder);
    verify(implementation).setId(byteArrayAssert);
  }

  @Test
  void setLastAccessedTime() {
    assertThat(sslSessionBuilder.setLastAccessedTime(longAssert)).isSameAs(sslSessionBuilder);
    verify(implementation).setLastAccessedTime(longAssert);
  }

  @Test
  void setLocalCertificates() {
    assertThat(sslSessionBuilder.setLocalCertificates(certificateArrayAssert))
        .isSameAs(sslSessionBuilder);
    verify(implementation).setLocalCertificates(certificateArrayAssert);
  }

  @Test
  void setLocalPrincipal() {
    assertThat(sslSessionBuilder.setLocalPrincipal(principal)).isSameAs(sslSessionBuilder);
    verify(implementation).setLocalPrincipal(principal);
  }

  @Test
  void setPacketBufferSize() {
    assertThat(sslSessionBuilder.setPacketBufferSize(integerAssert)).isSameAs(sslSessionBuilder);
    verify(implementation).setPacketBufferSize(integerAssert);
  }

  @Test
  void setPeerCertificates() {
    assertThat(sslSessionBuilder.setPeerCertificates(certificateArrayAssert))
        .isSameAs(sslSessionBuilder);
    verify(implementation).setPeerCertificates(certificateArrayAssert);
  }

  @Test
  void setPeerHost() {
    assertThat(sslSessionBuilder.setPeerHost(stringAssert)).isSameAs(sslSessionBuilder);
    verify(implementation).setPeerHost(stringAssert);
  }

  @Test
  void setPeerPort() {
    assertThat(sslSessionBuilder.setPeerPort(integerAssert)).isSameAs(sslSessionBuilder);
    verify(implementation).setPeerPort(integerAssert);
  }

  @Test
  void setPeerPrincipal() {
    assertThat(sslSessionBuilder.setPeerPrincipal(principal)).isSameAs(sslSessionBuilder);
    verify(implementation).setPeerPrincipal(principal);
  }

  @Test
  void setProtocol() {
    assertThat(sslSessionBuilder.setProtocol(stringAssert)).isSameAs(sslSessionBuilder);
    verify(implementation).setProtocol(stringAssert);
  }

  @Test
  void setSessionContext() {
    var sslSessionContext = mock(SslSessionContext.class);

    assertThat(sslSessionBuilder.setSessionContext(sslSessionContext)).isSameAs(sslSessionBuilder);
    verify(implementation).setSessionContext(sslSessionContext);
  }

  @Test
  void setValid() {
    var booleanAssert = mock(BooleanAssert.class);

    assertThat(sslSessionBuilder.setValid(booleanAssert)).isSameAs(sslSessionBuilder);
    verify(implementation).setValid(booleanAssert);
  }

  @Test
  void setValueNames() {
    assertThat(sslSessionBuilder.setValueNames(stringArrayAssert)).isSameAs(sslSessionBuilder);
    verify(implementation).setValueNames(stringArrayAssert);
  }
}
