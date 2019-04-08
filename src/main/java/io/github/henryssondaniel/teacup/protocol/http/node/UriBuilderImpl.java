package io.github.henryssondaniel.teacup.protocol.http.node;

import io.github.henryssondaniel.teacup.core.assertion.GenericBooleanAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericIntegerAssert;
import io.github.henryssondaniel.teacup.core.assertion.GenericStringAssert;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

class UriBuilderImpl extends BuilderImpl<URI, Uri, UriSetter, UriBuilder> implements UriBuilder {
  private static final Logger LOGGER = Logger.getLogger(UriBuilderImpl.class.getName());

  UriBuilderImpl() {
    super(new UriImpl());
  }

  @Override
  public UriBuilder setAbsolute(GenericBooleanAssert<?> absolute) {
    LOGGER.log(Level.FINE, Constants.SETTING_WHETHER, "absolute");
    getImplementation().setAbsolute(absolute);
    return this;
  }

  @Override
  public UriBuilder setAuthority(GenericStringAssert<?> authority) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "authority");
    getImplementation().setAuthority(authority);
    return this;
  }

  @Override
  public UriBuilder setFragment(GenericStringAssert<?> fragment) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "fragment");
    getImplementation().setFragment(fragment);
    return this;
  }

  @Override
  public UriBuilder setHost(GenericStringAssert<?> host) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "host");
    getImplementation().setHost(host);
    return this;
  }

  @Override
  public UriBuilder setOpaque(GenericBooleanAssert<?> opaque) {
    LOGGER.log(Level.FINE, Constants.SETTING_WHETHER, "opaque");
    getImplementation().setOpaque(opaque);
    return this;
  }

  @Override
  public UriBuilder setPath(GenericStringAssert<?> path) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "path");
    getImplementation().setPath(path);
    return this;
  }

  @Override
  public UriBuilder setPort(GenericIntegerAssert<?> port) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "port");
    getImplementation().setPort(port);
    return this;
  }

  @Override
  public UriBuilder setQuery(GenericStringAssert<?> query) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "query");
    getImplementation().setQuery(query);
    return this;
  }

  @Override
  public UriBuilder setRawAuthority(GenericStringAssert<?> rawAuthority) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "raw authority");
    getImplementation().setRawAuthority(rawAuthority);
    return this;
  }

  @Override
  public UriBuilder setRawFragment(GenericStringAssert<?> rawFragment) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "raw fragment");
    getImplementation().setRawFragment(rawFragment);
    return this;
  }

  @Override
  public UriBuilder setRawPath(GenericStringAssert<?> rawPath) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "raw path");
    getImplementation().setRawPath(rawPath);
    return this;
  }

  @Override
  public UriBuilder setRawQuery(GenericStringAssert<?> rawQuery) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "raw query");
    getImplementation().setRawQuery(rawQuery);
    return this;
  }

  @Override
  public UriBuilder setRawSchemeSpecificPart(GenericStringAssert<?> rawSchemeSpecificPart) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "raw scheme specific part");
    getImplementation().setRawSchemeSpecificPart(rawSchemeSpecificPart);
    return this;
  }

  @Override
  public UriBuilder setRawUserInfo(GenericStringAssert<?> rawUserInfo) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "raw user info");
    getImplementation().setRawUserInfo(rawUserInfo);
    return this;
  }

  @Override
  public UriBuilder setScheme(GenericStringAssert<?> scheme) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "scheme");
    getImplementation().setScheme(scheme);
    return this;
  }

  @Override
  public UriBuilder setSchemeSpecificPart(GenericStringAssert<?> schemeSpecificPart) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "scheme specific part");
    getImplementation().setSchemeSpecificPart(schemeSpecificPart);
    return this;
  }

  @Override
  public UriBuilder setUserInfo(GenericStringAssert<?> userInfo) {
    LOGGER.log(Level.FINE, Constants.SETTING_THE, "user info");
    getImplementation().setUserInfo(userInfo);
    return this;
  }

  @Override
  protected UriSetter createImplementation() {
    return new UriImpl();
  }
}
