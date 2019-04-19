package io.github.henryssondaniel.teacup.protocol.http.node;

import java.security.Principal;
import java.security.cert.Certificate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;

class ErrorExtendedSslSession extends TestExtendedSslSession {
  private static final Logger LOGGER = Logger.getLogger(ErrorExtendedSslSession.class.getName());
  private final SSLPeerUnverifiedException sslPeerUnverifiedException =
      new SSLPeerUnverifiedException("test");

  @Override
  public Certificate[] getPeerCertificates() throws SSLPeerUnverifiedException {
    LOGGER.log(Level.FINE, "Get peer certificates");
    throw sslPeerUnverifiedException;
  }

  @Override
  public Principal getPeerPrincipal() throws SSLPeerUnverifiedException {
    LOGGER.log(Level.FINE, "Get peer principal");
    throw sslPeerUnverifiedException;
  }
}
