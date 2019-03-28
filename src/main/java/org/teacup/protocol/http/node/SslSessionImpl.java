package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.Constants.ERROR_FETCH;
import static org.teacup.protocol.http.node.Constants.SETTING_THE;
import static org.teacup.protocol.http.node.Constants.VERIFY;

import io.github.henryssondaniel.teacup.core.Node;
import io.github.henryssondaniel.teacup.core.assertion.BooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.ByteArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.LongAssert;
import io.github.henryssondaniel.teacup.core.assertion.ObjectArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.ObjectAssert;
import io.github.henryssondaniel.teacup.core.assertion.StringAssert;
import java.security.cert.Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;

class SslSessionImpl extends SetterImpl<SSLSession> implements SslSessionSetter {
  private static final Logger LOGGER = Logger.getLogger(SslSessionImpl.class.getName());

  private ObjectAssert<? super Integer, ?> applicationBufferSize;
  private ObjectAssert<? super String, ?> cipherSuite;
  private ObjectAssert<Long, ?> creationTime;
  private ObjectAssert<byte[], ?> id;
  private ObjectAssert<Long, ?> lastAccessedTime;
  private ObjectAssert<? super Certificate[], ?> localCertificates;
  private Node<java.security.Principal> localPrincipal;
  private ObjectAssert<? super Integer, ?> packetBufferSize;
  private ObjectAssert<? super Certificate[], ?> peerCertificates;
  private ObjectAssert<? super String, ?> peerHost;
  private ObjectAssert<? super Integer, ?> peerPort;
  private Node<java.security.Principal> peerPrincipal;
  private ObjectAssert<? super String, ?> protocol;
  private Node<SSLSessionContext> sessionContext;
  private ObjectAssert<Boolean, ?> valid;
  private ObjectAssert<? super String[], ?> valueNames;

  @Override
  public void setApplicationBufferSize(IntegerAssert<?> applicationBufferSize) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "application buffer size"));
    this.applicationBufferSize = applicationBufferSize;
  }

  @Override
  public void setCipherSuite(StringAssert<?> cipherSuite) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "cipher suite"));
    this.cipherSuite = cipherSuite;
  }

  @Override
  public void setCreationTime(LongAssert<?> creationTime) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "creation time"));
    this.creationTime = creationTime;
  }

  @Override
  public void setId(ByteArrayAssert<?> id) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "ID"));
    this.id = id;
  }

  @Override
  public void setLastAccessedTime(LongAssert<?> lastAccessedTime) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "last accessed time"));
    this.lastAccessedTime = lastAccessedTime;
  }

  @Override
  public void setLocalCertificates(ObjectArrayAssert<? super Certificate, ?> localCertificates) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "local certificates"));
    this.localCertificates = localCertificates;
  }

  @Override
  public void setLocalPrincipal(Principal localPrincipal) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "local principal"));
    this.localPrincipal = localPrincipal;
  }

  @Override
  public void setPacketBufferSize(IntegerAssert<?> packetBufferSize) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "packet buffer size"));
    this.packetBufferSize = packetBufferSize;
  }

  @Override
  public void setPeerCertificates(ObjectArrayAssert<? super Certificate, ?> peerCertificates) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer certificates"));
    this.peerCertificates = peerCertificates;
  }

  @Override
  public void setPeerHost(StringAssert<?> peerHost) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer host"));
    this.peerHost = peerHost;
  }

  @Override
  public void setPeerPort(IntegerAssert<?> peerPort) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer port"));
    this.peerPort = peerPort;
  }

  @Override
  public void setPeerPrincipal(Principal peerPrincipal) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer principal"));
    this.peerPrincipal = peerPrincipal;
  }

  @Override
  public void setProtocol(StringAssert<?> protocol) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "protocol"));
    this.protocol = protocol;
  }

  @Override
  public void setSessionContext(SslSessionContext sessionContext) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "session context"));
    this.sessionContext = sessionContext;
  }

  @Override
  public void setValid(BooleanAssert<?> valid) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "valid"));
    this.valid = valid;
  }

  @Override
  public void setValueNames(ObjectArrayAssert<? super String, ?> valueNames) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "value names"));
    this.valueNames = valueNames;
  }

  @Override
  public void verify(SSLSession sslSession) {
    LOGGER.log(Level.FINE, String.format(VERIFY, "SSL session"));

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
      ObjectAssert<? super SSLSession, ?> objectAssert, SSLSession sslSession) {
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
