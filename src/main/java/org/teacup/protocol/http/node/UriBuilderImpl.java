package org.teacup.protocol.http.node;

import static org.teacup.protocol.http.node.Constants.SETTING_THE;
import static org.teacup.protocol.http.node.Constants.SETTING_WHETHER;

import io.github.henryssondaniel.teacup.core.assertion.BooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.IntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.StringAssert;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

class UriBuilderImpl extends BuilderImpl<URI, Uri, UriSetter, UriBuilder> implements UriBuilder {
  private static final Logger LOGGER = Logger.getLogger(UriBuilderImpl.class.getName());

  UriBuilderImpl() {
    super(new UriImpl());
  }

  @Override
  public UriBuilder setAbsolute(BooleanAssert<?> absolute) {
    LOGGER.log(Level.FINE, String.format(SETTING_WHETHER, "absolute"));
    getImplementation().setAbsolute(absolute);
    return this;
  }

  @Override
  public UriBuilder setAuthority(StringAssert<?> authority) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "authority"));
    getImplementation().setAuthority(authority);
    return this;
  }

  @Override
  public UriBuilder setFragment(StringAssert<?> fragment) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "fragment"));
    getImplementation().setFragment(fragment);
    return this;
  }

  @Override
  public UriBuilder setHost(StringAssert<?> host) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "host"));
    getImplementation().setHost(host);
    return this;
  }

  @Override
  public UriBuilder setOpaque(BooleanAssert<?> opaque) {
    LOGGER.log(Level.FINE, String.format(SETTING_WHETHER, "opaque"));
    getImplementation().setOpaque(opaque);
    return this;
  }

  @Override
  public UriBuilder setPath(StringAssert<?> path) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "path"));
    getImplementation().setPath(path);
    return this;
  }

  @Override
  public UriBuilder setPort(IntegerAssert<?> port) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "port"));
    getImplementation().setPort(port);
    return this;
  }

  @Override
  public UriBuilder setQuery(StringAssert<?> query) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "query"));
    getImplementation().setQuery(query);
    return this;
  }

  @Override
  public UriBuilder setRawAuthority(StringAssert<?> rawAuthority) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw authority"));
    getImplementation().setRawAuthority(rawAuthority);
    return this;
  }

  @Override
  public UriBuilder setRawFragment(StringAssert<?> rawFragment) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw fragment"));
    getImplementation().setRawFragment(rawFragment);
    return this;
  }

  @Override
  public UriBuilder setRawPath(StringAssert<?> rawPath) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw path"));
    getImplementation().setRawPath(rawPath);
    return this;
  }

  @Override
  public UriBuilder setRawQuery(StringAssert<?> rawQuery) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw query"));
    getImplementation().setRawQuery(rawQuery);
    return this;
  }

  @Override
  public UriBuilder setRawSchemeSpecificPart(StringAssert<?> rawSchemeSpecificPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw scheme specific part"));
    getImplementation().setRawSchemeSpecificPart(rawSchemeSpecificPart);
    return this;
  }

  @Override
  public UriBuilder setRawUserInfo(StringAssert<?> rawUserInfo) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "raw user info"));
    getImplementation().setRawUserInfo(rawUserInfo);
    return this;
  }

  @Override
  public UriBuilder setScheme(StringAssert<?> scheme) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "scheme"));
    getImplementation().setScheme(scheme);
    return this;
  }

  @Override
  public UriBuilder setSchemeSpecificPart(StringAssert<?> schemeSpecificPart) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "scheme specific part"));
    getImplementation().setSchemeSpecificPart(schemeSpecificPart);
    return this;
  }

  @Override
  public UriBuilder setUserInfo(StringAssert<?> userInfo) {
    LOGGER.log(Level.FINE, String.format(SETTING_THE, "user info"));
    getImplementation().setUserInfo(userInfo);
    return this;
  }

  @Override
  protected UriSetter createImplementation() {
    return new UriImpl();
  }
}
