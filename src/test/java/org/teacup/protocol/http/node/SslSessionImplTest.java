package org.teacup.protocol.http.node;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.github.henryssondaniel.teacup.core.assertion.BooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.ByteArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.LongAssert;
import io.github.henryssondaniel.teacup.core.assertion.ObjectArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.ObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.StringAssert;
import java.security.cert.Certificate;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class SslSessionImplTest {
  private static final SSLPeerUnverifiedException SSL_PEER_UNVERIFIED_EXCEPTION =
      new SSLPeerUnverifiedException("test");

  private final IntegerAssert<?> integerAssert = mock(IntegerAssert.class);
  private final LongAssert<?> longAssert = mock(LongAssert.class);
  private final Principal principal = mock(Principal.class);
  private final SSLSession sslSession = mock(SSLSession.class);
  private final SslSessionSetter sslSessionSetter = new SslSessionImpl();
  private final StringAssert<?> stringAssert = mock(StringAssert.class);

  @Mock private ObjectArrayAssert<Certificate, ?> objectArrayAssert;
  @Mock private ObjectAssert<? super SSLSession, ?> objectAssert;
  @Mock private ObjectArrayAssert<String, ?> stringObjectArrayAssert;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void setApplicationBufferSize() throws SSLPeerUnverifiedException {
    sslSessionSetter.setApplicationBufferSize(integerAssert);
    sslSessionSetter.verify(sslSession);

    verify(sslSession).getApplicationBufferSize();
    verify(sslSession, never()).getCipherSuite();
    verify(sslSession, never()).getCreationTime();
    verify(sslSession, never()).getId();
    verify(sslSession, never()).getLastAccessedTime();
    verify(sslSession, never()).getLocalCertificates();
    verify(sslSession, never()).getLocalPrincipal();
    verify(sslSession, never()).getPacketBufferSize();
    verify(sslSession, never()).getPeerCertificates();
    verify(sslSession, never()).getPeerHost();
    verify(sslSession, never()).getPeerPort();
    verify(sslSession, never()).getPeerPrincipal();
    verify(sslSession, never()).getProtocol();
    verify(sslSession, never()).getSessionContext();
    verify(sslSession, never()).getValueNames();
    verify(sslSession, never()).isValid();

    verify(integerAssert).verify(sslSession.getApplicationBufferSize());
  }

  @Test
  void setAssertion() throws SSLPeerUnverifiedException {
    sslSessionSetter.setAssertion(objectAssert);
    sslSessionSetter.verify(sslSession);

    verify(sslSession, never()).getApplicationBufferSize();
    verify(sslSession, never()).getCipherSuite();
    verify(sslSession, never()).getCreationTime();
    verify(sslSession, never()).getId();
    verify(sslSession, never()).getLastAccessedTime();
    verify(sslSession, never()).getLocalCertificates();
    verify(sslSession, never()).getLocalPrincipal();
    verify(sslSession, never()).getPacketBufferSize();
    verify(sslSession, never()).getPeerCertificates();
    verify(sslSession, never()).getPeerHost();
    verify(sslSession, never()).getPeerPort();
    verify(sslSession, never()).getPeerPrincipal();
    verify(sslSession, never()).getProtocol();
    verify(sslSession, never()).getSessionContext();
    verify(sslSession, never()).getValueNames();
    verify(sslSession, never()).isValid();

    verify(objectAssert).verify(sslSession);
  }

  @Test
  void setCipherSuite() throws SSLPeerUnverifiedException {
    sslSessionSetter.setCipherSuite(stringAssert);
    sslSessionSetter.verify(sslSession);

    verify(sslSession, never()).getApplicationBufferSize();
    verify(sslSession).getCipherSuite();
    verify(sslSession, never()).getCreationTime();
    verify(sslSession, never()).getId();
    verify(sslSession, never()).getLastAccessedTime();
    verify(sslSession, never()).getLocalCertificates();
    verify(sslSession, never()).getLocalPrincipal();
    verify(sslSession, never()).getPacketBufferSize();
    verify(sslSession, never()).getPeerCertificates();
    verify(sslSession, never()).getPeerHost();
    verify(sslSession, never()).getPeerPort();
    verify(sslSession, never()).getPeerPrincipal();
    verify(sslSession, never()).getProtocol();
    verify(sslSession, never()).getSessionContext();
    verify(sslSession, never()).getValueNames();
    verify(sslSession, never()).isValid();

    verify(stringAssert).verify(sslSession.getCipherSuite());
  }

  @Test
  void setCreationTime() throws SSLPeerUnverifiedException {
    sslSessionSetter.setCreationTime(longAssert);
    sslSessionSetter.verify(sslSession);

    verify(sslSession, never()).getApplicationBufferSize();
    verify(sslSession, never()).getCipherSuite();
    verify(sslSession).getCreationTime();
    verify(sslSession, never()).getId();
    verify(sslSession, never()).getLastAccessedTime();
    verify(sslSession, never()).getLocalCertificates();
    verify(sslSession, never()).getLocalPrincipal();
    verify(sslSession, never()).getPacketBufferSize();
    verify(sslSession, never()).getPeerCertificates();
    verify(sslSession, never()).getPeerHost();
    verify(sslSession, never()).getPeerPort();
    verify(sslSession, never()).getPeerPrincipal();
    verify(sslSession, never()).getProtocol();
    verify(sslSession, never()).getSessionContext();
    verify(sslSession, never()).getValueNames();
    verify(sslSession, never()).isValid();

    verify(longAssert).verify(sslSession.getCreationTime());
  }

  @Test
  void setId() throws SSLPeerUnverifiedException {
    ByteArrayAssert<?> byteArrayAssert = mock(ByteArrayAssert.class);

    sslSessionSetter.setId(byteArrayAssert);
    sslSessionSetter.verify(sslSession);

    verify(sslSession, never()).getApplicationBufferSize();
    verify(sslSession, never()).getCipherSuite();
    verify(sslSession, never()).getCreationTime();
    verify(sslSession).getId();
    verify(sslSession, never()).getLastAccessedTime();
    verify(sslSession, never()).getLocalCertificates();
    verify(sslSession, never()).getLocalPrincipal();
    verify(sslSession, never()).getPacketBufferSize();
    verify(sslSession, never()).getPeerCertificates();
    verify(sslSession, never()).getPeerHost();
    verify(sslSession, never()).getPeerPort();
    verify(sslSession, never()).getPeerPrincipal();
    verify(sslSession, never()).getProtocol();
    verify(sslSession, never()).getSessionContext();
    verify(sslSession, never()).getValueNames();
    verify(sslSession, never()).isValid();

    verify(byteArrayAssert).verify(sslSession.getId());
  }

  @Test
  void setLastAccessedTime() throws SSLPeerUnverifiedException {
    sslSessionSetter.setLastAccessedTime(longAssert);
    sslSessionSetter.verify(sslSession);

    verify(sslSession, never()).getApplicationBufferSize();
    verify(sslSession, never()).getCipherSuite();
    verify(sslSession, never()).getCreationTime();
    verify(sslSession, never()).getId();
    verify(sslSession).getLastAccessedTime();
    verify(sslSession, never()).getLocalCertificates();
    verify(sslSession, never()).getLocalPrincipal();
    verify(sslSession, never()).getPacketBufferSize();
    verify(sslSession, never()).getPeerCertificates();
    verify(sslSession, never()).getPeerHost();
    verify(sslSession, never()).getPeerPort();
    verify(sslSession, never()).getPeerPrincipal();
    verify(sslSession, never()).getProtocol();
    verify(sslSession, never()).getSessionContext();
    verify(sslSession, never()).getValueNames();
    verify(sslSession, never()).isValid();

    verify(longAssert).verify(sslSession.getLastAccessedTime());
  }

  @Test
  void setLocalCertificates() throws SSLPeerUnverifiedException {
    sslSessionSetter.setLocalCertificates(objectArrayAssert);
    sslSessionSetter.verify(sslSession);

    verify(sslSession, never()).getApplicationBufferSize();
    verify(sslSession, never()).getCipherSuite();
    verify(sslSession, never()).getCreationTime();
    verify(sslSession, never()).getId();
    verify(sslSession, never()).getLastAccessedTime();
    verify(sslSession).getLocalCertificates();
    verify(sslSession, never()).getLocalPrincipal();
    verify(sslSession, never()).getPacketBufferSize();
    verify(sslSession, never()).getPeerCertificates();
    verify(sslSession, never()).getPeerHost();
    verify(sslSession, never()).getPeerPort();
    verify(sslSession, never()).getPeerPrincipal();
    verify(sslSession, never()).getProtocol();
    verify(sslSession, never()).getSessionContext();
    verify(sslSession, never()).getValueNames();
    verify(sslSession, never()).isValid();

    verify(objectArrayAssert).verify(sslSession.getLocalCertificates());
  }

  @Test
  void setLocalPrincipal() throws SSLPeerUnverifiedException {
    sslSessionSetter.setLocalPrincipal(principal);
    sslSessionSetter.verify(sslSession);

    verify(sslSession, never()).getApplicationBufferSize();
    verify(sslSession, never()).getCipherSuite();
    verify(sslSession, never()).getCreationTime();
    verify(sslSession, never()).getId();
    verify(sslSession, never()).getLastAccessedTime();
    verify(sslSession, never()).getLocalCertificates();
    verify(sslSession).getLocalPrincipal();
    verify(sslSession, never()).getPacketBufferSize();
    verify(sslSession, never()).getPeerCertificates();
    verify(sslSession, never()).getPeerHost();
    verify(sslSession, never()).getPeerPort();
    verify(sslSession, never()).getPeerPrincipal();
    verify(sslSession, never()).getProtocol();
    verify(sslSession, never()).getSessionContext();
    verify(sslSession, never()).getValueNames();
    verify(sslSession, never()).isValid();

    verify(principal).verify(sslSession.getLocalPrincipal());
  }

  @Test
  void setPacketBufferSize() throws SSLPeerUnverifiedException {
    sslSessionSetter.setPacketBufferSize(integerAssert);
    sslSessionSetter.verify(sslSession);

    verify(sslSession, never()).getApplicationBufferSize();
    verify(sslSession, never()).getCipherSuite();
    verify(sslSession, never()).getCreationTime();
    verify(sslSession, never()).getId();
    verify(sslSession, never()).getLastAccessedTime();
    verify(sslSession, never()).getLocalCertificates();
    verify(sslSession, never()).getLocalPrincipal();
    verify(sslSession).getPacketBufferSize();
    verify(sslSession, never()).getPeerCertificates();
    verify(sslSession, never()).getPeerHost();
    verify(sslSession, never()).getPeerPort();
    verify(sslSession, never()).getPeerPrincipal();
    verify(sslSession, never()).getProtocol();
    verify(sslSession, never()).getSessionContext();
    verify(sslSession, never()).getValueNames();
    verify(sslSession, never()).isValid();

    verify(integerAssert).verify(sslSession.getPacketBufferSize());
  }

  @Test
  void setPeerCertificates() throws SSLPeerUnverifiedException {
    sslSessionSetter.setPeerCertificates(objectArrayAssert);
    sslSessionSetter.verify(sslSession);

    verify(sslSession, never()).getApplicationBufferSize();
    verify(sslSession, never()).getCipherSuite();
    verify(sslSession, never()).getCreationTime();
    verify(sslSession, never()).getId();
    verify(sslSession, never()).getLastAccessedTime();
    verify(sslSession, never()).getLocalCertificates();
    verify(sslSession, never()).getLocalPrincipal();
    verify(sslSession, never()).getPacketBufferSize();
    verify(sslSession).getPeerCertificates();
    verify(sslSession, never()).getPeerHost();
    verify(sslSession, never()).getPeerPort();
    verify(sslSession, never()).getPeerPrincipal();
    verify(sslSession, never()).getProtocol();
    verify(sslSession, never()).getSessionContext();
    verify(sslSession, never()).getValueNames();
    verify(sslSession, never()).isValid();

    verify(objectArrayAssert).verify(sslSession.getPeerCertificates());
  }

  @Test
  void setPeerCertificatesError() throws SSLPeerUnverifiedException {
    when(sslSession.getPeerCertificates()).thenThrow(SSL_PEER_UNVERIFIED_EXCEPTION);

    sslSessionSetter.setPeerCertificates(objectArrayAssert);
    sslSessionSetter.verify(sslSession);

    verify(sslSession, never()).getApplicationBufferSize();
    verify(sslSession, never()).getCipherSuite();
    verify(sslSession, never()).getCreationTime();
    verify(sslSession, never()).getId();
    verify(sslSession, never()).getLastAccessedTime();
    verify(sslSession, never()).getLocalCertificates();
    verify(sslSession, never()).getLocalPrincipal();
    verify(sslSession, never()).getPacketBufferSize();
    verify(sslSession).getPeerCertificates();
    verify(sslSession, never()).getPeerHost();
    verify(sslSession, never()).getPeerPort();
    verify(sslSession, never()).getPeerPrincipal();
    verify(sslSession, never()).getProtocol();
    verify(sslSession, never()).getSessionContext();
    verify(sslSession, never()).getValueNames();
    verify(sslSession, never()).isValid();

    verify(objectArrayAssert, never()).verify(any());
  }

  @Test
  void setPeerHost() throws SSLPeerUnverifiedException {
    sslSessionSetter.setPeerHost(stringAssert);
    sslSessionSetter.verify(sslSession);

    verify(sslSession, never()).getApplicationBufferSize();
    verify(sslSession, never()).getCipherSuite();
    verify(sslSession, never()).getCreationTime();
    verify(sslSession, never()).getId();
    verify(sslSession, never()).getLastAccessedTime();
    verify(sslSession, never()).getLocalCertificates();
    verify(sslSession, never()).getLocalPrincipal();
    verify(sslSession, never()).getPacketBufferSize();
    verify(sslSession, never()).getPeerCertificates();
    verify(sslSession).getPeerHost();
    verify(sslSession, never()).getPeerPort();
    verify(sslSession, never()).getPeerPrincipal();
    verify(sslSession, never()).getProtocol();
    verify(sslSession, never()).getSessionContext();
    verify(sslSession, never()).getValueNames();
    verify(sslSession, never()).isValid();

    verify(stringAssert).verify(sslSession.getPeerHost());
  }

  @Test
  void setPeerPort() throws SSLPeerUnverifiedException {
    sslSessionSetter.setPeerPort(integerAssert);
    sslSessionSetter.verify(sslSession);

    verify(sslSession, never()).getApplicationBufferSize();
    verify(sslSession, never()).getCipherSuite();
    verify(sslSession, never()).getCreationTime();
    verify(sslSession, never()).getId();
    verify(sslSession, never()).getLastAccessedTime();
    verify(sslSession, never()).getLocalCertificates();
    verify(sslSession, never()).getLocalPrincipal();
    verify(sslSession, never()).getPacketBufferSize();
    verify(sslSession, never()).getPeerCertificates();
    verify(sslSession, never()).getPeerHost();
    verify(sslSession).getPeerPort();
    verify(sslSession, never()).getPeerPrincipal();
    verify(sslSession, never()).getProtocol();
    verify(sslSession, never()).getSessionContext();
    verify(sslSession, never()).getValueNames();
    verify(sslSession, never()).isValid();

    verify(integerAssert).verify(sslSession.getPeerPort());
  }

  @Test
  void setPeerPrincipal() throws SSLPeerUnverifiedException {
    sslSessionSetter.setPeerPrincipal(principal);
    sslSessionSetter.verify(sslSession);

    verify(sslSession, never()).getApplicationBufferSize();
    verify(sslSession, never()).getCipherSuite();
    verify(sslSession, never()).getCreationTime();
    verify(sslSession, never()).getId();
    verify(sslSession, never()).getLastAccessedTime();
    verify(sslSession, never()).getLocalCertificates();
    verify(sslSession, never()).getLocalPrincipal();
    verify(sslSession, never()).getPacketBufferSize();
    verify(sslSession, never()).getPeerCertificates();
    verify(sslSession, never()).getPeerHost();
    verify(sslSession, never()).getPeerPort();
    verify(sslSession).getPeerPrincipal();
    verify(sslSession, never()).getProtocol();
    verify(sslSession, never()).getSessionContext();
    verify(sslSession, never()).getValueNames();
    verify(sslSession, never()).isValid();

    verify(principal).verify(sslSession.getPeerPrincipal());
  }

  @Test
  void setPeerPrincipalError() throws SSLPeerUnverifiedException {
    when(sslSession.getPeerPrincipal()).thenThrow(SSL_PEER_UNVERIFIED_EXCEPTION);

    sslSessionSetter.setPeerPrincipal(principal);
    sslSessionSetter.verify(sslSession);

    verify(sslSession, never()).getApplicationBufferSize();
    verify(sslSession, never()).getCipherSuite();
    verify(sslSession, never()).getCreationTime();
    verify(sslSession, never()).getId();
    verify(sslSession, never()).getLastAccessedTime();
    verify(sslSession, never()).getLocalCertificates();
    verify(sslSession, never()).getLocalPrincipal();
    verify(sslSession, never()).getPacketBufferSize();
    verify(sslSession, never()).getPeerCertificates();
    verify(sslSession, never()).getPeerHost();
    verify(sslSession, never()).getPeerPort();
    verify(sslSession).getPeerPrincipal();
    verify(sslSession, never()).getProtocol();
    verify(sslSession, never()).getSessionContext();
    verify(sslSession, never()).getValueNames();
    verify(sslSession, never()).isValid();

    verify(principal, never()).verify(any());
  }

  @Test
  void setProtocol() throws SSLPeerUnverifiedException {
    sslSessionSetter.setProtocol(stringAssert);
    sslSessionSetter.verify(sslSession);

    verify(sslSession, never()).getApplicationBufferSize();
    verify(sslSession, never()).getCipherSuite();
    verify(sslSession, never()).getCreationTime();
    verify(sslSession, never()).getId();
    verify(sslSession, never()).getLastAccessedTime();
    verify(sslSession, never()).getLocalCertificates();
    verify(sslSession, never()).getLocalPrincipal();
    verify(sslSession, never()).getPacketBufferSize();
    verify(sslSession, never()).getPeerCertificates();
    verify(sslSession, never()).getPeerHost();
    verify(sslSession, never()).getPeerPort();
    verify(sslSession, never()).getPeerPrincipal();
    verify(sslSession).getProtocol();
    verify(sslSession, never()).getSessionContext();
    verify(sslSession, never()).getValueNames();
    verify(sslSession, never()).isValid();

    verify(stringAssert).verify(sslSession.getProtocol());
  }

  @Test
  void setSessionContext() throws SSLPeerUnverifiedException {
    var sslSessionContext = mock(SslSessionContext.class);

    sslSessionSetter.setSessionContext(sslSessionContext);
    sslSessionSetter.verify(sslSession);

    verify(sslSession, never()).getApplicationBufferSize();
    verify(sslSession, never()).getCipherSuite();
    verify(sslSession, never()).getCreationTime();
    verify(sslSession, never()).getId();
    verify(sslSession, never()).getLastAccessedTime();
    verify(sslSession, never()).getLocalCertificates();
    verify(sslSession, never()).getLocalPrincipal();
    verify(sslSession, never()).getPacketBufferSize();
    verify(sslSession, never()).getPeerCertificates();
    verify(sslSession, never()).getPeerHost();
    verify(sslSession, never()).getPeerPort();
    verify(sslSession, never()).getPeerPrincipal();
    verify(sslSession, never()).getProtocol();
    verify(sslSession).getSessionContext();
    verify(sslSession, never()).getValueNames();
    verify(sslSession, never()).isValid();

    verify(sslSessionContext).verify(sslSession.getSessionContext());
  }

  @Test
  void setValid() throws SSLPeerUnverifiedException {
    BooleanAssert<?> booleanAssert = mock(BooleanAssert.class);

    sslSessionSetter.setValid(booleanAssert);
    sslSessionSetter.verify(sslSession);

    verify(sslSession, never()).getApplicationBufferSize();
    verify(sslSession, never()).getCipherSuite();
    verify(sslSession, never()).getCreationTime();
    verify(sslSession, never()).getId();
    verify(sslSession, never()).getLastAccessedTime();
    verify(sslSession, never()).getLocalCertificates();
    verify(sslSession, never()).getLocalPrincipal();
    verify(sslSession, never()).getPacketBufferSize();
    verify(sslSession, never()).getPeerCertificates();
    verify(sslSession, never()).getPeerHost();
    verify(sslSession, never()).getPeerPort();
    verify(sslSession, never()).getPeerPrincipal();
    verify(sslSession, never()).getProtocol();
    verify(sslSession, never()).getSessionContext();
    verify(sslSession, never()).getValueNames();
    verify(sslSession).isValid();

    verify(booleanAssert).verify(sslSession.isValid());
  }

  @Test
  void setValueNames() throws SSLPeerUnverifiedException {
    sslSessionSetter.setValueNames(stringObjectArrayAssert);
    sslSessionSetter.verify(sslSession);

    verify(sslSession, never()).getApplicationBufferSize();
    verify(sslSession, never()).getCipherSuite();
    verify(sslSession, never()).getCreationTime();
    verify(sslSession, never()).getId();
    verify(sslSession, never()).getLastAccessedTime();
    verify(sslSession, never()).getLocalCertificates();
    verify(sslSession, never()).getLocalPrincipal();
    verify(sslSession, never()).getPacketBufferSize();
    verify(sslSession, never()).getPeerCertificates();
    verify(sslSession, never()).getPeerHost();
    verify(sslSession, never()).getPeerPort();
    verify(sslSession, never()).getPeerPrincipal();
    verify(sslSession, never()).getProtocol();
    verify(sslSession, never()).getSessionContext();
    verify(sslSession).getValueNames();
    verify(sslSession, never()).isValid();

    verify(stringObjectArrayAssert).verify(sslSession.getValueNames());
  }
}
