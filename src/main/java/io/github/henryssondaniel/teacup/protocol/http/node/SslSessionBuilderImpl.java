package io.github.henryssondaniel.teacup.protocol.http.node;

import static io.github.henryssondaniel.teacup.protocol.http.node.Constants.SETTING_THE;
import static io.github.henryssondaniel.teacup.protocol.http.node.Constants.SETTING_WHETHER;

import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericByteArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericLongAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericObjectArrayAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import java.security.cert.Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;

class SslSessionBuilderImpl
    extends BuilderImpl<SSLSession, SslSession, SslSessionSetter, SslSessionBuilder>
    implements SslSessionBuilder {
  private static final Logger LOGGER = Logger.getLogger(SslSessionBuilderImpl.class.getName());

  SslSessionBuilderImpl() {
    super(new SslSessionImpl());
  }

  @Override
  public SslSessionBuilder setApplicationBufferSize(GenericIntegerAssert<?> applicationBufferSize) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "application buffer size"));
    getImplementation().setApplicationBufferSize(applicationBufferSize);
    return this;
  }

  @Override
  public SslSessionBuilder setCipherSuite(GenericStringAssert<?> cipherSuite) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "cipher suite"));
    getImplementation().setCipherSuite(cipherSuite);
    return this;
  }

  @Override
  public SslSessionBuilder setCreationTime(GenericLongAssert<?> creationTime) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "creation time"));
    getImplementation().setCreationTime(creationTime);
    return this;
  }

  @Override
  public SslSessionBuilder setId(GenericByteArrayAssert<?> id) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "ID"));
    getImplementation().setId(id);
    return this;
  }

  @Override
  public SslSessionBuilder setLastAccessedTime(GenericLongAssert<?> lastAccessedTime) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "last accessed time"));
    getImplementation().setLastAccessedTime(lastAccessedTime);
    return this;
  }

  @Override
  public SslSessionBuilder setLocalCertificates(
      GenericObjectArrayAssert<? super Certificate, ?> localCertificates) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "local certificates"));
    getImplementation().setLocalCertificates(localCertificates);
    return this;
  }

  @Override
  public SslSessionBuilder setLocalPrincipal(Principal localPrincipal) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "local principal"));
    getImplementation().setLocalPrincipal(localPrincipal);
    return this;
  }

  @Override
  public SslSessionBuilder setPacketBufferSize(GenericIntegerAssert<?> packetBufferSize) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "packet buffer size"));
    getImplementation().setPacketBufferSize(packetBufferSize);
    return this;
  }

  @Override
  public SslSessionBuilder setPeerCertificates(
      GenericObjectArrayAssert<? super Certificate, ?> peerCertificates) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer certificates"));
    getImplementation().setPeerCertificates(peerCertificates);
    return this;
  }

  @Override
  public SslSessionBuilder setPeerHost(GenericStringAssert<?> peerHost) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer host"));
    getImplementation().setPeerHost(peerHost);
    return this;
  }

  @Override
  public SslSessionBuilder setPeerPort(GenericIntegerAssert<?> peerPort) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer port"));
    getImplementation().setPeerPort(peerPort);
    return this;
  }

  @Override
  public SslSessionBuilder setPeerPrincipal(Principal peerPrincipal) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "peer principal"));
    getImplementation().setPeerPrincipal(peerPrincipal);
    return this;
  }

  @Override
  public SslSessionBuilder setProtocol(GenericStringAssert<?> protocol) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "protocol"));
    getImplementation().setProtocol(protocol);
    return this;
  }

  @Override
  public SslSessionBuilder setSessionContext(SslSessionContext sessionContext) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "session context"));
    getImplementation().setSessionContext(sessionContext);
    return this;
  }

  @Override
  public SslSessionBuilder setValid(GenericBooleanAssert<?> valid) {
    LOGGER.log(Level.FINE, String.format(SETTING_WHETHER, "valid"));
    getImplementation().setValid(valid);
    return this;
  }

  @Override
  public SslSessionBuilder setValueNames(GenericObjectArrayAssert<? super String, ?> valueNames) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "value names"));
    getImplementation().setValueNames(valueNames);
    return this;
  }

  @Override
  protected SslSessionSetter createImplementation() {
    return new SslSessionImpl();
  }
}
