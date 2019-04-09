package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericByteArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import java.security.cert.Certificate;
import javax.net.ssl.SSLSession;

interface SslSessionSetter
    extends Setter<SSLSession, GenericObjectAssert<SSLSession, ?>>, SslSession {
  void setApplicationBufferSize(GenericIntegerAssert<?> applicationBufferSize);

  void setCipherSuite(GenericStringAssert<?> cipherSuite);

  void setCreationTime(GenericLongAssert<?> creationTime);

  void setId(GenericByteArrayAssert<?> id);

  void setLastAccessedTime(GenericLongAssert<?> lastAccessedTime);

  void setLocalCertificates(GenericObjectArrayAssert<? super Certificate, ?> localCertificates);

  void setLocalPrincipal(Principal localPrincipal);

  void setPacketBufferSize(GenericIntegerAssert<?> packetBufferSize);

  void setPeerCertificates(GenericObjectArrayAssert<? super Certificate, ?> peerCertificates);

  void setPeerHost(GenericStringAssert<?> peerHost);

  void setPeerPort(GenericIntegerAssert<?> peerPort);

  void setPeerPrincipal(Principal peerPrincipal);

  void setProtocol(GenericStringAssert<?> protocol);

  void setSessionContext(SslSessionContext sessionContext);

  void setValid(GenericBooleanAssert<?> valid);

  void setValueNames(GenericObjectArrayAssert<? super String, ?> valueNames);
}
