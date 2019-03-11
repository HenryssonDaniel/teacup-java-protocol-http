package org.teacup.protocols.http;

import java.security.cert.Certificate;
import javax.net.ssl.SSLSession;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.ByteArrayAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.LongAssert;
import org.teacup.core.assertion.ObjectArrayAssert;
import org.teacup.core.assertion.ObjectAssert;
import org.teacup.core.assertion.StringAssert;

interface SslSessionNodeSetter extends SslSessionNode {
  void setApplicationBufferSize(IntegerAssert applicationBufferSize);

  void setAssertion(ObjectAssert<? super SSLSession, ?> assertion);

  void setCipherSuite(StringAssert cipherSuite);

  void setCreationTime(LongAssert creationTime);

  void setId(ByteArrayAssert id);

  void setLastAccessedTime(LongAssert lastAccessedTime);

  void setLocalCertificates(ObjectArrayAssert<? super Certificate> localCertificates);

  void setLocalPrincipal(PrincipalNode localPrincipal);

  void setPacketBufferSize(IntegerAssert packetBufferSize);

  void setPeerCertificates(ObjectArrayAssert<? super Certificate> peerCertificates);

  void setPeerHost(StringAssert peerHost);

  void setPeerPort(IntegerAssert peerPort);

  void setPeerPrincipal(PrincipalNode peerPrincipal);

  void setProtocol(StringAssert protocol);

  void setSessionContext(SslSessionContextNode sessionContext);

  void setValid(BooleanAssert valid);

  void setValueNames(ObjectArrayAssert<? super String> valueNames);
}
