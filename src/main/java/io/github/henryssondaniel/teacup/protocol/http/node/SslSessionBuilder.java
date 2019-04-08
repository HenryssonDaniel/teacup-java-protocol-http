package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.NodeBuilder;
import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericByteArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import java.security.cert.Certificate;
import javax.net.ssl.SSLSession;

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
  SslSessionBuilder setApplicationBufferSize(GenericIntegerAssert<?> applicationBufferSize);

  /**
   * Sets the cipher suite.
   *
   * @param cipherSuite the cipher suite
   * @return the SSL session builder
   */
  SslSessionBuilder setCipherSuite(GenericStringAssert<?> cipherSuite);

  /**
   * Sets the creation tine.
   *
   * @param creationTime the creation time
   * @return the SSL session builder
   */
  SslSessionBuilder setCreationTime(GenericLongAssert<?> creationTime);

  /**
   * Sets the ID.
   *
   * @param id the ID
   * @return the SSL session builder
   */
  SslSessionBuilder setId(GenericByteArrayAssert<?> id);

  /**
   * Sets the last accessed time.
   *
   * @param lastAccessedTime the last accessed time
   * @return the SSL session builder
   */
  SslSessionBuilder setLastAccessedTime(GenericLongAssert<?> lastAccessedTime);

  /**
   * Sets the local certificates.
   *
   * @param localCertificates the local certificates
   * @return the SSL session builder
   */
  SslSessionBuilder setLocalCertificates(
      GenericObjectArrayAssert<? super Certificate, ?> localCertificates);

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
  SslSessionBuilder setPacketBufferSize(GenericIntegerAssert<?> packetBufferSize);

  /**
   * Sets the peek certificates.
   *
   * @param peerCertificates the peek certificates
   * @return the SSL session builder
   */
  SslSessionBuilder setPeerCertificates(
      GenericObjectArrayAssert<? super Certificate, ?> peerCertificates);

  /**
   * Sets the peer host.
   *
   * @param peerHost the peer host
   * @return the SSL session builder
   */
  SslSessionBuilder setPeerHost(GenericStringAssert<?> peerHost);

  /**
   * Sets the peer port.
   *
   * @param peerPort the peer port
   * @return the SSL session builder
   */
  SslSessionBuilder setPeerPort(GenericIntegerAssert<?> peerPort);

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
  SslSessionBuilder setProtocol(GenericStringAssert<?> protocol);

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
  SslSessionBuilder setValid(GenericBooleanAssert<?> valid);

  /**
   * Sets the value names.
   *
   * @param valueNames the value names
   * @return the SSL session builder
   */
  SslSessionBuilder setValueNames(GenericObjectArrayAssert<? super String, ?> valueNames);
}
