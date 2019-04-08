package io.github.henryssondaniel.teacup.protocol.http.node;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericByteArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.LongAssert;
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

  private final GenericIntegerAssert<?> genericIntegerAssert = mock(IntegerAssert.class);
  private final GenericLongAssert<?> genericLongAssert = mock(LongAssert.class);
  private final GenericStringAssert<?> genericStringAssert = mock(StringAssert.class);
  private final Principal principal = mock(Principal.class);
  private final SSLSession sslSession = mock(SSLSession.class);
  private final SslSessionSetter sslSessionSetter = new SslSessionImpl();

  @Mock private GenericObjectArrayAssert<Certificate, ?> genericObjectArrayAssert;
  @Mock private GenericObjectAssert<SSLSession, ?> genericObjectAssert;
  @Mock private GenericObjectArrayAssert<String, ?> genericStringObjectArrayAssert;

  @BeforeEach
  void beforeEach() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void setApplicationBufferSize() throws SSLPeerUnverifiedException {
    sslSessionSetter.setApplicationBufferSize(genericIntegerAssert);
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

    verify(genericIntegerAssert).verify(sslSession.getApplicationBufferSize());
  }

  @Test
  void setAssertion() throws SSLPeerUnverifiedException {
    sslSessionSetter.setAssertion(genericObjectAssert);
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

    verify(genericObjectAssert).verify(sslSession);
  }

  @Test
  void setCipherSuite() throws SSLPeerUnverifiedException {
    sslSessionSetter.setCipherSuite(genericStringAssert);
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

    verify(genericStringAssert).verify(sslSession.getCipherSuite());
  }

  @Test
  void setCreationTime() throws SSLPeerUnverifiedException {
    sslSessionSetter.setCreationTime(genericLongAssert);
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

    verify(genericLongAssert).verify(sslSession.getCreationTime());
  }

  @Test
  void setId() throws SSLPeerUnverifiedException {
    GenericByteArrayAssert<?> genericByteArrayAssert = mock(GenericByteArrayAssert.class);

    sslSessionSetter.setId(genericByteArrayAssert);
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

    verify(genericByteArrayAssert).verify(sslSession.getId());
  }

  @Test
  void setLastAccessedTime() throws SSLPeerUnverifiedException {
    sslSessionSetter.setLastAccessedTime(genericLongAssert);
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

    verify(genericLongAssert).verify(sslSession.getLastAccessedTime());
  }

  @Test
  void setLocalCertificates() throws SSLPeerUnverifiedException {
    sslSessionSetter.setLocalCertificates(genericObjectArrayAssert);
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

    verify(genericObjectArrayAssert).verify(sslSession.getLocalCertificates());
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
    sslSessionSetter.setPacketBufferSize(genericIntegerAssert);
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

    verify(genericIntegerAssert).verify(sslSession.getPacketBufferSize());
  }

  @Test
  void setPeerCertificates() throws SSLPeerUnverifiedException {
    sslSessionSetter.setPeerCertificates(genericObjectArrayAssert);
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

    verify(genericObjectArrayAssert).verify(sslSession.getPeerCertificates());
  }

  @Test
  void setPeerCertificatesError() throws SSLPeerUnverifiedException {
    when(sslSession.getPeerCertificates()).thenThrow(SSL_PEER_UNVERIFIED_EXCEPTION);

    sslSessionSetter.setPeerCertificates(genericObjectArrayAssert);
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

    verify(genericObjectArrayAssert, never()).verify(any());
  }

  @Test
  void setPeerHost() throws SSLPeerUnverifiedException {
    sslSessionSetter.setPeerHost(genericStringAssert);
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

    verify(genericStringAssert).verify(sslSession.getPeerHost());
  }

  @Test
  void setPeerPort() throws SSLPeerUnverifiedException {
    sslSessionSetter.setPeerPort(genericIntegerAssert);
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

    verify(genericIntegerAssert).verify(sslSession.getPeerPort());
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
    sslSessionSetter.setProtocol(genericStringAssert);
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

    verify(genericStringAssert).verify(sslSession.getProtocol());
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
    GenericBooleanAssert<?> genericBooleanAssert = mock(GenericBooleanAssert.class);

    sslSessionSetter.setValid(genericBooleanAssert);
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

    verify(genericBooleanAssert).verify(sslSession.isValid());
  }

  @Test
  void setValueNames() throws SSLPeerUnverifiedException {
    sslSessionSetter.setValueNames(genericStringObjectArrayAssert);
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

    verify(genericStringObjectArrayAssert).verify(sslSession.getValueNames());
  }
}
