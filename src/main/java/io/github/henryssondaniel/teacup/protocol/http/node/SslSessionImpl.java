package io.github.henryssondaniel.teacup.protocol.http.node;

import static io.github.henryssondaniel.teacup.protocol.http.Constants.ERROR_FETCH;

import io.github.henryssondaniel.teacup.core.Node;
import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericByteArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import java.security.cert.Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;

class SslSessionImpl extends SetterImpl<SSLSession> implements SslSessionSetter {
  private static final Logger LOGGER = Logger.getLogger(SslSessionImpl.class.getName());

  private GenericObjectAssert<? super Integer, ?> applicationBufferSize;
  private GenericObjectAssert<? super String, ?> cipherSuite;
  private GenericObjectAssert<Long, ?> creationTime;
  private GenericObjectAssert<byte[], ?> id;
  private GenericObjectAssert<Long, ?> lastAccessedTime;
  private GenericObjectAssert<? super Certificate[], ?> localCertificates;
  private Node<java.security.Principal> localPrincipal;
  private GenericObjectAssert<? super Integer, ?> packetBufferSize;
  private GenericObjectAssert<? super Certificate[], ?> peerCertificates;
  private GenericObjectAssert<? super String, ?> peerHost;
  private GenericObjectAssert<? super Integer, ?> peerPort;
  private Node<java.security.Principal> peerPrincipal;
  private GenericObjectAssert<? super String, ?> protocol;
  private Node<SSLSessionContext> sessionContext;
  private GenericObjectAssert<Boolean, ?> valid;
  private GenericObjectAssert<? super String[], ?> valueNames;

  @Override
  public void setApplicationBufferSize(GenericIntegerAssert<?> applicationBufferSize) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "application buffer size");
    this.applicationBufferSize = applicationBufferSize;
  }

  @Override
  public void setCipherSuite(GenericStringAssert<?> cipherSuite) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "cipher suite");
    this.cipherSuite = cipherSuite;
  }

  @Override
  public void setCreationTime(GenericLongAssert<?> creationTime) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "creation time");
    this.creationTime = creationTime;
  }

  @Override
  public void setId(GenericByteArrayAssert<?> id) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "ID");
    this.id = id;
  }

  @Override
  public void setLastAccessedTime(GenericLongAssert<?> lastAccessedTime) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "last accessed time");
    this.lastAccessedTime = lastAccessedTime;
  }

  @Override
  public void setLocalCertificates(
      GenericObjectArrayAssert<? super Certificate, ?> localCertificates) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "local certificates");
    this.localCertificates = localCertificates;
  }

  @Override
  public void setLocalPrincipal(Principal localPrincipal) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "local principal");
    this.localPrincipal = localPrincipal;
  }

  @Override
  public void setPacketBufferSize(GenericIntegerAssert<?> packetBufferSize) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "packet buffer size");
    this.packetBufferSize = packetBufferSize;
  }

  @Override
  public void setPeerCertificates(
      GenericObjectArrayAssert<? super Certificate, ?> peerCertificates) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "peer certificates");
    this.peerCertificates = peerCertificates;
  }

  @Override
  public void setPeerHost(GenericStringAssert<?> peerHost) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "peer host");
    this.peerHost = peerHost;
  }

  @Override
  public void setPeerPort(GenericIntegerAssert<?> peerPort) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "peer port");
    this.peerPort = peerPort;
  }

  @Override
  public void setPeerPrincipal(Principal peerPrincipal) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "peer principal");
    this.peerPrincipal = peerPrincipal;
  }

  @Override
  public void setProtocol(GenericStringAssert<?> protocol) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "protocol");
    this.protocol = protocol;
  }

  @Override
  public void setSessionContext(SslSessionContext sessionContext) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "session context");
    this.sessionContext = sessionContext;
  }

  @Override
  public void setValid(GenericBooleanAssert<?> valid) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "valid");
    this.valid = valid;
  }

  @Override
  public void setValueNames(GenericObjectArrayAssert<? super String, ?> valueNames) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "value names");
    this.valueNames = valueNames;
  }

  @Override
  public void verify(SSLSession sslSession) {
    LOGGER.log(Level.FINE, Constants.VERIFY, "SSL session");

    verifyAssertion(getAssertion(), sslSession);
    verifyApplicationBufferSize(sslSession);
    verifyCipherSuite(sslSession);
    verifyCreationTime(sslSession);
    verifyId(sslSession);
    verifyLastAccessedTime(sslSession);
    verifyLocalCertificates(sslSession);
    verifyLocalPrincipal(sslSession);
    verifyPacketBufferSize(sslSession);
    verifyPeerCertificates(sslSession);
    verifyPeerHost(sslSession);
    verifyPeerPort(sslSession);
    verifyPeerPrincipal(sslSession);
    verifyProtocol(sslSession);
    verifySessionContext(sslSession);
    verifyValid(sslSession);
    verifyValueNames(sslSession);
  }

  private void verifyApplicationBufferSize(SSLSession sslSession) {
    if (applicationBufferSize != null)
      applicationBufferSize.verify(sslSession.getApplicationBufferSize());
  }

  private static void verifyAssertion(
      GenericObjectAssert<? super SSLSession, ?> objectAssert, SSLSession sslSession) {
    if (objectAssert != null) objectAssert.verify(sslSession);
  }

  private void verifyCipherSuite(SSLSession sslSession) {
    if (cipherSuite != null) cipherSuite.verify(sslSession.getCipherSuite());
  }

  private void verifyCreationTime(SSLSession sslSession) {
    if (creationTime != null) creationTime.verify(sslSession.getCreationTime());
  }

  private void verifyId(SSLSession sslSession) {
    if (id != null) id.verify(sslSession.getId());
  }

  private void verifyLastAccessedTime(SSLSession sslSession) {
    if (lastAccessedTime != null) lastAccessedTime.verify(sslSession.getLastAccessedTime());
  }

  private void verifyLocalCertificates(SSLSession sslSession) {
    if (localCertificates != null) localCertificates.verify(sslSession.getLocalCertificates());
  }

  private void verifyLocalPrincipal(SSLSession sslSession) {
    if (localPrincipal != null) localPrincipal.verify(sslSession.getLocalPrincipal());
  }

  private void verifyPacketBufferSize(SSLSession sslSession) {
    if (packetBufferSize != null) packetBufferSize.verify(sslSession.getPacketBufferSize());
  }

  private void verifyPeerCertificates(SSLSession sslSession) {
    if (peerCertificates != null)
      try {
        peerCertificates.verify(sslSession.getPeerCertificates());
      } catch (SSLPeerUnverifiedException sslPeerUnverifiedException) {
        LOGGER.log(
            Level.SEVERE, String.format(ERROR_FETCH, "certificates"), sslPeerUnverifiedException);
      }
  }

  private void verifyPeerHost(SSLSession sslSession) {
    if (peerHost != null) peerHost.verify(sslSession.getPeerHost());
  }

  private void verifyPeerPort(SSLSession sslSession) {
    if (peerPort != null) peerPort.verify(sslSession.getPeerPort());
  }

  private void verifyPeerPrincipal(SSLSession sslSession) {
    if (peerPrincipal != null)
      try {
        peerPrincipal.verify(sslSession.getPeerPrincipal());
      } catch (SSLPeerUnverifiedException sslPeerUnverifiedException) {
        LOGGER.log(
            Level.SEVERE, String.format(ERROR_FETCH, "principal"), sslPeerUnverifiedException);
      }
  }

  private void verifyProtocol(SSLSession sslSession) {
    if (protocol != null) protocol.verify(sslSession.getProtocol());
  }

  private void verifySessionContext(SSLSession sslSession) {
    if (sessionContext != null) sessionContext.verify(sslSession.getSessionContext());
  }

  private void verifyValid(SSLSession sslSession) {
    if (valid != null) valid.verify(sslSession.isValid());
  }

  private void verifyValueNames(SSLSession sslSession) {
    if (valueNames != null) valueNames.verify(sslSession.getValueNames());
  }
}
