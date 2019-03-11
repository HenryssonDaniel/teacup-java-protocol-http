package org.teacup.protocol.http.node;

import java.security.cert.Certificate;
import javax.net.ssl.SSLSession;
import org.teacup.core.NodeBuilder;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.ByteArrayAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.LongAssert;
import org.teacup.core.assertion.ObjectArrayAssert;
import org.teacup.core.assertion.StringAssert;

/**
 * SSL session builder.
 *
 * @since 1.0
 */
public interface SslSessionBuilder extends NodeBuilder<SSLSession, SslSession, SslSessionBuilder> {
  /**
   * Sets the application buffer size.
   *
   * @param applicationBufferSize the application buffer size
   * @return the SSL session builder
   */
  SslSessionBuilder setApplicationBufferSize(IntegerAssert applicationBufferSize);

  /**
   * Sets the cipher suite.
   *
   * @param cipherSuite the cipher suite
   * @return the SSL session builder
   */
  SslSessionBuilder setCipherSuite(StringAssert cipherSuite);

  /**
   * Sets the creation tine.
   *
   * @param creationTime the creation time
   * @return the SSL session builder
   */
  SslSessionBuilder setCreationTime(LongAssert creationTime);

  /**
   * Sets the ID.
   *
   * @param id the ID
   * @return the SSL session builder
   */
  SslSessionBuilder setId(ByteArrayAssert id);

  /**
   * Sets the last accessed time.
   *
   * @param lastAccessedTime the last accessed time
   * @return the SSL session builder
   */
  SslSessionBuilder setLastAccessedTime(LongAssert lastAccessedTime);

  /**
   * Sets the local certificates.
   *
   * @param localCertificates the local certificates
   * @return the SSL session builder
   */
  SslSessionBuilder setLocalCertificates(ObjectArrayAssert<? super Certificate> localCertificates);

  /**
   * Sets the local principal.
   *
   * @param localPrincipal the local principal
   * @return the SSL session builder
   */
  SslSessionBuilder setLocalPrincipal(Principal localPrincipal);

  /**
   * Sets the packet buffer size.
   *
   * @param packetBufferSize the packet buffer size
   * @return the SSL session builder
   */
  SslSessionBuilder setPacketBufferSize(IntegerAssert packetBufferSize);

  /**
   * Sets the peek certificates.
   *
   * @param peerCertificates the peek certificates
   * @return the SSL session builder
   */
  SslSessionBuilder setPeerCertificates(ObjectArrayAssert<? super Certificate> peerCertificates);

  /**
   * Sets the peer host.
   *
   * @param peerHost the peer host
   * @return the SSL session builder
   */
  SslSessionBuilder setPeerHost(StringAssert peerHost);

  /**
   * Sets the peer port.
   *
   * @param peerPort the peer port
   * @return the SSL session builder
   */
  SslSessionBuilder setPeerPort(IntegerAssert peerPort);

  /**
   * Sets the peer principal.
   *
   * @param peerPrincipal the peer principal
   * @return the SSL session builder
   */
  SslSessionBuilder setPeerPrincipal(Principal peerPrincipal);

  /**
   * Sets the protocol.
   *
   * @param protocol the protocol
   * @return the SSL session builder
   */
  SslSessionBuilder setProtocol(StringAssert protocol);

  /**
   * Sets the session context.
   *
   * @param sessionContext the session context
   * @return the SSL session builder
   */
  SslSessionBuilder setSessionContext(SslSessionContext sessionContext);

  /**
   * Sets whether valid or not.
   *
   * @param valid whether valid or not
   * @return the SSL session builder
   */
  SslSessionBuilder setValid(BooleanAssert valid);

  /**
   * Sets the value names.
   *
   * @param valueNames the value names
   * @return the SSL session builder
   */
  SslSessionBuilder setValueNames(ObjectArrayAssert<? super String> valueNames);
}
