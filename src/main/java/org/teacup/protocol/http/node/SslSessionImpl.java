package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.Constants.ERROR_FETCH;
import static org.teacup.protocol.http.node.Constants.SETTING_THE;
import static org.teacup.protocol.http.node.Constants.VERIFY;

import java.security.cert.Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;
import org.teacup.core.Node;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.ByteArrayAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.LongAssert;
import org.teacup.core.assertion.ObjectArrayAssert;
import org.teacup.core.assertion.ObjectAssert;
import org.teacup.core.assertion.StringAssert;

class SslSessionImpl implements SslSessionSetter {
  private static final Logger LOGGER = Logger.getLogger(SslSessionImpl.class.getName());

  private ObjectAssert<? super Integer, IntegerAssert> applicationBufferSize;
  private ObjectAssert<? super SSLSession, ?> assertion;
  private ObjectAssert<? super String, StringAssert> cipherSuite;
  private ObjectAssert<Long, LongAssert> creationTime;
  private ObjectAssert<byte[], ByteArrayAssert> id;
  private ObjectAssert<Long, LongAssert> lastAccessedTime;
  private ObjectAssert<? super Certificate[], ?> localCertificates;
  private Node<java.security.Principal> localPrincipal;
  private ObjectAssert<? super Integer, IntegerAssert> packetBufferSize;
  private ObjectAssert<? super Certificate[], ?> peerCertificates;
  private ObjectAssert<? super String, StringAssert> peerHost;
  private ObjectAssert<? super Integer, IntegerAssert> peerPort;
  private Node<java.security.Principal> peerPrincipal;
  private ObjectAssert<? super String, StringAssert> protocol;
  private Node<SSLSessionContext> sessionContext;
  private ObjectAssert<Boolean, BooleanAssert> valid;
  private ObjectAssert<? super String[], ?> valueNames;

  @Override
  public void setApplicationBufferSize(IntegerAssert applicationBufferSize) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "application buffer size"));
    this.applicationBufferSize = applicationBufferSize;
  }

  @Override
  public void setAssertion(ObjectAssert<? super SSLSession, ?> assertion) {
    this.assertion = assertion;
  }

  @Override
  public void setCipherSuite(StringAssert cipherSuite) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "cipher suite"));
    this.cipherSuite = cipherSuite;
  }

  @Override
  public void setCreationTime(LongAssert creationTime) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "creation time"));
    this.creationTime = creationTime;
  }

  @Override
  public void setId(ByteArrayAssert id) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "ID"));
    this.id = id;
  }

  @Override
  public void setLastAccessedTime(LongAssert lastAccessedTime) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "last accessed time"));
    this.lastAccessedTime = lastAccessedTime;
  }

  @Override
  public void setLocalCertificates(ObjectArrayAssert<? super Certificate> localCertificates) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "local certificates"));
    this.localCertificates = localCertificates;
  }

  @Override
  public void setLocalPrincipal(Principal localPrincipal) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "local principal"));
    this.localPrincipal = localPrincipal;
  }

  @Override
  public void setPacketBufferSize(IntegerAssert packetBufferSize) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "packet buffer size"));
    this.packetBufferSize = packetBufferSize;
  }

  @Override
  public void setPeerCertificates(ObjectArrayAssert<? super Certificate> peerCertificates) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer certificates"));
    this.peerCertificates = peerCertificates;
  }

  @Override
  public void setPeerHost(StringAssert peerHost) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer host"));
    this.peerHost = peerHost;
  }

  @Override
  public void setPeerPort(IntegerAssert peerPort) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer port"));
    this.peerPort = peerPort;
  }

  @Override
  public void setPeerPrincipal(Principal peerPrincipal) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer principal"));
    this.peerPrincipal = peerPrincipal;
  }

  @Override
  public void setProtocol(StringAssert protocol) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "protocol"));
    this.protocol = protocol;
  }

  @Override
  public void setSessionContext(SslSessionContext sessionContext) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "session context"));
    this.sessionContext = sessionContext;
  }

  @Override
  public void setValid(BooleanAssert valid) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "valid"));
    this.valid = valid;
  }

  @Override
  public void setValueNames(ObjectArrayAssert<? super String> valueNames) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "value names"));
    this.valueNames = valueNames;
  }

  @Override
  public void verify(SSLSession sslSession) {
    LOGGER.log(Level.FINE, String.format(VERIFY, "SSL session"));
    if (assertion != null) assertion.verify(sslSession);
    verifyFields(sslSession);
  }

  private void verifyFields(SSLSession sslSession) {
    verifyInteger(applicationBufferSize, sslSession.getApplicationBufferSize());
    verifyString(cipherSuite, sslSession.getCipherSuite());
    verifyLong(creationTime, sslSession.getCreationTime());
    verifyId(sslSession);
    verifyLong(lastAccessedTime, sslSession.getLastAccessedTime());
    verifyLocalCertificates(sslSession);
    verifyLocalPrincipal(sslSession);
    verifyInteger(packetBufferSize, sslSession.getPacketBufferSize());
    verifyPeerCertificates(sslSession);
    verifyString(peerHost, sslSession.getPeerHost());
    verifyInteger(peerPort, sslSession.getPeerPort());
    verifyPeerPrincipal(sslSession);
    verifyString(protocol, sslSession.getProtocol());
    verifySessionContext(sslSession);
    verifyValid(sslSession);
    verifyValueNames(sslSession);
  }

  private void verifyId(SSLSession sslSession) {
    if (id != null) id.verify(sslSession.getId());
  }

  private static void verifyInteger(
      ObjectAssert<? super Integer, IntegerAssert> objectAssert, int applicationBufferSize2) {
    if (objectAssert != null) objectAssert.verify(applicationBufferSize2);
  }

  private void verifyLocalCertificates(SSLSession sslSession) {
    if (localCertificates != null) localCertificates.verify(sslSession.getLocalCertificates());
  }

  private void verifyLocalPrincipal(SSLSession sslSession) {
    if (localPrincipal != null) localPrincipal.verify(sslSession.getLocalPrincipal());
  }

  private static void verifyLong(ObjectAssert<? super Long, LongAssert> objectAssert, long actual) {
    if (objectAssert != null) objectAssert.verify(actual);
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

  private void verifyPeerPrincipal(SSLSession sslSession) {
    if (peerPrincipal != null)
      try {
        peerPrincipal.verify(sslSession.getPeerPrincipal());
      } catch (SSLPeerUnverifiedException sslPeerUnverifiedException) {
        LOGGER.log(
            Level.SEVERE, String.format(ERROR_FETCH, "principal"), sslPeerUnverifiedException);
      }
  }

  private void verifySessionContext(SSLSession sslSession) {
    if (sessionContext != null) sessionContext.verify(sslSession.getSessionContext());
  }

  private static void verifyString(
      ObjectAssert<? super String, StringAssert> objectAssert, String actual) {
    if (objectAssert != null) objectAssert.verify(actual);
  }

  private void verifyValid(SSLSession sslSession) {
    if (valid != null) valid.verify(sslSession.isValid());
  }

  private void verifyValueNames(SSLSession sslSession) {
    if (valueNames != null) valueNames.verify(sslSession.getValueNames());
  }
}
