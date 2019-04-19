package io.github.henryssondaniel.teacup.protocol.http.node;

import java.util.Collections;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSessionContext;

class TestSslSessionContext implements SSLSessionContext {
  private static final Logger LOGGER = Logger.getLogger(TestSslSessionContext.class.getName());

  @Override
  public Enumeration<byte[]> getIds() {
    LOGGER.log(Level.FINE, "Get ID's");
    return Collections.emptyEnumeration();
  }

  @Override
  public SSLSession getSession(byte[] bytes) {
    LOGGER.log(Level.FINE, "Get ID's");
    return new TestExtendedSslSession();
  }

  @Override
  public int getSessionCacheSize() {
    LOGGER.log(Level.FINE, "Get session cache size");
    return 0;
  }

  @Override
  public int getSessionTimeout() {
    LOGGER.log(Level.FINE, "Get session timeout");
    return 0;
  }

  @Override
  public void setSessionCacheSize(int i) {
    LOGGER.log(Level.FINE, "Get session cache size");
  }

  @Override
  public void setSessionTimeout(int i) {
    LOGGER.log(Level.FINE, "Get session timeout");
  }
}
