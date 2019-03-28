package org.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.BooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.ByteArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.LongAssert;
import io.github.henryssondaniel.teacup.core.assertion.ObjectArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.StringAssert;
import java.security.cert.Certificate;
import javax.net.ssl.SSLSession;

interface SslSessionSetter extends Setter<SSLSession>, SslSession {
  void setApplicationBufferSize(IntegerAssert<?> applicationBufferSize);

  void setCipherSuite(StringAssert<?> cipherSuite);

  void setCreationTime(LongAssert<?> creationTime);

  void setId(ByteArrayAssert<?> id);

  void setLastAccessedTime(LongAssert<?> lastAccessedTime);

  void setLocalCertificates(ObjectArrayAssert<? super Certificate, ?> localCertificates);

  void setLocalPrincipal(Principal localPrincipal);

  void setPacketBufferSize(IntegerAssert<?> packetBufferSize);

  void setPeerCertificates(ObjectArrayAssert<? super Certificate, ?> peerCertificates);

  void setPeerHost(StringAssert<?> peerHost);

  void setPeerPort(IntegerAssert<?> peerPort);

  void setPeerPrincipal(Principal peerPrincipal);

  void setProtocol(StringAssert<?> protocol);

  void setSessionContext(SslSessionContext sessionContext);

  void setValid(BooleanAssert<?> valid);

  void setValueNames(ObjectArrayAssert<? super String, ?> valueNames);
}
