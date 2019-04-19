package io.github.henryssondaniel.teacup.protocol.http.node;

import java.security.Principal;
import java.security.cert.Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSessionContext;
import javax.security.cert.X509Certificate;

class TestExtendedSslSession extends ExtendedSSLSession {
  private static final byte[] BYTES = new byte[0];
  private static final Certificate[] CERTIFICATES = new Certificate[0];
  private static final Logger LOGGER = Logger.getLogger(TestExtendedSslSession.class.getName());
  private static final String[] STRINGS = new String[0];
  private static final X509Certificate[] X_509_CERTIFICATES = new X509Certificate[0];

  private final SSLSessionContext sslSessionContext = new TestSslSessionContext();

  @Override
  public int getApplicationBufferSize() {
    LOGGER.log(Level.FINE, "Get application buffer size");
    return 0;
  }

  @Override
  public String getCipherSuite() {
    LOGGER.log(Level.FINE, "Get cipher suite");
    return "cipherSuite";
  }

  @Override
  public long getCreationTime() {
    LOGGER.log(Level.FINE, "Get creation time");
    return 0L;
  }

  @Override
  public byte[] getId() {
    LOGGER.log(Level.FINE, "Get ID");
    return BYTES;
  }

  @Override
  public long getLastAccessedTime() {
    LOGGER.log(Level.FINE, "Get last accessed time");
    return 0L;
  }

  @Override
  public Certificate[] getLocalCertificates() {
    LOGGER.log(Level.FINE, "Get lcoal certificates");
    return CERTIFICATES;
  }

  @Override
  public java.security.Principal getLocalPrincipal() {
    LOGGER.log(Level.FINE, "Get local principal");
    return () -> "name";
  }

  @Override
  public String[] getLocalSupportedSignatureAlgorithms() {
    LOGGER.log(Level.FINE, "Get local supported signature algorithms");
    return STRINGS;
  }

  @Override
  public int getPacketBufferSize() {
    LOGGER.log(Level.FINE, "Get packet buffer size");
    return 0;
  }

  @Override
  public X509Certificate[] getPeerCertificateChain() {
    LOGGER.log(Level.FINE, "Get peer certificate chain");
    return X_509_CERTIFICATES;
  }

  @Override
  public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
    LOGGER.log(Level.FINE, "Get peer certificates");
    return CERTIFICATES;
  }

  @Override
  public String getPeerHost() {
    LOGGER.log(Level.FINE, "Get peer host");
    return "peerHost";
  }

  @Override
  public int getPeerPort() {
    LOGGER.log(Level.FINE, "Get peer port");
    return 0;
  }

  @Override
  public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
    LOGGER.log(Level.FINE, "Get peer principal");
    return () -> "name";
  }

  @Override
  public String[] getPeerSupportedSignatureAlgorithms() {
    LOGGER.log(Level.FINE, "Get peer supported signature algorithms");
    return STRINGS;
  }

  @Override
  public String getProtocol() {
    LOGGER.log(Level.FINE, "Get protocol");
    return "protocol";
  }

  @Override
  public SSLSessionContext getSessionContext() {
    LOGGER.log(Level.FINE, "Get session context");
    return sslSessionContext;
  }

  @Override
  public Object getValue(String s) {
    LOGGER.log(Level.FINE, "Get value");
    return s;
  }

  @Override
  public String[] getValueNames() {
    LOGGER.log(Level.FINE, "Get value names");
    return STRINGS;
  }

  @Override
  public void invalidate() {
    LOGGER.log(Level.FINE, "Invalidate");
  }

  @Override
  public boolean isValid() {
    LOGGER.log(Level.FINE, "Is valid");
    return false;
  }

  @Override
  public void putValue(String s, Object o) {
    LOGGER.log(Level.FINE, "Put value");
  }

  @Override
  public void removeValue(String s) {
    LOGGER.log(Level.FINE, "Remove value");
  }
}
