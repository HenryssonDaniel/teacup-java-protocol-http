package org.teacup.protocol.http;

import static org.teacup.protocol.http.Constants.BUILD;
import static org.teacup.protocol.http.Constants.SETTING_THE;
import static org.teacup.protocol.http.Constants.SETTING_WHETHER;

import java.security.cert.Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.ByteArrayAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.LongAssert;
import org.teacup.core.assertion.ObjectArrayAssert;
import org.teacup.core.assertion.ObjectAssert;
import org.teacup.core.assertion.StringAssert;

class SslSessionNodeBuilderImpl implements SslSessionNodeBuilder {
  private static final Logger LOGGER = Logger.getLogger(SslSessionNodeBuilderImpl.class.getName());
  private SslSessionNodeSetter sslSessionNodeSetter = new SslSessionNodeImpl();

  @Override
  public SslSessionNode build() {
    LOGGER.log(Level.FINE, String.format(BUILD, "SSL session"));

    SslSessionNode sslSessionNode = sslSessionNodeSetter;
    sslSessionNodeSetter = new SslSessionNodeImpl();

    return sslSessionNode;
  }

  @Override
  public SslSessionNodeBuilder setApplicationBufferSize(IntegerAssert applicationBufferSize) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "application buffer size"));
    sslSessionNodeSetter.setApplicationBufferSize(applicationBufferSize);
    return this;
  }

  @Override
  public SslSessionNodeBuilder setAssertion(ObjectAssert<SSLSession, ?> assertion) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "assertion"));
    sslSessionNodeSetter.setAssertion(assertion);
    return this;
  }

  @Override
  public SslSessionNodeBuilder setCipherSuite(StringAssert cipherSuite) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "cipher suite"));
    sslSessionNodeSetter.setCipherSuite(cipherSuite);
    return this;
  }

  @Override
  public SslSessionNodeBuilder setCreationTime(LongAssert creationTime) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "creation time"));
    sslSessionNodeSetter.setCreationTime(creationTime);
    return this;
  }

  @Override
  public SslSessionNodeBuilder setId(ByteArrayAssert id) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "ID"));
    sslSessionNodeSetter.setId(id);
    return this;
  }

  @Override
  public SslSessionNodeBuilder setLastAccessedTime(LongAssert lastAccessedTime) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "last accessed time"));
    sslSessionNodeSetter.setLastAccessedTime(lastAccessedTime);
    return this;
  }

  @Override
  public SslSessionNodeBuilder setLocalCertificates(
      ObjectArrayAssert<? super Certificate> localCertificates) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "local certificates"));
    sslSessionNodeSetter.setLocalCertificates(localCertificates);
    return this;
  }

  @Override
  public SslSessionNodeBuilder setLocalPrincipal(PrincipalNode localPrincipal) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "local principal"));
    sslSessionNodeSetter.setLocalPrincipal(localPrincipal);
    return this;
  }

  @Override
  public SslSessionNodeBuilder setPacketBufferSize(IntegerAssert packetBufferSize) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "packet buffer size"));
    sslSessionNodeSetter.setPacketBufferSize(packetBufferSize);
    return this;
  }

  @Override
  public SslSessionNodeBuilder setPeerCertificates(
      ObjectArrayAssert<? super Certificate> peerCertificates) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer certificates"));
    sslSessionNodeSetter.setPeerCertificates(peerCertificates);
    return this;
  }

  @Override
  public SslSessionNodeBuilder setPeerHost(StringAssert peerHost) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer host"));
    sslSessionNodeSetter.setPeerHost(peerHost);
    return this;
  }

  @Override
  public SslSessionNodeBuilder setPeerPort(IntegerAssert peerPort) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer port"));
    sslSessionNodeSetter.setPeerPort(peerPort);
    return this;
  }

  @Override
  public SslSessionNodeBuilder setPeerPrincipal(PrincipalNode peerPrincipal) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer principal"));
    sslSessionNodeSetter.setPeerPrincipal(peerPrincipal);
    return this;
  }

  @Override
  public SslSessionNodeBuilder setProtocol(StringAssert protocol) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "protocol"));
    sslSessionNodeSetter.setProtocol(protocol);
    return this;
  }

  @Override
  public SslSessionNodeBuilder setSessionContext(SslSessionContextNode sessionContext) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "session context"));
    sslSessionNodeSetter.setSessionContext(sessionContext);
    return this;
  }

  @Override
  public SslSessionNodeBuilder setValid(BooleanAssert valid) {
    LOGGER.log(Level.FINE, String.format(SETTING_WHETHER, "valid"));
    sslSessionNodeSetter.setValid(valid);
    return this;
  }

  @Override
  public SslSessionNodeBuilder setValueNames(ObjectArrayAssert<? super String> valueNames) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "value names"));
    sslSessionNodeSetter.setValueNames(valueNames);
    return this;
  }
}
