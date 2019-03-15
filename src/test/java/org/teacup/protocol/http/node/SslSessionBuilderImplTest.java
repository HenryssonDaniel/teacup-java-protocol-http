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
  @Mock private SslSessionSetter setter;
  @Mock private ObjectArrayAssert<? super String, ?> stringArrayAssert;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void createSetter() {
    assertThat(new SslSessionBuilderImpl().createSetter())
        .isExactlyInstanceOf(SslSessionImpl.class);
  }

  @Test
  void setApplicationBufferSize() {
    assertThat(sslSessionBuilder.setApplicationBufferSize(integerAssert))
        .isSameAs(sslSessionBuilder);
    verify(setter).setApplicationBufferSize(integerAssert);
  }

  @Test
  void setCipherSuite() {
    assertThat(sslSessionBuilder.setCipherSuite(stringAssert)).isSameAs(sslSessionBuilder);
    verify(setter).setCipherSuite(stringAssert);
  }

  @Test
  void setCreationTime() {
    assertThat(sslSessionBuilder.setCreationTime(longAssert)).isSameAs(sslSessionBuilder);
    verify(setter).setCreationTime(longAssert);
  }

  @Test
  void setId() {
    var byteArrayAssert = mock(ByteArrayAssert.class);

    assertThat(sslSessionBuilder.setId(byteArrayAssert)).isSameAs(sslSessionBuilder);
    verify(setter).setId(byteArrayAssert);
  }

  @Test
  void setLastAccessedTime() {
    assertThat(sslSessionBuilder.setLastAccessedTime(longAssert)).isSameAs(sslSessionBuilder);
    verify(setter).setLastAccessedTime(longAssert);
  }

  @Test
  void setLocalCertificates() {
    assertThat(sslSessionBuilder.setLocalCertificates(certificateArrayAssert))
        .isSameAs(sslSessionBuilder);
    verify(setter).setLocalCertificates(certificateArrayAssert);
  }

  @Test
  void setLocalPrincipal() {
    assertThat(sslSessionBuilder.setLocalPrincipal(principal)).isSameAs(sslSessionBuilder);
    verify(setter).setLocalPrincipal(principal);
  }

  @Test
  void setPacketBufferSize() {
    assertThat(sslSessionBuilder.setPacketBufferSize(integerAssert)).isSameAs(sslSessionBuilder);
    verify(setter).setPacketBufferSize(integerAssert);
  }

  @Test
  void setPeerCertificates() {
    assertThat(sslSessionBuilder.setPeerCertificates(certificateArrayAssert))
        .isSameAs(sslSessionBuilder);
    verify(setter).setPeerCertificates(certificateArrayAssert);
  }

  @Test
  void setPeerHost() {
    assertThat(sslSessionBuilder.setPeerHost(stringAssert)).isSameAs(sslSessionBuilder);
    verify(setter).setPeerHost(stringAssert);
  }

  @Test
  void setPeerPort() {
    assertThat(sslSessionBuilder.setPeerPort(integerAssert)).isSameAs(sslSessionBuilder);
    verify(setter).setPeerPort(integerAssert);
  }

  @Test
  void setPeerPrincipal() {
    assertThat(sslSessionBuilder.setPeerPrincipal(principal)).isSameAs(sslSessionBuilder);
    verify(setter).setPeerPrincipal(principal);
  }

  @Test
  void setProtocol() {
    assertThat(sslSessionBuilder.setProtocol(stringAssert)).isSameAs(sslSessionBuilder);
    verify(setter).setProtocol(stringAssert);
  }

  @Test
  void setSessionContext() {
    var sslSessionContext = mock(SslSessionContext.class);

    assertThat(sslSessionBuilder.setSessionContext(sslSessionContext)).isSameAs(sslSessionBuilder);
    verify(setter).setSessionContext(sslSessionContext);
  }

  @Test
  void setValid() {
    var booleanAssert = mock(BooleanAssert.class);

    assertThat(sslSessionBuilder.setValid(booleanAssert)).isSameAs(sslSessionBuilder);
    verify(setter).setValid(booleanAssert);
  }

  @Test
  void setValueNames() {
    assertThat(sslSessionBuilder.setValueNames(stringArrayAssert)).isSameAs(sslSessionBuilder);
    verify(setter).setValueNames(stringArrayAssert);
  }
}
