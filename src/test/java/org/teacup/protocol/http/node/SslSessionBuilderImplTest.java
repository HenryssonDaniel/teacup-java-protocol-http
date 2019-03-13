package org.teacup.protocol.http.node;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.security.cert.Certificate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.teacup.core.DefaultNodeBuilder;
import org.teacup.core.Utils;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.ByteArrayAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.LongAssert;
import org.teacup.core.assertion.ObjectArrayAssert;
import org.teacup.core.assertion.StringAssert;

class SslSessionBuilderImplTest {
  private final IntegerAssert integerAssert = mock(IntegerAssert.class);
  private final LongAssert longAssert = mock(LongAssert.class);
  private final Principal principal = mock(Principal.class);
  private final SslSessionBuilder sslSessionBuilder = new SslSessionBuilderImpl();
  private final SslSessionSetter sslSessionSetter = mock(SslSessionSetter.class);
  private final StringAssert stringAssert = mock(StringAssert.class);

  @Mock private ObjectArrayAssert<? super Certificate> certificateArrayAssert;
  @Mock private ObjectArrayAssert<? super String> stringArrayAssert;

  @BeforeEach
  void beforeEach() throws IllegalAccessException, NoSuchFieldException {
    Utils.setField(DefaultNodeBuilder.class, sslSessionBuilder, "setter", sslSessionSetter);
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
    verify(sslSessionSetter).setApplicationBufferSize(integerAssert);
  }

  @Test
  void setCipherSuite() {
    assertThat(sslSessionBuilder.setCipherSuite(stringAssert)).isSameAs(sslSessionBuilder);
    verify(sslSessionSetter).setCipherSuite(stringAssert);
  }

  @Test
  void setCreationTime() {
    assertThat(sslSessionBuilder.setCreationTime(longAssert)).isSameAs(sslSessionBuilder);
    verify(sslSessionSetter).setCreationTime(longAssert);
  }

  @Test
  void setId() {
    var byteArrayAssert = mock(ByteArrayAssert.class);

    assertThat(sslSessionBuilder.setId(byteArrayAssert)).isSameAs(sslSessionBuilder);
    verify(sslSessionSetter).setId(byteArrayAssert);
  }

  @Test
  void setLastAccessedTime() {
    assertThat(sslSessionBuilder.setLastAccessedTime(longAssert)).isSameAs(sslSessionBuilder);
    verify(sslSessionSetter).setLastAccessedTime(longAssert);
  }

  @Test
  void setLocalCertificates() {
    assertThat(sslSessionBuilder.setLocalCertificates(certificateArrayAssert))
        .isSameAs(sslSessionBuilder);
    verify(sslSessionSetter).setLocalCertificates(certificateArrayAssert);
  }

  @Test
  void setLocalPrincipal() {
    assertThat(sslSessionBuilder.setLocalPrincipal(principal)).isSameAs(sslSessionBuilder);
    verify(sslSessionSetter).setLocalPrincipal(principal);
  }

  @Test
  void setPacketBufferSize() {
    assertThat(sslSessionBuilder.setPacketBufferSize(integerAssert)).isSameAs(sslSessionBuilder);
    verify(sslSessionSetter).setPacketBufferSize(integerAssert);
  }

  @Test
  void setPeerCertificates() {
    assertThat(sslSessionBuilder.setPeerCertificates(certificateArrayAssert))
        .isSameAs(sslSessionBuilder);
    verify(sslSessionSetter).setPeerCertificates(certificateArrayAssert);
  }

  @Test
  void setPeerHost() {
    assertThat(sslSessionBuilder.setPeerHost(stringAssert)).isSameAs(sslSessionBuilder);
    verify(sslSessionSetter).setPeerHost(stringAssert);
  }

  @Test
  void setPeerPort() {
    assertThat(sslSessionBuilder.setPeerPort(integerAssert)).isSameAs(sslSessionBuilder);
    verify(sslSessionSetter).setPeerPort(integerAssert);
  }

  @Test
  void setPeerPrincipal() {
    assertThat(sslSessionBuilder.setPeerPrincipal(principal)).isSameAs(sslSessionBuilder);
    verify(sslSessionSetter).setPeerPrincipal(principal);
  }

  @Test
  void setProtocol() {
    assertThat(sslSessionBuilder.setProtocol(stringAssert)).isSameAs(sslSessionBuilder);
    verify(sslSessionSetter).setProtocol(stringAssert);
  }

  @Test
  void setSessionContext() {
    var sslSessionContext = mock(SslSessionContext.class);

    assertThat(sslSessionBuilder.setSessionContext(sslSessionContext)).isSameAs(sslSessionBuilder);
    verify(sslSessionSetter).setSessionContext(sslSessionContext);
  }

  @Test
  void setValid() {
    var booleanAssert = mock(BooleanAssert.class);

    assertThat(sslSessionBuilder.setValid(booleanAssert)).isSameAs(sslSessionBuilder);
    verify(sslSessionSetter).setValid(booleanAssert);
  }

  @Test
  void setValueNames() {
    assertThat(sslSessionBuilder.setValueNames(stringArrayAssert)).isSameAs(sslSessionBuilder);
    verify(sslSessionSetter).setValueNames(stringArrayAssert);
  }
}
