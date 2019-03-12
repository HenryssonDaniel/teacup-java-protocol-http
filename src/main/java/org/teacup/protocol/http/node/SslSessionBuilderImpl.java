package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;
import static org.teacup.protocol.http.node.Constants.SETTING_WHETHER;

import java.security.cert.Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import org.teacup.core.assertion.BooleanAssert;
import org.teacup.core.assertion.ByteArrayAssert;
import org.teacup.core.assertion.IntegerAssert;
import org.teacup.core.assertion.LongAssert;
import org.teacup.core.assertion.ObjectArrayAssert;
import org.teacup.core.assertion.StringAssert;

class SslSessionBuilderImpl
    extends BuilderImpl<SSLSession, SslSession, SslSessionSetter, SslSessionBuilder>
    implements SslSessionBuilder {
  private static final Logger LOGGER = Logger.getLogger(SslSessionBuilderImpl.class.getName());

  SslSessionBuilderImpl() {
    super(new SslSessionImpl());
  }

  @Override
  public SslSessionBuilder setApplicationBufferSize(IntegerAssert applicationBufferSize) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "application buffer size"));
    getSetter().setApplicationBufferSize(applicationBufferSize);
    return this;
  }

  @Override
  public SslSessionBuilder setCipherSuite(StringAssert cipherSuite) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "cipher suite"));
    getSetter().setCipherSuite(cipherSuite);
    return this;
  }

  @Override
  public SslSessionBuilder setCreationTime(LongAssert creationTime) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "creation time"));
    getSetter().setCreationTime(creationTime);
    return this;
  }

  @Override
  public SslSessionBuilder setId(ByteArrayAssert id) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "ID"));
    getSetter().setId(id);
    return this;
  }

  @Override
  public SslSessionBuilder setLastAccessedTime(LongAssert lastAccessedTime) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "last accessed time"));
    getSetter().setLastAccessedTime(lastAccessedTime);
    return this;
  }

  @Override
  public SslSessionBuilder setLocalCertificates(
      ObjectArrayAssert<? super Certificate> localCertificates) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "local certificates"));
    getSetter().setLocalCertificates(localCertificates);
    return this;
  }

  @Override
  public SslSessionBuilder setLocalPrincipal(Principal localPrincipal) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "local principal"));
    getSetter().setLocalPrincipal(localPrincipal);
    return this;
  }

  @Override
  public SslSessionBuilder setPacketBufferSize(IntegerAssert packetBufferSize) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "packet buffer size"));
    getSetter().setPacketBufferSize(packetBufferSize);
    return this;
  }

  @Override
  public SslSessionBuilder setPeerCertificates(
      ObjectArrayAssert<? super Certificate> peerCertificates) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer certificates"));
    getSetter().setPeerCertificates(peerCertificates);
    return this;
  }

  @Override
  public SslSessionBuilder setPeerHost(StringAssert peerHost) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer host"));
    getSetter().setPeerHost(peerHost);
    return this;
  }

  @Override
  public SslSessionBuilder setPeerPort(IntegerAssert peerPort) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer port"));
    getSetter().setPeerPort(peerPort);
    return this;
  }

  @Override
  public SslSessionBuilder setPeerPrincipal(Principal peerPrincipal) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer principal"));
    getSetter().setPeerPrincipal(peerPrincipal);
    return this;
  }

  @Override
  public SslSessionBuilder setProtocol(StringAssert protocol) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "protocol"));
    getSetter().setProtocol(protocol);
    return this;
  }

  @Override
  public SslSessionBuilder setSessionContext(SslSessionContext sessionContext) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "session context"));
    getSetter().setSessionContext(sessionContext);
    return this;
  }

  @Override
  public SslSessionBuilder setValid(BooleanAssert valid) {
    LOGGER.log(Level.FINE, String.format(SETTING_WHETHER, "valid"));
    getSetter().setValid(valid);
    return this;
  }

  @Override
  public SslSessionBuilder setValueNames(ObjectArrayAssert<? super String> valueNames) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "value names"));
    getSetter().setValueNames(valueNames);
    return this;
  }

  @Override
  protected SslSessionSetter createSetter() {
    return new SslSessionImpl();
  }
}
